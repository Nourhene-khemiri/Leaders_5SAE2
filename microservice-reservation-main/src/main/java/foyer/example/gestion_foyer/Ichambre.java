package foyer.example.gestion_foyer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "Service-Chambre", url = "http://localhost:8082")

public interface Ichambre {
    @GetMapping("/chambre/getAllChambres/")
    List<Chambre> getAllChambres();
}
