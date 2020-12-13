package ua.lviv.iot.uklon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ua.lviv.iot.uklon")
public class UklonApplication {

	public static void main(String[] args) {
		SpringApplication.run(UklonApplication.class, args);
	}

}
