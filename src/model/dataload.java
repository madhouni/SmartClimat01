
package model;


import beans.Mois;
import beans.Jour;
import beans.Annee;
import beans.ReleveMeteo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import beans.Station;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zmadh
 */
public class dataload {
    
    /**
     *liste contenat les tations et leurs ids ainsi que l'altitude ...
     */
    public static ArrayList<Station> stations;

    /**
     * liste contenant tous les données se trouvant dans le fichier qu'on téléharge 
     */
    public static ArrayList<ReleveMeteo> stationsinfo;
    
    /**
     * repmlissage de la liste station donc extraction des noms ainsi que des ids des stations 
     */
    public void load(){
       stations = new ArrayList<>();
       
       
      String [] values = null;
      String f = "stations.csv" ;
       //String f = DownloadFile.filename ;
      File file = new File(f);
        try {
            Scanner sc = new Scanner(file);
            sc.next();
            while(sc.hasNext()){
            String data = sc.next();
            values = data.split(";");
            double latitude = Double.parseDouble(values[2]);
            double longitude = Double.parseDouble(values[3]);
            int id = Integer.parseInt(values[0]);
            int altitude =Integer.parseInt(values[4]); 
            Station s = new Station(id,values[1],latitude,longitude,altitude);
            stations.add(s);
          
               
                
                
                
            }
            
            //sc.close();
            
            
        } catch (FileNotFoundException ex) {
           
            
        }
       
       
       
       
       
   }
    
    /**
     *
     * @param mois
     * @param annee
     * remplissage de stainfo ce qui fait extraction des données du fichier téléchargé 
     */
    public void loading(String mois , String annee){
     stationsinfo = new ArrayList<>();
       int k ;
       if(mois == "") k = 12;
       else {k = 1;}
       String m =null;
       
       for(int i = 1;i<k+1;i++){
       ReleveMeteo releve; 
      
     
     String [] values;
          if(k==1)  m = mois;
          else {
              if (i<10) {m =""+0+i;} 
              else {m=""+i;}  
          }
     String an =annee;
     String f =an+m+".csv" ;
      
      File file = new File(f);
      
       
            Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(dataload.class.getName()).log(Level.SEVERE, null, ex);
        }
            sc.next();
            while(sc.hasNext()){
            String data = sc.next();
            values = data.split(";");
            int id = Integer.parseInt(values[0]);
            Annee ann = new Annee(Integer.parseInt(values[1].substring(0, 4)));
            Mois mo = new Mois(Integer.parseInt(values[1].substring(4, 6)));
            Jour jr = new Jour(Integer.parseInt(values[1].substring(6, 8)));
            releve = new ReleveMeteo(id,ann,mo,jr,values[7],values[9] ,values[14] );
            stationsinfo.add(releve);
            }
   }
            
         }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
    





}
