package model;

import objetos.Venta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VentaModel {
    public List<Venta> findAll(){
        List<Venta> listVentas = new ArrayList<Venta>();
        listVentas.add(new Venta("Colacao", new BigDecimal(4)));
        listVentas.add(new Venta("Puré", new BigDecimal(3)));
        listVentas.add(new Venta("Marisco", new BigDecimal(11)));
        listVentas.add(new Venta("Paté", new BigDecimal(8)));
        return listVentas;
    }

}
