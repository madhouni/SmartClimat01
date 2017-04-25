/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Junit;

import IHM.Smarti;
import beans.ReleveMeteo;
import controller.Controller;
import java.io.IOException;
import java.util.ArrayList;
import junit.framework.TestCase;
import model.DonneeStation;

/**
 *
 * @author zmadh
 */
public class Junit extends TestCase {
     String moyenneN = null;
     int id = 0;
     String nom ="" ;
     String moyenneH = null;
     
    
    public Junit(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
       
       moyenneN = ""+20.0;
       moyenneH = ""+86.81451612903226;
       id = 7240;
       nom = "TOURS";
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
   
    
    public void testMoyenneJour() throws IOException{
        String attendu = moyenneN;
        Controller c = new Controller();
        Smarti.m=""+10;
        Smarti.anne=""+2015;
        Smarti.nom="ABBEVILLE";
        Smarti.j=""+25;
        c.ChargerFichier();
        c.RecupererDonneesFichier();
        c.recupererDonneesJour();
        ArrayList<ReleveMeteo> x = c.getStationRecherchee();
        String f = x.get(0).getNebulosite();
        
        
        String obtenu = f;
        assertEquals(attendu, f);
        
      }
    
    public void testRechecheId(){
    int attendu = id;
    int k = new DonneeStation().rechercheId(nom);
    int obtenu = k;
        assertTrue(obtenu == attendu);
    
    
    }
    
    public void testMoyenneHumidPremierMoisAnnee() throws IOException{
        String attendu = moyenneH;
        Controller c = new Controller();
        Smarti.m="";
        Smarti.anne=""+2010;
        Smarti.nom="ORLY";
        Smarti.j=""+25;
        c.ChargerFichier();
        c.RecupererDonneesFichier();
        c.recupererDonneesTousMois();
        ArrayList<ReleveMeteo> x = c.getStationRecherchee();
        String f = x.get(0).getHumidite();
        
        
        String obtenu = f;
        assertEquals(attendu, f);
        
         
    
    
    }
    
    
    
    
    
    
    
    

    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
}
