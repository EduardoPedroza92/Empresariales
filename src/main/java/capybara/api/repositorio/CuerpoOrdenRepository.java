package capybara.api.repositorio;

import capybara.api.model.CuerpoOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuerpoOrdenRepository extends JpaRepository<CuerpoOrden, Long> {
    List<CuerpoOrden> findByCabeceraOrden_NumOrden(Long numOrden);

    
    List<CuerpoOrden> findTop5ByOrderByCantidadProductoDesc();
    
    
    List<CuerpoOrden> findAll();
}
