package capybara.api.controlador;

import capybara.api.model.CabeceraOrden;
import capybara.api.model.CuerpoOrden;
import capybara.api.servicio.OrdenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orden")
public class OrdenControlador {
    @Autowired
    private OrdenServicio OrdenServicio;

    @GetMapping
    public List<CabeceraOrden> getAllCabeceras() {
        return OrdenServicio.getAllCabeceras();
    }

    @GetMapping("/{numOrden}")
    public Optional<CabeceraOrden> getCabeceraById(@PathVariable Long numOrden) {
        return OrdenServicio.getCabeceraById(numOrden);
    }

    @PostMapping
    public CabeceraOrden createCabecera(@RequestBody CabeceraOrden cabeceraOrden) {
        return OrdenServicio.createCabecera(cabeceraOrden);
    }

    @PutMapping("/{numOrden}")
    public CabeceraOrden updateCabecera(@PathVariable Long numOrden, @RequestBody CabeceraOrden cabeceraOrden) {
        return OrdenServicio.updateCabecera(numOrden, cabeceraOrden);
    }

    @DeleteMapping("/{numOrden}")
    public void deleteCabecera(@PathVariable Long numOrden) {
        OrdenServicio.deleteCabecera(numOrden);
    }

    @GetMapping("/{numOrden}/cuerpos")
    public List<CuerpoOrden> getCuerposByCabecera(@PathVariable Long numOrden) {
        return OrdenServicio.getCuerposByCabecera(numOrden);
    }

    @PostMapping("/{numOrden}/cuerpos")
    public CuerpoOrden addCuerpoToCabecera(@PathVariable Long numOrden, @RequestBody CuerpoOrden cuerpoOrden) {
        return OrdenServicio.addCuerpoToCabecera(numOrden, cuerpoOrden);
    }
    
}
