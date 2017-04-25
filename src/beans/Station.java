
package beans;

/**
 *
 * @author zmadh
 */
public class Station {
    
 private int id;
 private String nom;
 private double latitude;
 private double longitude;
 private int altitude;

    /**
     *
     * @param id
     * @param nom
     * @param latitude
     * @param longitude
     * @param altitude
     */
    public Station(int id,String nom,double latitude,double longitude,int altitude){
     this.id=id;
     this.nom=nom;
     this.latitude=latitude;
     this.longitude=longitude;
     this.altitude=altitude;
     
    }
 
 
 
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the altitude
     */
    public int getAltitude() {
        return altitude;
    }

    /**
     * @param altitude the altitude to set
     */
    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }
    
    
    
    
    
    
    
    
     
    
    
    
    
    
    
    
    
    
    
}
