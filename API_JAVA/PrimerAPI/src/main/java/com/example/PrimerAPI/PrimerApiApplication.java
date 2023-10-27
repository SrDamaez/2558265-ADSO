package com.example.PrimerAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
public class PrimerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimerApiApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Quien sos?";
	}

	@GetMapping("/Persona")
	public Persona getPersona() {
		return new Persona("Juan", "Perez", 30, "Calle 123", "12345678", "papa@mail.com");
	}

	@GetMapping("/personaslitsa")
	public List<Persona> listado() {
		List<Persona> listado = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			//Persona tem = ;
			listado.add(new Persona("Juan", "Perez", 30 + i, "Calle 123", "12345678" + i, "papa@mail.com"));
		}
		return listado;
	}

	@GetMapping("/persona")
	public String getPersonita(@RequestParam String nombre) {

		return "la persona es " + nombre;
	}


	@GetMapping("/consumoPersona")
	public List<Persona> listadoPersona() {
		List<Persona> listado = new ArrayList<>();
		DataBase db = new DataBase();
		ResultSet listadoDB = db.listaPersonas();
		try {
			do {
				listado.add(new Persona(listadoDB.getString("nombre"), listadoDB.getString("apellido"), listadoDB.getInt("edad"), listadoDB.getString("direccion"), listadoDB.getString("telefono"), listadoDB.getString("correo_electronico")));
			}while (listadoDB.next());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listado;
	}
        
        @Bean
        public WebMvcConfigurer corsConfiguration(){
            return new WebMvcConfigurer(){
                public void addCorsMappings(CorsRegistry registry){
                    registry.addMapping("/**").allowedMethods("*");
                }
            };
        }
}
