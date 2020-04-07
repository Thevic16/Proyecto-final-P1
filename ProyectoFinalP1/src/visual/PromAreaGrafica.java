package visual;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import logico.Centro;

public class PromAreaGrafica extends JFrame{
    JPanel panel;
    private Centro centro;
    
    public PromAreaGrafica(Centro centro){
    	this.centro = centro;
        setTitle("Grafica promedio de areas figuras");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        init();
    }
 
    private void init() {
        panel = new JPanel();
        getContentPane().add(panel);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // Fuente de Datos
        if(centro.isLoginAdmin()) {
            dataset.setValue(centro.promedioAreaCilindros(), "Cilindro", "Promedio Area total");
            dataset.setValue(centro.promedioAreaConos(), "Cono", "Promedio Area total");
            dataset.setValue(centro.promedioAreaCubos(), "Cubo", "Promedio Area total");
            dataset.setValue(centro.promedioAreaEsferas(), "Esfera", "Promedio Area total");
            dataset.setValue(centro.promedioVolumenParalelepipedos(), "Paralelepípedo", "Promedio Area total");
        }
        else {
            dataset.setValue(centro.getLoginUser().promedioAreaCilindros(), "Cilindro", "Promedio Area total");
            dataset.setValue(centro.getLoginUser().promedioAreaConos(), "Cono", "Promedio Area total");
            dataset.setValue(centro.getLoginUser().promedioAreaCubos(), "Cubo", "Promedio Area total");
            dataset.setValue(centro.getLoginUser().promedioAreaEsferas(), "Esfera", "Promedio Area total");
            dataset.setValue(centro.getLoginUser().promedioVolumenParalelepipedos(), "Paralelepípedo", "Promedio Area total");
        	
        }


        // Creando el Grafico
        JFreeChart chart = ChartFactory.createBarChart3D
        ("Areas de figuras por tipo","Tipos de figuras", "Magnitud del area promedio", 
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
