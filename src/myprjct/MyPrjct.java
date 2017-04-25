package myprjct;

import java.io.IOException;
import controller.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MyPrjct {

    public static void main(String[] args) throws IOException {
        
        Controller c = new Controller();
               
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
             c.start();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MyPrjct.class.getName()).log(Level.SEVERE, null, ex);
        }

       
          
           }
        
    }


