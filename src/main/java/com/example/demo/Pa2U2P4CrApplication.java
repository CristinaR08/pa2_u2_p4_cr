package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Alumno;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.service.IMatriculaService;

@SpringBootApplication
public class Pa2U2P4CrApplication implements CommandLineRunner {

	@Autowired
	private IMatriculaService matriculaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4CrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Alumno alumno= new Alumno();
		alumno.setNombre("Cristina");
		Alumno alumno2= new Alumno();
		alumno.setNombre("Lizeth");
		
		List<Matricula> matriculas = new ArrayList<>();
		Matricula matricula = new Matricula();
		matriculas.add(matricula);
	
		
		
		
	   	
	}

}
