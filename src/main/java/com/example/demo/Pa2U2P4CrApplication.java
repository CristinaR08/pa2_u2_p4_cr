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
		estudiante.setNombre("Cristina");
		estudiante.setApellido("Rivera");
		
		Estudiante estudiante2 = new Estudiante();
		estudiante2.setNombre("Dario");
		estudiante2.setApellido("Rivera");
		
		Estudiante estudiante3 = new Estudiante();
		estudiante3.setNombre("Sara");
		estudiante3.setApellido("Peralta");
		
		/*this.estudianteService.agregar(estudiante);
		this.estudianteService.agregar(estudiante2);
		this.estudianteService.agregar(estudiante3);*/
		
		this.estudianteService.encontrarPorApellido("Peralta");
		this.estudianteService.encontrarListaPorApellido("Rivera");
		this.estudianteService.encontrarPorApellidoyNombre("Rivera", "Cristina");
		this.estudianteService.encontrarPorApellidoTyped("Peralta");
		

	}

}
