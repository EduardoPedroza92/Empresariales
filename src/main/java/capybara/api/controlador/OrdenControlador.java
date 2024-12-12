package capybara.api.controlador;

import capybara.api.model.CabeceraOrden;
import capybara.api.model.CuerpoOrden;
import capybara.api.servicio.OrdenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/orden")
public class OrdenControlador {
    @Autowired
    private OrdenServicio ordenServicio;

    @GetMapping
    public List<CabeceraOrden> getAllCabeceras() {
        return ordenServicio.getAllCabeceras();
    }

    @GetMapping("/{numOrden}")
    public Optional<CabeceraOrden> getCabeceraById(@PathVariable Long numOrden) {
        return ordenServicio.getCabeceraById(numOrden);
    }

    @PostMapping
    public CabeceraOrden createCabecera(@RequestBody CabeceraOrden cabeceraOrden) {
        return ordenServicio.createCabecera(cabeceraOrden);
    }

    @PutMapping("/{numOrden}")
    public CabeceraOrden updateCabecera(@PathVariable Long numOrden, @RequestBody CabeceraOrden cabeceraOrden) {
        return ordenServicio.updateCabecera(numOrden, cabeceraOrden);
    }

    @DeleteMapping("/{numOrden}")
    public void deleteCabecera(@PathVariable Long numOrden) {
        ordenServicio.deleteCabecera(numOrden);
    }

    @GetMapping("/{numOrden}/cuerpos")
    public List<CuerpoOrden> getCuerposByCabecera(@PathVariable Long numOrden) {
        return ordenServicio.getCuerposByCabecera(numOrden);
    }

    @PostMapping("/{numOrden}/cuerpos")
    public CuerpoOrden addCuerpoToCabecera(@PathVariable Long numOrden, @RequestBody CuerpoOrden cuerpoOrden) {
        return ordenServicio.addCuerpoToCabecera(numOrden, cuerpoOrden);
    }

    // Nuevo GET: Obtener el total de precio de todos los productos vendidos
    @GetMapping("/total-ventas")
    public Double obtenerTotalPrecioProductos() {
        return ordenServicio.obtenerTotalPrecioProductos();
    }

    // Nuevo GET: Obtener el producto más vendido
    @GetMapping("/producto-mas-vendido")
    public CuerpoOrden obtenerNombreProductoMasVendido() {
        return ordenServicio.obtenerNombreProductoMasVendido();
    }
    
    //Nuevo GET: Obtener los primeros 5 productos mas vendidos
    @GetMapping("/top-5-productos")
    public List<CuerpoOrden> obtenerTop5NombresProductosMasVendidos() {
        return ordenServicio.obtenerTop5NombresProductosMasVendidos();
    }
    
    // Nuevo GET para las ganancias totales
    @GetMapping("/ganancias-totales")
    public Double obtenerGananciasTotales() {
        return ordenServicio.obtenerGananciasTotales();
    }
}


