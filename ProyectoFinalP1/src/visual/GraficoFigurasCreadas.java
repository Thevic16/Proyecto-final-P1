package visual;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import logico.Centro;
import logico.Figura;

public class GraficoFigurasCreadas extends JDialog{
    JPanel panel;
    private Centro centro;
    
    public GraficoFigurasCreadas(Centro centro){
    	this.centro = centro;
        setTitle("Gráfica pastel de las figuras creadas por cantidad.");
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        init();
    }
 
    private void init() {
        panel = new JPanel();
        getContentPane().add(panel);
        // Fuente de Datos
        DefaultPieDataset data = new DefaultPieDataset();
        
        if(centro.isLoginAdmin()) {
            int[]cantidades = centro.getCantidadFigurasByTipo();
            data.setValue("Cilindro", cantidades[0]);
            data.setValue("Cono", cantidades[1]);
            data.setValue("Cubo", cantidades[2]);
            data.setValue("Esfera", cantidades[3]);
            data.setValue("Paralelepípedo", cantidades[4]);
        }
        else {
            int[]cantidades = centro.getLoginUser().getCantidadFigurasByTipo();
            data.setValue("Cilindro", cantidades[0]);
            data.setValue("Cono", cantidades[1]);
            data.setValue("Cubo", cantidades[2]);
            data.setValue("Esfera", cantidades[3]);
            data.setValue("Paralelepípedo", cantidades[4]);
        }

 
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
         "Gráfica", 
         data, 
         true, 
         true, 
         false);
 
        // Crear el Panel del Grafico con ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }
    
    
}
