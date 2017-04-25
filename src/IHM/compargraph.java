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
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.Dataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author zmadh
 * affichage des comparaisons des courbes
 */
public class compargraph extends JFrame {
    
    private static final long serialVersionUID = 1L;

    /**
     * premiere liste dans la comparaison 
     */
    public static ArrayList<ReleveMeteo> t1= new ArrayList<>();

    /**
     *deuxiéme liste dans la comparaison 
     */
    public  ArrayList<ReleveMeteo> t2= new ArrayList<>();

    /**
     * ce qu'on va comparer donc soit nebu soit humid soit temp
     */
    public String c;
      
    /**
     *
     * @param title
     * @param c1
     * @param c2
     * @param comp
     * 
     */
    public compargraph(String title,ArrayList<ReleveMeteo> c1,ArrayList<ReleveMeteo> c2,String comp) {
        super(title);
        t1=c1;
        t2=c2;
        c = comp;
        
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
           
      XYSeriesCollection dataset1 = new XYSeriesCollection();
      
      if(t1.size()<t2.size()){
    if(c=="Temperature"){ 
            XYSeries s1 = new XYSeries("Temperature station 1");
            XYSeries s2 = new XYSeries("Temperature station 2");
            XYSeries s3 = new XYSeries("résultante");
     for(int i =0 ;i<t1.size();i++){
           if(t1.get(i).getJour().getJour() == 0){
              s1.add(Double.parseDouble(""+t1.get(i).getMois().getMois()), Double.parseDouble(t1.get(i).getTemperature()));
              s2.add(Double.parseDouble(""+t2.get(i).getMois().getMois()), Double.parseDouble(t2.get(i).getTemperature()));  
              Double d = Double.parseDouble(""+t1.get(i).getMois().getMois()) ;
              if (d<0) d=-d;
               Double f = Double.parseDouble(t1.get(i).getTemperature()) - Double.parseDouble(t2.get(i).getTemperature());
              if (f<0) f=-f;
              s3.add(d,f);
               XYSeriesCollection dataset = new XYSeriesCollection();
               dataset.addSeries(s1);
                 dataset.addSeries(s2);
                 dataset.addSeries(s3);
        
           }
            else{
              s1.add(Double.parseDouble(""+t1.get(i).getJour().getJour()), Double.parseDouble(t1.get(i).getTemperature()));
              s2.add(Double.parseDouble(""+t2.get(i).getJour().getJour()), Double.parseDouble(t2.get(i).getTemperature()));
             Double d = Double.parseDouble(""+t1.get(i).getJour().getJour());
              if (d<0) d=-d;
               Double f = Double.parseDouble(t1.get(i).getTemperature()) - Double.parseDouble(t2.get(i).getTemperature());
              if (f<0) f=-f;
              s3.add(d,f);
               XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);
        dataset.addSeries(s3);
        
       dataset1 = dataset;
           }
          }}
        else if(c=="Humidité"){ 
            XYSeries s1 = new XYSeries("Humidité station 1");
            XYSeries s2 = new XYSeries("Humidité station 2");
             XYSeries s3 = new XYSeries("résultante");
            for(int i =0 ;i<t1.size();i++){
           if(t1.get(i).getJour().getJour() == 0){
              s1.add(Double.parseDouble(""+t1.get(i).getMois().getMois()), Double.parseDouble(t1.get(i).getHumidite()));
              s2.add(Double.parseDouble(""+t2.get(i).getMois().getMois()), Double.parseDouble(t2.get(i).getHumidite()));  
               Double d = Double.parseDouble(""+t1.get(i).getMois().getMois())  ;
              if (d<0) d=-d;
               Double f = Double.parseDouble(t1.get(i).getHumidite()) - Double.parseDouble(t2.get(i).getHumidite());
              if (f<0) f=-f;
              s3.add(d,f);
              XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);
         dataset.addSeries(s3);
        dataset1 = dataset;
           }
            else{
              s1.add(Double.parseDouble(""+t1.get(i).getJour().getJour()), Double.parseDouble(t1.get(i).getHumidite()));
              s2.add(Double.parseDouble(""+t2.get(i).getJour().getJour()), Double.parseDouble(t2.get(i).getHumidite()));
               Double d = Double.parseDouble(""+t1.get(i).getJour().getJour())  ;
              if (d<0) d=-d;
               Double f = Double.parseDouble(t1.get(i).getHumidite()) - Double.parseDouble(t2.get(i).getHumidite());
              if (f<0) f=-f;
              s3.add(d,f);
              XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);
         dataset.addSeries(s3);
        dataset1 = dataset;
           }
          }
        }
        
        else if(c=="Nébulosité"){ 
            XYSeries s1 = new XYSeries("Nébulosité station 1");
            XYSeries s2 = new XYSeries("Nébulosité station 2");
              XYSeries s3 = new XYSeries("résultante");
            for(int i =0 ;i<t1.size();i++){
           if(t1.get(i).getJour().getJour() == 0){
              s1.add(Double.parseDouble(""+t1.get(i).getMois().getMois()), Double.parseDouble(t1.get(i).getNebulosite()));
             s2.add(Double.parseDouble(""+t2.get(i).getMois().getMois()), Double.parseDouble(t2.get(i).getNebulosite()));  
               Double d = Double.parseDouble(""+t1.get(i).getMois().getMois()) ;
              if (d<0) d=-d;
               Double f = Double.parseDouble(t1.get(i).getNebulosite()) - Double.parseDouble(t2.get(i).getNebulosite());
              if (f<0) f=-f;
              s3.add(d,f);  
             XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);
        dataset.addSeries(s3);
        dataset1 = dataset;
           }
            else{
              s1.add(Double.parseDouble(""+t1.get(i).getJour().getJour()), Double.parseDouble(t1.get(i).getNebulosite()));
              s2.add(Double.parseDouble(""+t2.get(i).getJour().getJour()), Double.parseDouble(t2.get(i).getNebulosite()));
               Double d = Double.parseDouble(""+t1.get(i).getJour().getJour())  ;
              if (d<0) d=-d;
               Double f = Double.parseDouble(t1.get(i).getNebulosite()) - Double.parseDouble(t2.get(i).getNebulosite());
              if (f<0) f=-f;
              s3.add(d,f); 
              XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);
        dataset.addSeries(s3);
        dataset1 = dataset;
           }
          }
        }
      }
           // XYSeries s3 = new XYSeries("Nebulosité");
      //  Controller c = new Controller();
       // Controller c2 = new Controller();
       // c.AfficherStationMoyenneTousLesJours();
     
       
      //***************** comparaison temperature 
    
       
       
       if(t2.size()<=t1.size()){
   if(c=="Temperature"){ 
            XYSeries s1 = new XYSeries("Temperature station 1");
            XYSeries s2 = new XYSeries("Temperature tation 2");
            XYSeries s3 = new XYSeries("résultante");
     for(int i =0 ;i<t1.size();i++){
           if(t1.get(i).getJour().getJour() == 0){
              s1.add(Double.parseDouble(""+t1.get(i).getMois().getMois()), Double.parseDouble(t1.get(i).getTemperature()));
              s2.add(Double.parseDouble(""+t2.get(i).getMois().getMois()), Double.parseDouble(t2.get(i).getTemperature()));  
              Double d = Double.parseDouble(""+t1.get(i).getMois().getMois()) ;
              if (d<0) d=-d;
               Double f = Double.parseDouble(t1.get(i).getTemperature()) - Double.parseDouble(t2.get(i).getTemperature());
              if (f<0) f=-f;
              s3.add(d,f);
               XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);
        dataset.addSeries(s3);
        
           }
            else{
              s1.add(Double.parseDouble(""+t1.get(i).getJour().getJour()), Double.parseDouble(t1.get(i).getTemperature()));
              s2.add(Double.parseDouble(""+t2.get(i).getJour().getJour()), Double.parseDouble(t2.get(i).getTemperature()));
             Double d = Double.parseDouble(""+t1.get(i).getJour().getJour());
              if (d<0) d=-d;
               Double f = Double.parseDouble(t1.get(i).getTemperature()) - Double.parseDouble(t2.get(i).getTemperature());
              if (f<0) f=-f;
              s3.add(d,f);
               XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);
        dataset.addSeries(s3);
       dataset1 = dataset;
       
           }
          }}
        else if(c=="Humidité"){ 
            XYSeries s1 = new XYSeries("Humidité station 1");
            XYSeries s2 = new XYSeries("Humidité station 2");
             XYSeries s3 = new XYSeries("résultante");
            for(int i =0 ;i<t1.size();i++){
           if(t1.get(i).getJour().getJour() == 0){
              s1.add(Double.parseDouble(""+t1.get(i).getMois().getMois()), Double.parseDouble(t1.get(i).getHumidite()));
              s2.add(Double.parseDouble(""+t2.get(i).getMois().getMois()), Double.parseDouble(t2.get(i).getHumidite()));  
               Double d = Double.parseDouble(""+t1.get(i).getMois().getMois())  ;
              if (d<0) d=-d;
               Double f = Double.parseDouble(t1.get(i).getHumidite()) - Double.parseDouble(t2.get(i).getHumidite());
              if (f<0) f=-f;
              s3.add(d,f);
              XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);
         dataset.addSeries(s3);
        dataset1 = dataset;
           }
            else{
              s1.add(Double.parseDouble(""+t1.get(i).getJour().getJour()), Double.parseDouble(t1.get(i).getHumidite()));
              s2.add(Double.parseDouble(""+t2.get(i).getJour().getJour()), Double.parseDouble(t2.get(i).getHumidite()));
               Double d = Double.parseDouble(""+t1.get(i).getJour().getJour())  ;
              if (d<0) d=-d;
               Double f = Double.parseDouble(t1.get(i).getHumidite()) - Double.parseDouble(t2.get(i).getHumidite());
              if (f<0) f=-f;
              s3.add(d,f);
              XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);
         dataset.addSeries(s3);
        dataset1 = dataset;
           }
          }
        }
        
        else if(c=="Nébulosité"){ 
            XYSeries s1 = new XYSeries("Nébulosité station 1");
            XYSeries s2 = new XYSeries("Nébulosité station 2");
              XYSeries s3 = new XYSeries("résultante");
            for(int i =0 ;i<t1.size();i++){
           if(t1.get(i).getJour().getJour() == 0){
              s1.add(Double.parseDouble(""+t1.get(i).getMois().getMois()), Double.parseDouble(t1.get(i).getNebulosite()));
             s2.add(Double.parseDouble(""+t2.get(i).getMois().getMois()), Double.parseDouble(t2.get(i).getNebulosite()));  
               Double d = Double.parseDouble(""+t1.get(i).getMois().getMois()) ;
              if (d<0) d=-d;
               Double f = Double.parseDouble(t1.get(i).getNebulosite()) - Double.parseDouble(t2.get(i).getNebulosite());
              if (f<0) f=-f;
              s3.add(d,f);  
             XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);
        dataset.addSeries(s3);
        dataset1 = dataset;
           }
            else{
              s1.add(Double.parseDouble(""+t1.get(i).getJour().getJour()), Double.parseDouble(t1.get(i).getNebulosite()));
              s2.add(Double.parseDouble(""+t2.get(i).getJour().getJour()), Double.parseDouble(t2.get(i).getNebulosite()));
               Double d = Double.parseDouble(""+t1.get(i).getJour().getJour())  ;
              if (d<0) d=-d;
               Double f = Double.parseDouble(t1.get(i).getNebulosite()) - Double.parseDouble(t2.get(i).getNebulosite());
              if (f<0) f=-f;
              s3.add(d,f); 
              XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);
        dataset.addSeries(s3);
        dataset1 = dataset;
           }
          }
        }
      }
       
       /*for (ReleveMeteo i : t1.getStationRecherchee())
        {
            System.out.println(i.getTemperature());   
          if(i.getJour().getJour() == 0){
              s1.add(Double.parseDouble(""+i.getMois().getMois()), Double.parseDouble(i.getTemperature()));
        // s2.add(Double.parseDouble(""+i.getMois().getMois()), Double.parseDouble(i.getHumidite()));
         //s3.add(Double.parseDouble(""+i.getMois().getMois()), Double.parseDouble(i.getNebulosite()));
          }
          else{
              s1.add(Double.parseDouble(""+i.getJour().getJour()), Double.parseDouble(i.getTemperature()));
         //s2.add(Double.parseDouble(""+i.getJour().getJour()), Double.parseDouble(i.getHumidite()));
         //s3.add(Double.parseDouble(""+i.getJour().getJour()), Double.parseDouble(i.getNebulosite()));
          }
          
        }  
        
         for (ReleveMeteo i : t2.getStationRecherchee())
        {
            System.out.println(i.getTemperature());   
          if(i.getJour().getJour() == 0){
              s2.add(Double.parseDouble(""+i.getMois().getMois()), Double.parseDouble(i.getTemperature()));
        // s2.add(Double.parseDouble(""+i.getMois().getMois()), Double.parseDouble(i.getHumidite()));
         //s3.add(Double.parseDouble(""+i.getMois().getMois()), Double.parseDouble(i.getNebulosite()));
          }
          else{
              s2.add(Double.parseDouble(""+i.getJour().getJour()), Double.parseDouble(i.getTemperature()));
         //s2.add(Double.parseDouble(""+i.getJour().getJour()), Double.parseDouble(i.getHumidite()));
         //s3.add(Double.parseDouble(""+i.getJour().getJour()), Double.parseDouble(i.getNebulosite()));
          }
          
        }  
        */
        
        
        
        
        
       return dataset1;
      //  dataset.addSeries(s3);
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

