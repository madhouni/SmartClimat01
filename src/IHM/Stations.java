/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import beans.Station;
import java.awt.BorderLayout;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.Controller;


public class Stations extends JFrame {

    private static final long serialVersionUID = 1L;
 
    
     //ArrayList<Station> st = dataload.stations;
     Controller c = new Controller();
     ArrayList<Station> st = c.getStations();
     JTable table = new JTable();
     JPanel panoH = new JPanel();
     JPanel panoC = new JPanel();
     JPanel panoB= new JPanel();
     JPanel panoD = new JPanel();
     JPanel panoG = new JPanel();
     
     public Stations(){
     
     setTitle("Stations data");
     setBounds(0,0,900,900);
     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     DefaultTableModel model = new DefaultTableModel();
     Object [] colname = new Object[5];
     colname[0]= "ID";
     colname[1]= "NOM";
     colname[2]= "LATITUDE";
     colname[3]= "LONGITUDE";
     colname[4]= "ALTITUDE";
     model.setColumnIdentifiers(colname);
     Object [] rowdata = new Object[5];
     for(Station s : st){
        rowdata[0] = s.getId();
        rowdata[1] = s.getNom();
        rowdata[2] = s.getLatitude();
        rowdata[3] = s.getLongitude();
        rowdata[4] = s.getAltitude();
        model.addRow(rowdata);
        
       }
     table.setModel(model);
     JScrollPane pane = new JScrollPane(table);
     panoC.add(pane);
     int h = table.getSelectedRow();
    
     
     
     
     getContentPane().add(panoH,BorderLayout.NORTH);
     getContentPane().add(panoC,BorderLayout.CENTER);
     getContentPane().add(panoB,BorderLayout.SOUTH);
     getContentPane().add(panoG,BorderLayout.WEST);
     getContentPane().add(panoD,BorderLayout.EAST);
         
 }
/*public static void main(String []args){
     
 new Stations().setVisible(true);
    
    
    
}
*/









}