package objetos;

import java.math.BigDecimal;

public class Venta {
    private String nombre;
    private BigDecimal precio;

    public Venta(String nombre, BigDecimal precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
