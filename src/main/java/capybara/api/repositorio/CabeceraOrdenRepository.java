package capybara.api.repositorio;

import capybara.api.model.CabeceraOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CabeceraOrdenRepository extends JpaRepository<CabeceraOrden, Long> {
        
    @Query("SELECT SUM(c.totalPrecio) FROM CabeceraOrden c")
    Double obtenerSumaTotalPrecio();

}
