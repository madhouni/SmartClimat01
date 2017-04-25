/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import beans.ReleveMeteo;
import controller.Controller;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class Stationsdata extends JFrame {

    private static final long serialVersionUID = 1L;
 
    
     Controller c =new Controller();
      ArrayList<ReleveMeteo> st =c.getToutStations();
    
     JTable table = new JTable();
     JPanel panoH = new JPanel();
     JPanel panoC = new JPanel();
     JPanel panoB= new JPanel();
     JPanel panoD = new JPanel();
     JPanel panoG = new JPanel();
     //JButton temperature = new JButton("TEMPERATURE");
     
     public Stationsdata(){
     
     setTitle("Stations data");
     setBounds(0,0,900,900);
     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     DefaultTableModel model = new DefaultTableModel();
     Object [] colname = new Object[7];
     
     colname[0]= "ID";
     colname[1]= "ANNEE";
     colname[2]= "MOIS";
     colname[3]= "JOUR";
     colname[4]= "Temperature en Kelvin ( Celsius )";
     colname[5]= "Humidite";
     colname[6]= "Nébulosité ( % ) ";
     
     model.setColumnIdentifiers(colname);
     Object [] rowdata = new Object[7];
     
         
     for(ReleveMeteo s : st)
     {
        rowdata[0] = s.getId();
       //double cels = Double.parseDouble(s.getTemperature()) - 273.15;
       rowdata[1] = s.getAnnee().getAnnee();
       rowdata[2] = s.getMois().getMois();
       rowdata[3] = s.getJour().getJour();
        rowdata[4] = s.getTemperature() + " ( " +  " "/*cels*/ + " ) " ;
        rowdata[5] = s.getHumidite();
        rowdata[6] = s.getNebulosite();
        
        model.addRow(rowdata);
     }
     
     
     table.setModel(model);
     table.setBounds(0, 0, 300, 300);
     JScrollPane pane = new JScrollPane(table);
     panoC.add(pane);
     //panoH.add(temperature);
     
     
    
     
     
     
     getContentPane().add(panoH,BorderLayout.NORTH);
     getContentPane().add(panoC,BorderLayout.WEST);
     getContentPane().add(panoB,BorderLayout.SOUTH);
     getContentPane().add(panoG,BorderLayout.CENTER);
     getContentPane().add(panoD,BorderLayout.EAST);
         
 }
public static void main(String []args){
     
    
   // new Stationsdata().setVisible(true);
    
    
}







    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
