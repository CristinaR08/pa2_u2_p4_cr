package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Alumno;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMatriculaService;

@SpringBootApplication
public class Pa2U2P4CrApplication implements CommandLineRunner {

	@Autowired
	private IEstudianteService estudianteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4CrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Estudiante estudiante = new Estudiante();
		estudiante.setNombre("Angela");
		estudiante.setApellido("Trujillo");
		estudiante.setPeso(55.7);
		
		Estudiante estudiante2 = new Estudiante();
		estudiante2.setNombre("Juan");
		estudiante2.setApellido("Rivadeneira");
		estudiante2.setPeso(100.00);
		
		Estudiante estudiante3 = new Estudiante();
		estudiante3.setNombre("Carmen");
		estudiante3.setApellido("Sampedro");
		estudiante3.setPeso(110.3);

		/*this.estudianteService.agregar(estudiante);
		this.estudianteService.agregar(estudiante2);
		this.estudianteService.agregar(estudiante3);*/
		
		System.out.println(this.estudianteService.encontrarEstudianteDinamico("Angela", "Trump", 100.00));
		System.out.println(this.estudianteService.encontrarEstudianteDinamico("Joaquin", "Rivadeneira", 100.00));
		System.out.println(this.estudianteService.encontrarEstudianteDinamico("Carmen", "Sampedro", 110.3));
		
		this.estudianteService.borrarPorNombre("Angela");
		this.estudianteService.actualizarPorApellido("Manuel", "Rivadeneira");

	}

}
