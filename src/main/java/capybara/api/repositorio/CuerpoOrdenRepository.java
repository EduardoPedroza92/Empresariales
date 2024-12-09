package capybara.api.repositorio;

import capybara.api.model.CuerpoOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuerpoOrdenRepository extends JpaRepository<CuerpoOrden, Long> {
    List<CuerpoOrden> findByCabeceraOrden_NumOrden(Long numOrden);

    // Método para obtener los 5 productos más vendidos (por cantidad)
    List<CuerpoOrden> findTop5ByOrderByCantidadProductoDesc();
    
    // Método para obtener todos los cuerpos de orden (útil para obtener ventas totales)
    List<CuerpoOrden> findAll();
}
