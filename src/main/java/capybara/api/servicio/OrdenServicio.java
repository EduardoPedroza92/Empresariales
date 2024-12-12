package capybara.api.servicio;

import capybara.api.model.CabeceraOrden;
import capybara.api.model.CuerpoOrden;
import capybara.api.repositorio.CabeceraOrdenRepository;
import capybara.api.repositorio.CuerpoOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrdenServicio {
    @Autowired
    private CabeceraOrdenRepository cabeceraOrdenRepository;

    @Autowired
    private CuerpoOrdenRepository cuerpoOrdenRepository;

    // Obtener todas las cabeceras
    public List<CabeceraOrden> getAllCabeceras() {
        return cabeceraOrdenRepository.findAll();
    }

    // Obtener cabecera por ID
    public Optional<CabeceraOrden> getCabeceraById(Long numOrden) {
        return cabeceraOrdenRepository.findById(numOrden);
    }

    // Crear nueva cabecera
    public CabeceraOrden createCabecera(CabeceraOrden cabeceraOrden) {
        return cabeceraOrdenRepository.save(cabeceraOrden);
    }

    // Actualizar cabecera existente
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

    // Eliminar cabecera
    public void deleteCabecera(Long numOrden) {
        cabeceraOrdenRepository.deleteById(numOrden);
    }

    // Obtener cuerpos de una cabecera específica
    public List<CuerpoOrden> getCuerposByCabecera(Long numOrden) {
        return cuerpoOrdenRepository.findByCabeceraOrden_NumOrden(numOrden);
    }

    // Agregar un cuerpo a una cabecera
    public CuerpoOrden addCuerpoToCabecera(Long numOrden, CuerpoOrden cuerpoOrden) {
        CabeceraOrden cabecera = cabeceraOrdenRepository.findById(numOrden)
                .orElseThrow(() -> new RuntimeException("Cabecera no encontrada"));

        cuerpoOrden.setCabeceraOrden(cabecera);
        return cuerpoOrdenRepository.save(cuerpoOrden);
    }

    // Nuevo método: Obtener el total de precio de todos los productos vendidos
    public Double obtenerTotalPrecioProductos(){
        return cabeceraOrdenRepository.obtenerSumaTotalPrecio();
    }

    public CuerpoOrden obtenerNombreProductoMasVendido() {
        List<CuerpoOrden> cuerposOrden = cuerpoOrdenRepository.findAll();
        return cuerposOrden.stream()
                .collect(Collectors.groupingBy(CuerpoOrden::getNombreProducto,
                        Collectors.summingInt(CuerpoOrden::getCantidadProducto)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> {
                    CuerpoOrden productoMasVendido = new CuerpoOrden();
                    productoMasVendido.setNombreProducto(entry.getKey());
                    productoMasVendido.setCantidadProducto(entry.getValue());
                    return productoMasVendido;
                })
                .orElse(null);
    }
    
    // Obtener el top 5 productos más vendidos
    public List<CuerpoOrden> obtenerTop5NombresProductosMasVendidos() {
        List<CuerpoOrden> cuerposOrden = cuerpoOrdenRepository.findAll();
    
        // Encuentra los 5 productos con mayor cantidad vendida
        return cuerposOrden.stream()
                .collect(Collectors.groupingBy(CuerpoOrden::getNombreProducto,
                        Collectors.summingInt(CuerpoOrden::getCantidadProducto)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) 
                .limit(5) 
                .map(entry -> {
                    CuerpoOrden topProduct = new CuerpoOrden();
                    topProduct.setNombreProducto(entry.getKey());
                    topProduct.setCantidadProducto(entry.getValue());
                    return topProduct;
                })
                .collect(Collectors.toList());
    }
    

    // Nuevo método: Ganancias totales
    public Double obtenerGananciasTotales() {
        List<CabeceraOrden> cabeceras = cabeceraOrdenRepository.findAll();
        return cabeceras.stream()
                .mapToDouble(CabeceraOrden::getTotalPrecio)
                .sum();
    }

}
