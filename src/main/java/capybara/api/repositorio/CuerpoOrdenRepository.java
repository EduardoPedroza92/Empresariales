package capybara.api.repositorio;

import capybara.api.model.CuerpoOrden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuerpoOrdenRepository extends JpaRepository<CuerpoOrden, Long> {
    List<CuerpoOrden> findByCabeceraOrden_NumOrden(Long numOrden);
}