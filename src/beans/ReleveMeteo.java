
package beans;

/**
 *
 * @author zmadh
 * classe ReleveMeteo qui contienr toutes les informations
 * 
 * 
 */
public class ReleveMeteo {
   private String temperature;
   private String humidite;
   private String nebulosite;
   private int id ;
   private Annee annee;
   private Mois mois;
   private Jour jour;
   
    /**
     *  un objet ReleveMeteo contient :
     * @param id : c'est l'identifiant de la station séléctionné
     * @param annee : l'année séléctionée par l'utilisateur
     * @param mois : mois selectionné par l'uyilsiateur
     * @param jour : jour selectionné par l'uyilsiateur
     * @param temperature : temperature correspondante à la station séléctionnée dans la date selectionnée
     * @param humidite : thumidité correspondante à la station séléctionnée dans la date selectionnée
     * @param nebulosite: nebulosité correspondante à la station séléctionnée dans la date selectionnée
     */
    public ReleveMeteo(int id,Annee annee,Mois mois,Jour jour ,String temperature,String humidite,String nebulosite){
       this.temperature=temperature;
       this.humidite=humidite;
       this.nebulosite=nebulosite;
       this.id=id;
       this.annee=annee;
       this.mois=mois;
       this.jour=jour;
       
       }
   
    /**
     *
     * @return la temperature
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     *
     * @param temperature : modifier temp d'un objet
     */
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    /**
     *
     * @return l'humidité d'un objet
     */
    public String getHumidite() {
        return humidite;
    }

    /**
     *
     * @param humidite
     */
    public void setHumidite(String humidite) {
        this.humidite = humidite;
    }

    /**
     *
     * @return
     */
    public String getNebulosite() {
        return nebulosite;
    }

    /**
     *
     * @param nebulosite
     */
    public void setNebulosite(String nebulosite) {
        this.nebulosite = nebulosite;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Annee getAnnee() {
        return annee;
    }

    /**
     *
     * @param annee
     */
    public void setAnnee(Annee annee) {
        this.annee = annee;
    }

    /**
     *
     * @return
     */
    public Mois getMois() {
        return mois;
    }

    /**
     *
     * @param mois
     */
    public void setMois(Mois mois) {
        this.mois = mois;
    }

    /**
     *
     * @return
     */
    public Jour getJour() {
        return jour;
    }

    /**
     *
     * @param jour
     */
    public void setJour(Jour jour) {
        this.jour = jour;
    }
}
