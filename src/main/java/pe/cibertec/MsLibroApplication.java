package pe.cibertec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsLibroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsLibroApplication.class, args);
		System.out.println("Microservicio Libro iniciado correctamente");
	}

}
