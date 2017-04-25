/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import IHM.compargraph;
import beans.ReleveMeteo;
import controller.Controller;
import java.util.ArrayList;

/**
 *
 * @author zmadh
 */
public class manager {

    /**
     *
     */
    public  manager(){}
   
    /**
     *
     * @param c1
     * @param c2
     * @param comp
     * lancement d'un graphe contenant deux courbes de 2 listes differente et comp contient soit hmid 
     * soit temp soit nebu donc lequel on veut comparer
     */
    public void comparaisongraph(ArrayList<ReleveMeteo> c1 , ArrayList<ReleveMeteo> c2 ,String comp){
        
        
        compargraph compar = new compargraph("comparaison", c1, c2, comp );
            compar.pack();
            compar.setVisible(true);
    
    
    }
    
    
 
  
  
    
    }
