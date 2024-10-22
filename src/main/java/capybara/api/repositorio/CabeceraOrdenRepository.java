package capybara.api.repositorio;

import capybara.api.model.CabeceraOrden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabeceraOrdenRepository extends JpaRepository<CabeceraOrden, Long> {
}
