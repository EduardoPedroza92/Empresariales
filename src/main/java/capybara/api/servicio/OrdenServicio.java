package capybara.api.servicio;

import capybara.api.model.CabeceraOrden;
import capybara.api.model.CuerpoOrden;
import capybara.api.repositorio.CabeceraOrdenRepository;
import capybara.api.repositorio.CuerpoOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenServicio {
    @Autowired
    private CabeceraOrdenRepository cabeceraOrdenRepository;

    @Autowired
    private CuerpoOrdenRepository cuerpoOrdenRepository;

    public List<CabeceraOrden> getAllCabeceras() {
        return cabeceraOrdenRepository.findAll();
    }

    public Optional<CabeceraOrden> getCabeceraById(Long numOrden) {
        return cabeceraOrdenRepository.findById(numOrden);
    }

    public CabeceraOrden createCabecera(CabeceraOrden cabeceraOrden) {
        return cabeceraOrdenRepository.save(cabeceraOrden);
    }

    public CabeceraOrden updateCabecera(Long numOrden, CabeceraOrden updatedCabecera) {
        return cabeceraOrdenRepository.findById(numOrden)
                .map(cabecera -> {
                    cabecera.setUsuarios(updatedCabecera.getUsuarios());
                    cabecera.setTotalPrecio(updatedCabecera.getTotalPrecio());
                    cabecera.setPropina(updatedCabecera.getPropina());
                    cabecera.setFecha(updatedCabecera.getFecha());
                    cabecera.setHora(updatedCabecera.getHora());
                    return cabeceraOrdenRepository.save(cabecera);
                })
                .orElseThrow(() -> new RuntimeException("Cabecera no encontrada"));
    }

    public void deleteCabecera(Long numOrden) {
        cabeceraOrdenRepository.deleteById(numOrden);
    }

    public List<CuerpoOrden> getCuerposByCabecera(Long numOrden) {
        return cuerpoOrdenRepository.findByCabeceraOrden_NumOrden(numOrden);
    }

    public CuerpoOrden addCuerpoToCabecera(Long numOrden, CuerpoOrden cuerpoOrden) {
        CabeceraOrden cabecera = cabeceraOrdenRepository.findById(numOrden)
                .orElseThrow(() -> new RuntimeException("Cabecera no encontrada"));
        cuerpoOrden.setCabeceraOrden(cabecera);
        return cuerpoOrdenRepository.save(cuerpoOrden);
    }

    public List<CuerpoOrden> getCuerposById(Long numOrden) {
        return List.of();
    }
}
