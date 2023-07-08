package com.example.demo;

import java.math.BigDecimal;
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
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IHabitacionService;
import com.example.demo.service.IHotelService;
import com.example.demo.service.IMatriculaService;

@SpringBootApplication
public class Pa2U2P4CrApplication implements CommandLineRunner {
	
	@Autowired
	private IMatriculaService matriculaService;
	
	@Autowired
	private IHabitacionService habitacionService;
		
	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4CrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Alumno alumno= new Alumno();
		alumno.setNombre("Cristina");
		Alumno alumno2= new Alumno();
		alumno.setNombre("Lizeth");
		
		Materia materia1 = new Materia();
		materia1.setNombre("Ciencia");	
		
		Matricula matricula = new Matricula();
		matricula.setAlumno(alumno2);
		matricula.setFecha(LocalDateTime.now());
		matricula.setNumero("1254");
		matricula.setMateria(materia1);
		
		this.matriculaService.agregar(matricula);
		
		System.out.println(this.matriculaService.encontrarTodosDTO());
		
		Habitacion hab = new Habitacion();
		hab.setNumero("5236");
		hab.setValor(new BigDecimal(150));
		this.habitacionService.agregar(hab);
		
		Hotel hotel = new Hotel();
		hotel.setNombre("Marriot");
		this.hotelService.agregar(hotel);
		
//OJO: si nos pide un reporte construido de la manera mas eficiente usamos un fetch.LAZY y un DTO

	}

}
