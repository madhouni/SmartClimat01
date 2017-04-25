/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import IHM.*;
import beans.ReleveMeteo;
import beans.Station;
import java.io.IOException;
import java.util.ArrayList;
import model.DonneeStation;
import model.DownloadFile;
import model.dataload;

/**
 *
 * @author zmadh
 */
public class Controller {
    
    /**
     *
     * @return le mois entré en ihm
     */
    public String getMois(){
        return Smarti.m;
    }

    /**
     *
     * @return l'année entrée en ihm
     */
    public String getAnnee(){
        return Smarti.anne;
                }
    
    /**
     *
     * @return le jour entré en ihm
     */
    public String getJour(){
        return Smarti.j;
    }
    
    /**
     *
     * @return le nom de sa station entré en ihm
     */
    public String getNomStation(){
        return Smarti.nom;
        
        
    }
    
    /**
     *
     * @return le type de comparaison 
     */
    public String getElemtCompar(){
    return Smarti.comp;
    }
    
    /**
     *
     * @return la liste des stations et leurs identifiant ainsi que l'altitude longitude ...
     */
    public ArrayList<Station> getStations(){
        return dataload.stations;
    }
    
    /**
     *
     * @return une liste de toutes le stations se trouvant dans le fichier téléchargé 
     */
    public ArrayList<ReleveMeteo> getToutStations(){
        return dataload.stationsinfo;
    }
    
    /**
     *
     * @return retourn une liste contenant les infos de la station séléctionée , c'est un filtrage de controller.getStation()
     */
    public ArrayList<ReleveMeteo> getStationRecherchee(){
        return DonneeStation.infostation;
    }
    
    /**
     *
     * @throws IOException chargement du fichier appelant la methode downloadfile se trouvant dans
     * le package modele class DownloadFile
     */
    public void ChargerFichier() throws IOException{
        
        DownloadFile downloadFile = new DownloadFile(this.getAnnee(),this.getMois());
        
    
    
    }
    
   //************************************ ******************************************************

    /**
     * recuperation des données d'un jour 
     */
    public void recupererDonneesJour(){
              int k;
              k = new DonneeStation().rechercheId(this.getNomStation());
              new DonneeStation().chargerDonneeStation(k,this.getAnnee(),this.getMois());
              new DonneeStation().MoyenneJour(this.getJour());
    }
    
    
     public void recupererDonnees8Jour(){
              int k;
              k = new DonneeStation().rechercheId(this.getNomStation());
              new DonneeStation().chargerDonneeStation(k,this.getAnnee(),this.getMois());
              new DonneeStation(). Moyenne8jours(this.getJour());
     }
    
    /**
     * recuperation des données d'un mois en detaille  
     */
    public void recupererDonneesTousjours(){
              int k;
              k = new DonneeStation().rechercheId(this.getNomStation());
              new DonneeStation().chargerDonneeStation(k,this.getAnnee(),this.getMois());
               new DonneeStation().MoyenneTousLesJours();
    }
    
    /**
     * recuperation des données d'un mois globalement en donant la moyenne de la temp , nub , humid
     */
    public void recupererDonneesMois(){
              int k;
              k = new DonneeStation().rechercheId(this.getNomStation());
              new DonneeStation().chargerDonneeStation(k,this.getAnnee(),this.getMois());
               new DonneeStation().MoyenneMois(this.getMois());
    }

    /**
     * recuperation des données de l'année 
     */
    public void recupererDonneesTousMois(){
              int k;
              k = new DonneeStation().rechercheId(this.getNomStation());
              new DonneeStation().chargerDonneeStation(k,this.getAnnee(),this.getMois());
               new DonneeStation().MoyenneTousMois();
    }
          
   //***********************************************************************************************       
          
    /**
     * recuperation des informations d'un fichier téléchargé appel aux fontions load et loading de la class 
     * dataload du package model
     */
    public void RecupererDonneesFichier(){
        dataload data = new dataload();
        data.load();
        data.loading(this.getMois(),this.getAnnee());
    }
    
    /**
     * affichage des données d'un jour  
     */
    public void AfficherStationRecherchee(){
          int k;
           // System.out.println(this.getJour());   
           this.recupererDonneesJour();
      //     k = new DonneeStation().rechercheId(this.getNomStation());
        //    new DonneeStation().chargerDonneeStation(k,this.getAnnee(),this.getMois());
          //   new DonneeStation().MoyenneJour(this.getJour());
               new StationDataPerso().setVisible(true);
          
    }
    
    
    public void AfficherStation8Recherchee(){
          int k;
           // System.out.println(this.getJour());   
           this.recupererDonnees8Jour();
      //     k = new DonneeStation().rechercheId(this.getNomStation());
        //    new DonneeStation().chargerDonneeStation(k,this.getAnnee(),this.getMois());
          //   new DonneeStation().MoyenneJour(this.getJour());
               new StationDataPerso().setVisible(true);
          
    }
    
    
    /**
     *affichage des données d'un mois en detaille 
     */
    public void AfficherStationMoyenneTousLesJours(){
         int k;

         this.recupererDonneesTousjours();
         //k = new DonneeStation().rechercheId(this.getNomStation());
           // new DonneeStation().chargerDonneeStation(k,this.getAnnee(),this.getMois());
             //new DonneeStation().MoyenneTousLesJours();
            new StationDataPerso().setVisible(true);
        
    }
    
    /**
     *  affichage des deonnées de la moyenen d'un mois
     */
    public void AfficheMoyenneMois(){
        int k;
            this.recupererDonneesMois();
            //k = new DonneeStation().rechercheId(this.getNomStation());
            //new DonneeStation().chargerDonneeStation(k,this.getAnnee(),this.getMois());
            //new DonneeStation().MoyenneMois(this.getMois());
            new StationDataPerso().setVisible(true);
    
    }
     
    /**
     * affichage des données detaillées de l'année
     */
    public void AfficheMoyenneTousMois(){
        int k;
            this.recupererDonneesTousMois();
            //k = new DonneeStation().rechercheId(this.getNomStation());
            //new DonneeStation().chargerDonneeStation(k,this.getAnnee(),this.getMois());
            //new DonneeStation().MoyenneTousMois();
           new StationDataPerso().setVisible(true);
    
    }
    
    /**
     * pour l'affichage des données extraites du fichier 
     */
    public void AffichertoutesStations(){
        new Stationsdata().setVisible(true);

    }
    
    /**
     *  affichage de la liste des stations 
     */
    public void Afficher(){
          new Stations().setVisible(true);
    }
    
    /**
     *  lancement de l'interface principale 
     */
    public void start(){
                
                new Smarti().setVisible(true);

    }
    
    /**
     *  affichage du graphe 
     */
    public void affichegraph(/*JInternalFrame jp*/){
    NewClass app = new  NewClass(this.getNomStation()+" date :"+this.getAnnee()+"-"+this.getMois()+"-"+this.getJour()+ "." /*,jp*/);
        app.pack();
        //app.setSize(jp.getSize());
        app.setVisible(true);
        
        
    }
    
    /**
     *  calcule de l'ecartype d'une liste de type ReleveMeteo contenant des données
     */
    public void caluclecartypeT(){
    new DonneeStation().calculecartType(this.getStationRecherchee());
    }
    
    /**
     *
     * @return ecartype de la temperature 
     */
    public Double getecartT(){
        return DonneeStation.ecartT;
    }
    
    /**
     *
     * @return ecartype de la nebulosité 
     */
    public Double getecartN(){
        return DonneeStation.ecartN;
    }

    /**
     *
     * @return ecartype de l'humidité 
     */
    public Double getecartH(){
        return DonneeStation.ecartH;
    }
    
    

    






}





  
