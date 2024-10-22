package capybara.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class CabeceraOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numOrden;
    private String usuarios;
    private Double totalPrecio;
    private Double propina;
    private LocalDate fecha;
    private LocalTime hora;

}
