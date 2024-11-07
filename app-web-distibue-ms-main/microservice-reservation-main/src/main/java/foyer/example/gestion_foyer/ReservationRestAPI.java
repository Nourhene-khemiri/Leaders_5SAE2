package foyer.example.gestion_foyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = " *")
@RestController
@RequestMapping("/Reservation")
public class ReservationRestAPI {

    private String hello = "Hello I'm An Reservation V2";


    @RequestMapping("/hello")
    public String sayHello() {
        return hello;
    }

    @Autowired
    private ReservationService reservationService;


    @PostMapping(value = "/add",consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Reservation> createorganisation(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.AddReservation(reservation), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Reservation> updatereservation(@PathVariable(value = "id") int id,
                                                         @RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.updateReservation(id, reservation),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deletereservation(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(reservationService.deleteReservation(id), HttpStatus.OK);
    }


    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Reservation>> getreservation() {
        List<Reservation> reservation = reservationService.getAllReservation();
        if (reservation != null) {
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/reservations/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Reservation> getReservation(@PathVariable("id") int id) {
        Reservation reservation = reservationService.getReservationById(id);
        return ResponseEntity.status(HttpStatus.OK).body(reservation);
    }


}
