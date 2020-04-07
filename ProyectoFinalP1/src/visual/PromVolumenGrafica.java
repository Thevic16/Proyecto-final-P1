package visual;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import logico.Centro;

public class PromVolumenGrafica extends JDialog{
    JPanel panel;
    private Centro centro;
    
    public PromVolumenGrafica(Centro centro){
    	this.centro = centro;
        setTitle("Grafica promedio de volumen figuras");
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        init();
    }
 
    private void init() {
        panel = new JPanel();
        getContentPane().add(panel);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // Fuente de Datos
        if(centro.isLoginAdmin()) {
            dataset.setValue(centro.promedioVolumenCilindros(), "Cilindro", "Promedio Volumen total");
            dataset.setValue(centro.promedioVolumenConos(), "Cono", "Promedio Volumen total");
            dataset.setValue(centro.promedioVolumenCubo(), "Cubo", "Promedio Volumen total");
            dataset.setValue(centro.promedioVolumenEsferas(), "Esfera", "Promedio Volumen total");
            dataset.setValue(centro.promedioVolumenParalelepipedos(), "Paralelepípedo", "Promedio Volumen total");
        }
        else {
            dataset.setValue(centro.getLoginUser().promedioVolumenCilindros(), "Cilindro", "Promedio Volumen total");
            dataset.setValue(centro.getLoginUser().promedioVolumenConos(), "Cono", "Promedio Volumen total");
            dataset.setValue(centro.getLoginUser().promedioVolumenCubo(), "Cubo", "Promedio Volumen total");
            dataset.setValue(centro.getLoginUser().promedioVolumenEsferas(), "Esfera", "Promedio Volumen total");
            dataset.setValue(centro.getLoginUser().promedioVolumenParalelepipedos(), "Paralelepípedo", "Promedio Volumen total");
        	
        }


        // Creando el Grafico
        JFreeChart chart = ChartFactory.createBarChart3D
        ("Volumenes de figuras por tipo","Tipos de figuras", "Magnitud del volumen promedio", 
        dataset, PlotOrientation.VERTICAL, true,true, false);
        chart.setBackgroundPaint(Color.cyan);
        chart.getTitle().setPaint(Color.black); 
        CategoryPlot p = chart.getCategoryPlot(); 
        p.setRangeGridlinePaint(Color.red); 
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }
    
}