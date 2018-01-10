import model.VentaModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import objetos.Venta;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Informe extends JFrame {

    private HashMap<String, Object> hm;
    private JPanel contentPane;

    public Informe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(240,800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);
        crearInforme();
    }


    private void crearInforme() {
        try {
            VentaModel ventaModel = new VentaModel();
            List<Map<String, ?>> dataSource = new ArrayList<>();
            for (Venta venta : ventaModel.findAll()){
                Map<String, Object> m = new HashMap<>();
                m.put("nombre", venta.getNombre());
                m.put("precio", venta.getPrecio());
                dataSource.add(m);
            }

            JRDataSource jrds = new JRBeanCollectionDataSource(dataSource);
            JasperReport report = (JasperReport)
                    JRLoader.loadObject(this.getClass().getClassLoader().getResourceAsStream("reports/informe.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, null, jrds);

            /**
             * Muestra una preview de la impresión
             */
            net.sf.jasperreports.swing.JRViewer jRViewer = new net.sf.jasperreports.swing.JRViewer(jasperPrint);

            /**
             * No muestra preview de la impresion
             */
//            JasperPrintManager.printReport(jasperPrint,false);

            this.getContentPane().add(jRViewer);
            this.setLocationRelativeTo(null);
            this.setVisible(true);

        } catch (JRException e) {
            e.printStackTrace();
        }

    }

}
