/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

/**
 *
 * @author zmadh
 */
import beans.ReleveMeteo;
import controller.Controller;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author zmadh
 * class qui permet l'affichage des graphes
 */
public class NewClass extends JFrame {
    
    private static final long serialVersionUID = 1L;
    Controller c = new Controller();
      
    /**
     *
     * @param title
     */
    public NewClass(String title /*,*JInternalFrame jp*/) {
        super(title);
       // jp = new JInternalFrame("courbes");
        
        JFreeChart chart = createChart(createDataset());
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(500, 300));
        setContentPane(panel);
      //  jp.add(panel, BorderLayout.EAST);
      //  jp.setVisible(true);
        panel.setVisible(true);
          XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        plot.setRenderer(renderer);
        renderer.setSeriesPaint(0, Color.RED);
renderer.setSeriesPaint(1, Color.GREEN);
renderer.setSeriesPaint(2, Color.YELLOW);
// sets thickness for series (using strokes)
renderer.setSeriesStroke(0, new BasicStroke(4.0f));
renderer.setSeriesStroke(1, new BasicStroke(3.0f));
renderer.setSeriesStroke(2, new BasicStroke(2.0f));
plot.setRenderer(renderer);
plot.setOutlinePaint(Color.BLUE);
plot.setOutlineStroke(new BasicStroke(2.0f));
plot.setBackgroundPaint(Color.DARK_GRAY);
plot.setRangeGridlinesVisible(true);
plot.setRangeGridlinePaint(Color.BLACK);
plot.setDomainGridlinesVisible(true);
plot.setDomainGridlinePaint(Color.BLACK);
       
        
       
    }

    private XYDataset createDataset() {
            XYSeries s1 = new XYSeries("Temperature");
            XYSeries s2 = new XYSeries("Humidité");
            XYSeries s3 = new XYSeries("Nebulosité");
        Controller c = new Controller();
       // c.AfficherStationMoyenneTousLesJours();
        for (ReleveMeteo i : c.getStationRecherchee())
        {
            System.out.println(i.getTemperature());   
          if(i.getJour().getJour() == 0){
              s1.add(Double.parseDouble(""+i.getMois().getMois()), Double.parseDouble(i.getTemperature()));
         s2.add(Double.parseDouble(""+i.getMois().getMois()), Double.parseDouble(i.getHumidite()));
         s3.add(Double.parseDouble(""+i.getMois().getMois()), Double.parseDouble(i.getNebulosite()));
          }
          else{
              s1.add(Double.parseDouble(""+i.getJour().getJour()), Double.parseDouble(i.getTemperature()));
         s2.add(Double.parseDouble(""+i.getJour().getJour()), Double.parseDouble(i.getHumidite()));
         s3.add(Double.parseDouble(""+i.getJour().getJour()), Double.parseDouble(i.getNebulosite()));
          }
          
        }  
        
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);
        dataset.addSeries(s3);
        
        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "", "", "", dataset);
        //chart.removeLegend();
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesShape(0, new Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0));
        renderer.setSeriesFillPaint(0, Color.WHITE);
        renderer.setUseFillPaint(true);
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return chart;
    }

    /*public static void main(String[] args) {
        JFrame app = new NewClass("JFreeChart");
        app.pack();
        app.setVisible(true);
    }*/
    
    
    
}

