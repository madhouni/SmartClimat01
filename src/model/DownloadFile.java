/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



import java.io.* ;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;


/**
 *
 * @author mabrchaouen
 */
public class DownloadFile {
    
    /**
     *
     * @param annee
     * @param mois
     * @throws IOException
     * telechargement d'un fichier à travers l'année et le mois 
     */
    public DownloadFile(String annee, String mois) throws IOException{
        
      
        if(mois == ""){
                for(int i=1;i<13;i++){
                    if(i<10){
                        String l = ""+0+i;
                        getFile("https://donneespubliques.meteofrance.fr/donnees_libres/Txt/Synop/Archive/synop."+annee+l+".csv.gz",annee+l.toString() );
                        decompressGzipFile(annee+l+".csv.gz",annee+l+".csv");
                        suprimmerfichier(annee+l+".csv.gz");
                        }
                    else{
                        String l = ""+i;
                         getFile("https://donneespubliques.meteofrance.fr/donnees_libres/Txt/Synop/Archive/synop."+annee+l+".csv.gz",annee+l.toString() );
                        decompressGzipFile(annee+l+".csv.gz",annee+l+".csv");
                        suprimmerfichier(annee+l+".csv.gz");
                    }
                    
                    
                }
        
        }
            
        
        
        else{
        
                 getFile("https://donneespubliques.meteofrance.fr/donnees_libres/Txt/Synop/Archive/synop."+annee+mois+".csv.gz",annee+mois.toString() );
                  decompressGzipFile(annee+mois+".csv.gz",annee+mois+".csv");
                   suprimmerfichier(annee+mois+".csv.gz");
        }
       }
    
    /* fonction pour supression d'un fichier  */
    private static void suprimmerfichier(String lien){
        File MyFile = new File(lien); 
        MyFile.delete(); 
       }
    /* fonction pour decompresser un zip*/
    
   private static void decompressGzipFile(String gzipFile, String newFile) {
        try {
            FileInputStream fis = new FileInputStream(gzipFile);
            GZIPInputStream gis = new GZIPInputStream(fis);
            FileOutputStream fos = new FileOutputStream(newFile);
            byte[] buffer = new byte[1024];
            int len;
            while((len = gis.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
            //close resources
            fos.close();
            gis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
   
   
   
  
   
   /* fonction de téléchargement d'un fichier en archive */
   private static void getFile(String host,String name)
    {
        InputStream input = null;
        FileOutputStream writeFile = null;

        try
        {
            URL url = new URL(host);
            URLConnection connection = url.openConnection();
            int fileLength = connection.getContentLength();

            if (fileLength == -1)
            {
                System.out.println("Invalide URL or file.");
                return;
            }

            input = connection.getInputStream();
            String fileName = name+".csv.gz";
            writeFile = new FileOutputStream(fileName);
            byte[] buffer = new byte[1024];
            int read;

            while ((read = input.read(buffer)) > 0)
                writeFile.write(buffer, 0, read);
            writeFile.flush();
        }
        catch (IOException e)
        {
            System.out.println("Error while trying to download the file.");
            e.printStackTrace();
        }
        finally
        {
            try
            {
                writeFile.close();
                input.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
    
     
    
    
    
    
    
    
    
}
