package foyer.example.gestion_foyer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Date;
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class GestionFoyerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionFoyerApplication.class, args);
	}
	@Autowired
	private ReservationRepository repository;

	@Bean
	ApplicationRunner init(){
		return (args)-> {
			//Save
			repository.save(new Reservation(14405812, "2023", "test", true));
			repository.save(new Reservation(14405813, "2024", "luxury", false));
			//fetch
			repository.findAll().forEach(System.out::println);
		};
	}
}
