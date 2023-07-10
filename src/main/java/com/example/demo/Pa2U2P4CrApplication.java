package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.dto.EstudianteDTO;
import com.example.demo.repository.modelo.dto.MatriculaDTO;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IHabitacionService;
import com.example.demo.service.IHotelService;
import com.example.demo.service.IMatriculaService;


@SpringBootApplication
public class Pa2U2P4CrApplication implements CommandLineRunner {

	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IMatriculaService iMatriculaService;
	
	@Autowired
	private IHotelService iHotelService;
	
	@Autowired
	private IHabitacionService habitacionService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4CrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	
		System.out.println("DTO con 2 argumentos");
		System.out.println("Reporte estudiantes");
		List<EstudianteDTO> reporte = this.estudianteService.encontrarTodosDTO();
		for (EstudianteDTO estudianteDTO : reporte) {
			System.out.println(estudianteDTO);
		}
		
		System.out.println("DTO con 3 argumentos");
		System.out.println("Reporte estudiantes");
		List<EstudianteDTO> reporte2 = this.estudianteService.encontrarTresArgsDTO();
		for (EstudianteDTO estudianteDTO : reporte2) {
			System.out.println(estudianteDTO);
		}
		
		/*System.out.println();
		System.out.println("Matricula Nombre y Materia");
		List<MatriculaDTO> reporteMatricula = this.iMatriculaService.reporteAlumnoNomYMateriaNom();
		for (MatriculaDTO matriculaDTO : reporteMatricula) {
			System.out.println(matriculaDTO);
		}*/
		
		/*System.out.println();
		System.out.println("Imprimir el Hotel");
		Hotel hotel = this.iHotelService.encontrar(1);
		System.out.println(hotel.getNombre());
		
		 Hotel consulta = this.iHotelService.encontrar(1);

		 //consulta.getHabitaciones();
		 for (Habitacion habitacion : consulta.getHabitaciones()) {
			System.out.println("Reporte"+habitacion.getId());

		}*/
	}

}
