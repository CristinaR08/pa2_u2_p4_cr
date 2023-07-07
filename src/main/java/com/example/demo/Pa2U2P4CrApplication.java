package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.service.IConsultorioService;


@SpringBootApplication
public class Pa2U2P4CrApplication implements CommandLineRunner {

	@Autowired
	private IConsultorioService consultorioService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4CrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Query Dinamico Con OR");
		System.out.println(this.consultorioService.encontrarDoctorDinamico("Bustamante", "Geovanna", LocalDateTime.of(2022, 11, 18, 14, 20),""));
		System.out.println("Query Dinamico Con AND");
		System.out.println(this.consultorioService.encontrarDoctorDinamico("Cevallos", "Martin", LocalDateTime.of(2023, 02, 18, 16, 15),"Traumatologia"));

		/*this.estudianteService.borrarPorNombre("Angela");
		this.estudianteService.actualizarPorApellido("Manuel", "Rivadeneira");*/

	}

}
