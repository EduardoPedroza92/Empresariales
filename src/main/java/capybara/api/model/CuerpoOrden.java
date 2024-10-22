package capybara.api.model;

import jakarta.persistence.*;


@Entity
public class CuerpoOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuerpo;
    private Long idProducto;
    private String nombreProducto;
    private Integer cantidadProducto;

    @ManyToOne
    @JoinColumn(name = "numOrden")
    private CabeceraOrden cabeceraOrden;

    public void setCabeceraOrden(CabeceraOrden cabecera) {
    }

    // Getters, Setters, Constructors (usando Lombok si está configurado)
}
