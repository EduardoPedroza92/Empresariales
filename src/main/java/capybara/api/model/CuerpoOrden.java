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
    @JoinColumn(name = "num_orden")
    private CabeceraOrden cabeceraOrden;

 
    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public CabeceraOrden getCabeceraOrden() {
        return cabeceraOrden;
    }

    public void setCabeceraOrden(CabeceraOrden cabeceraOrden) {
        this.cabeceraOrden = cabeceraOrden;
    }
}
