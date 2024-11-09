package foyer.example.gestion_foyer;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private int cinEtudiant;
    private String anneeReservation,typeChambre;

    private boolean estValide;

    public Reservation() {
    }

    public Reservation(int cinEtudiant, String anneeReservation, String typeChambre, boolean estValide) {

        this.cinEtudiant = cinEtudiant;
        this.anneeReservation = anneeReservation;
        this.typeChambre = typeChambre;
        this.estValide =  estValide;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCinEtudiant() {
        return cinEtudiant;
    }

    public void setCinEtudiant(int cinEtudiant) {
        this.cinEtudiant = cinEtudiant;
    }

    public String getAnneeReservation() {
        return anneeReservation;
    }

    public void setAnneeReservation(String anneeReservation) {
        this.anneeReservation = anneeReservation;
    }

    public String getTypeChambre() {
        return typeChambre;
    }

    public void setTypeChambre(String typeChambre) {
        this.typeChambre = typeChambre;
    }

    public boolean getestValide() {
        return estValide;
    }

    public void setestValide(boolean estValide) {
        this.estValide = estValide;
    }
}
