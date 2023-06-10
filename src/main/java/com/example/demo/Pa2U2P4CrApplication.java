package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U2P4CrApplication implements CommandLineRunner {

	@Autowired
	private EstudianteService estudianteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4CrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Estudiante est1 = new Estudiante();
		est1.setNombre("Cristina");
		est1.setApellido("Rivera");
		est1.setCedula("1726600537");
		System.out.println(est1);
		estudianteService.agregar(est1);
		
		Estudiante est2 = new Estudiante();
		est2.setNombre("Lizeth");
		est2.setApellido("Sanchez");
		est2.setCedula("1789563214");
		System.out.println(est2);
		//estudianteService.agregar(est2);
		
		Estudiante est3 = new Estudiante();
		est3.setNombre("Tatiana");
		est3.setApellido("Almeida");
		est3.setCedula("1756983205");
		System.out.println(est3);
		//estudianteService.agregar(est3);
		
		this.estudianteService.buscarPorCedula(est3.getCedula());
		this.estudianteService.actualizar(est3);
		this.estudianteService.borrar(est3.getCedula());
		
	}

}
