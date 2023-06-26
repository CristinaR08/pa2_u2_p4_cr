package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.ConsultorioMedico;
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
				
		ConsultorioMedico consulta2 = new ConsultorioMedico();
		consulta2.setNombrePaciente("Alexander");
		consulta2.setApellidoPaciente("Zurita");
		consulta2.setEdadPaciente(25);
		consulta2.setFechaConsulta(LocalDateTime.of(2022, Month.AUGUST,25,15,30)); //yy-mm-dd hh:mm
		consulta2.setHistoriaMedica(789654);
		consulta2.setValorPagado(new BigDecimal(30.00));
		consulta2.setNombreDoctor("Julieta");
		consulta2.setApellidoDoctor("Acosta");
		consulta2.setEspecialidad("Traumatologia");
		this.consultorioService.agregar(consulta2);
		
		System.out.println(">>>>>>>>>>>>Query Single Result");
		this.consultorioService.encontrarPorFecha(LocalDateTime.of(2023, Month.NOVEMBER,18,11,30));
		
		System.out.println(">>>>>>>>>>>>Query Result List");
		List<ConsultorioMedico> reporte = this.consultorioService.encontrarDoctor("Bolaños", "Oscar");
		System.out.println("Reporte: ");
		for(ConsultorioMedico doctores : reporte) {
			System.out.println(doctores);
		}
		
		System.out.println(">>>>>>>>>>>>TypedQuery Single Result");
		this.consultorioService.encontrarPreciosTyped(new BigDecimal(40.50));
		
		System.out.println(">>>>>>>>>>>>TypedQuery Result List");
		List<ConsultorioMedico> reporteH = this.consultorioService.encontrarListaPorHistoriaTyped(1);
		System.out.println("Historia Medica: ");
		for(ConsultorioMedico historia : reporteH) {
			System.out.println(historia);
		}
		
		/*this.estudianteService.agregar(estudiante);
		this.estudianteService.agregar(estudiante2);
		this.estudianteService.agregar(estudiante3);
		
		this.estudianteService.encontrarPorApellido("Peralta");
		this.estudianteService.encontrarPorApellidoyNombre("Rivera", "Cristina");
		this.estudianteService.encontrarPorApellidoTyped("Peralta");
		
		List<Estudiante> reporte = this.estudianteService.encontrarListaPorApellido("Rivera");
		System.out.println("Reporte: ");
		for(Estudiante listaEstu : reporte) {
			System.out.println(listaEstu);
		}
		*/
	}

}
