/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import beans.Annee;
import beans.Jour;
import beans.Mois;
import beans.ReleveMeteo;
import beans.Station;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zmadh
 */
public class DonneeStation {
    
    
      

    
  private static int  x ;

    /**
     * liste utilisée por recuperer la ligne de la station dont le nom 
     * est equivaut à celui donné en parametre pour pouvoir recuperer l 'id de la station recherchée
     */
    public static ArrayList<Station> listestation;

    /**
     *liste contenant toutes les informations du fichier qu'on telecharge 
     */
    public static ArrayList<ReleveMeteo>  infotoutestations ;

    /**
     *liste contenant les infos sur la station recherché
     */
    public static ArrayList<ReleveMeteo>  infostation ;
    ArrayList<ReleveMeteo> aide = new ArrayList<>();

    /**
     *  ecartype de la temperature 
     */
    public static Double  ecartT=0.0,

    /**
     * ecartype de l'humidité 
     */
    ecartH=0.0,

    /**
     * ecartype de la nébulosité
     */
    ecartN=0.0;
  
   
    /**
     *
     * @param nom
     * @return l'id de la station entrée en parametre
     */
    public int rechercheId(String nom){
       
    
    

       listestation = new ArrayList<>();
       
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
            String name = values[1];
            Station s = new Station(id,values[1],latitude,longitude,altitude);
            if (nom.equals(name) ) {listestation.add(s);x=id;}
            
            
    
    }
    
}       catch (FileNotFoundException ex) {
            Logger.getLogger(DonneeStation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
    
    /**
     *
     * @param id
     * @param anne
     * @param mois
     * chargement des données de la station à travers son id l'année et le mois fournit
     */
    public void chargerDonneeStation(int id , String anne , String mois ){
       // int jour = Integer.parseInt(Smarti.j);
       int k ;
       if(mois == "") k = 12;
       else {k = 1;}
       String m =null; 
        id =x;
      ReleveMeteo releve; 
      
       
       infotoutestations = new ArrayList<>();
       
     for(int i=1;i<k+1;i++)  {
          if(k==1)  m = mois;
          else {
              if (i<10) m =""+0+i; 
              else {m=""+i;}  
                }
         
       
         
         
        
    
     String [] values;
     String f = anne+m+".csv" ;
      
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
            int id1 = Integer.parseInt(values[0]);
            Annee ann = new Annee(Integer.parseInt(values[1].substring(0, 4)));
            Mois mo = new Mois(Integer.parseInt(values[1].substring(4, 6)));
            Jour jr = new Jour(Integer.parseInt(values[1].substring(6, 8)));
            releve = new ReleveMeteo(id1,ann,mo,jr,values[7],values[9] ,values[14] );
            if (id1 == id )
            infotoutestations.add(releve);
            
            
    
    
    }
    
           
    
    } for(ReleveMeteo i : infotoutestations){
        System.out.println(i.getAnnee().getAnnee()+""+i.getMois().getMois()+"****"+i.getHumidite());
        }
        
        }
   
    /**
     *
     * @param c
     * calcul de la moyenne d'un jour 
     */
    public void MoyenneJour(String c){
           int jour = Integer.parseInt(c);
           int compteurt=0,compteurh=0,compteurn = 0;
           Double temp,nub,humid;
           temp=nub=humid = 0.0;
           infostation = new ArrayList<>();
           
           
           for(ReleveMeteo i : infotoutestations){
               if(i.getJour().getJour()== jour){
               
               if("mq".equals(i.getTemperature()) ) {temp+=0;compteurt++;}
                else {temp+=Double.parseDouble(i.getTemperature());compteurt++;}
               
               if("mq".equals(i.getHumidite()) ) {humid+=0;compteurh++;}
                else {humid+=Double.parseDouble(i.getHumidite());compteurh++;}
               
               if("mq".equals(i.getNebulosite()) ) {nub+=0;compteurn++;}
                else {nub+=Double.parseDouble(i.getNebulosite());compteurn++;}
               
           
           
           }}
           
           temp=temp/compteurt;
           humid=humid/compteurh;
           nub=nub/compteurn;
           beans.Jour j = new Jour(jour);
           ReleveMeteo rel = new ReleveMeteo(infotoutestations.get(0).getId(),infotoutestations.get(0).getAnnee(),infotoutestations.get(0).getMois(),j,""+temp,""+humid,""+nub);
            if(Double.parseDouble(rel.getTemperature())>=0 || Double.parseDouble(rel.getTemperature())<0)
           infostation.add(rel);
       }
    
   
    public void Moyenne8jours(String c){
        int jour = Integer.parseInt(c);
        infostation = new ArrayList<>();
        for(ReleveMeteo i : infotoutestations){
               if(i.getJour().getJour()== jour){
                   if(i.getNebulosite().equals("mq")) i.setNebulosite("0");
                   if(i.getHumidite().equals("mq")) i.setHumidite("0");
                   if(i.getTemperature().equals("mq")) i.setTemperature("0");
                   ReleveMeteo rel = new ReleveMeteo(infotoutestations.get(0).getId(),infotoutestations.get(0).getAnnee(),infotoutestations.get(0).getMois(),new Jour(jour),i.getTemperature(),i.getHumidite(),i.getNebulosite());
                    infostation.add(rel);
               }
    
    
    
    
    }
    
        }
    
    
    
       
    /**
     *
     * @return return une liste contenant les moyenens de tous les jours d'un mois 
     */
    public ArrayList<ReleveMeteo> MoyenneTousLesJours(){
            int jour = 1;
             infostation = new ArrayList<>();
           while(jour < 32)
           {
            int compteurt=0,compteurh=0,compteurn = 0;
           Double temp,nub,humid;
           temp=nub=humid = 0.0;
          
           
           
           for(ReleveMeteo i : infotoutestations){
               if(i.getJour().getJour()== jour){
               
               if("mq".equals(i.getTemperature()) ) {temp+=0;compteurt++;}
                else {temp+=Double.parseDouble(i.getTemperature());compteurt++;}
               
               if("mq".equals(i.getHumidite()) ) {humid+=0;compteurh++;}
                else {humid+=Double.parseDouble(i.getHumidite());compteurh++;}
               
               if("mq".equals(i.getNebulosite()) ) {nub+=0;compteurn++;}
                else {nub+=Double.parseDouble(i.getNebulosite());compteurn++;}
               
           
           
           }}
           
           temp=temp/compteurt;
           humid=humid/compteurh;
           nub=nub/compteurn;
           beans.Jour j = new Jour(jour);
           ReleveMeteo rel = new ReleveMeteo(infotoutestations.get(0).getId(),infotoutestations.get(0).getAnnee(),infotoutestations.get(0).getMois(),j,""+temp,""+humid,""+nub);
           if(Double.parseDouble(rel.getTemperature())>=0)
           infostation.add(rel);
            
            
            jour++;
           
       }
           aide = infostation;
           return aide;
       }
       
    /**
     *
     * @param c
     * calcul de la moyenen de temp nebul humid et affiichage d'une seule ligne (ReleveMeteo ) contenant ses infos 
     */
    public void MoyenneMois(String c){
           infostation = new ArrayList<>() ;
           int mois = Integer.parseInt(c);
           ArrayList<ReleveMeteo> x = new ArrayList<>();
           int compteurt=0,compteurh=0,compteurn = 0;
           Double temp,nub,humid;
           temp=nub=humid = 0.0;
           MoyenneTousLesJours();
           ArrayList<ReleveMeteo> h = aide;
           for(ReleveMeteo i : h)
           {
              
              temp+=Double.parseDouble(i.getTemperature());compteurt++;
               
               
               humid+=Double.parseDouble(i.getHumidite());compteurh++;
               
               
               nub+=Double.parseDouble(i.getNebulosite());compteurn++;
               
           }
            temp=temp/compteurt;
           humid=humid/compteurh;
           nub=nub/compteurn;
            beans.Jour j = new Jour(0);
            beans.Mois m = new Mois(mois);
            ReleveMeteo rel = new ReleveMeteo(h.get(0).getId(),h.get(0).getAnnee(),m,j,""+temp,""+humid,""+nub);
            x.add(rel);
            infostation = x;
           
       }
       
    /**
     * liste des releveMeteo d'une année compléte 
     */
    public void MoyenneTousMois(){
           int mois =1;
           infostation = new ArrayList<>();
            ArrayList<ReleveMeteo> x = new ArrayList<>();
            
           
            while(mois<=12){
            int compteurt=0,compteurh=0,compteurn = 0;
           Double temp,nub,humid;
           temp=nub=humid = 0.0;
           MoyenneTousLesJours();
           ArrayList<ReleveMeteo> h = infotoutestations;
           for(ReleveMeteo i : h)
           {
               if(i.getMois().getMois()== mois){
              if("mq".equals(i.getTemperature()) ) {temp+=0;compteurt++;}
                else {temp+=Double.parseDouble(i.getTemperature());compteurt++;}
               
               if("mq".equals(i.getHumidite()) ) {humid+=0;compteurh++;}
                else {humid+=Double.parseDouble(i.getHumidite());compteurh++;}
               
               if("mq".equals(i.getNebulosite()) ) {nub+=0;compteurn++;}
                else {nub+=Double.parseDouble(i.getNebulosite());compteurn++;}
           }}
            temp=temp/compteurt;
           humid=humid/compteurh;
           nub=nub/compteurn;
            beans.Jour j = new Jour(0);
            beans.Mois m = new Mois(mois);
            ReleveMeteo rel = new ReleveMeteo(h.get(0).getId(),h.get(0).getAnnee(),m,j,""+temp,""+humid,""+nub);
            x.add(rel);
           
            mois++;
                
               
          
           }
             infostation = x;
           
       
             
             
             
       }
       
    
   
       
       
       
       
     

    /**
     *
     * @param x
     * calcul de l'ecartype de la temperature , nebulosité , humidité
     */

    
    public void calculecartType(ArrayList<ReleveMeteo> x ){
        Double moyenneT=0.0,moyenneH=0.0
                ,moyenneN=0.0 ;
      
        Double difT=0.0,difN=0.0,difH=0.0;
        for(ReleveMeteo releve : x){
            moyenneT+=Double.parseDouble(releve.getTemperature())/x.size();
             moyenneH+=Double.parseDouble(releve.getHumidite())/x.size();
              moyenneN+=Double.parseDouble(releve.getNebulosite())/x.size();
            
        }
        
        for(ReleveMeteo releve : x){
            difT+=pow(Double.parseDouble(releve.getTemperature())-moyenneT,2);
            difN+=pow(Double.parseDouble(releve.getNebulosite())-moyenneN,2);
            difH+=pow(Double.parseDouble(releve.getHumidite())-moyenneH,2);
        
        }
        
        ecartT = sqrt(difT/x.size());
        ecartH = sqrt(difH/x.size());
        ecartN = sqrt(difN/x.size());
    }
}


