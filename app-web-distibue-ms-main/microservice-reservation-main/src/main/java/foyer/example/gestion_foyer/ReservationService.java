package foyer.example.gestion_foyer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;



    public Reservation AddReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(int id, Reservation newReservation) {

        if (reservationRepository.findById(id).isPresent()) {
            Reservation existingReservation = reservationRepository.findById(id).get();
            existingReservation.setCinEtudiant(newReservation.getCinEtudiant());
            existingReservation.setAnneeReservation(newReservation.getAnneeReservation());
            existingReservation.setTypeChambre(newReservation.getTypeChambre());
            return reservationRepository.save(existingReservation);
        } else
            return null;
    }

    public String deleteReservation(int id) {
        if (reservationRepository.findById(id).isPresent()) {
            reservationRepository.deleteById(id);
            return "Reservation supprimé";
        } else
            return "Reservation non supprimé";
    }

    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(int id) {
        return reservationRepository.findById(id).orElse(null);
    }



}

