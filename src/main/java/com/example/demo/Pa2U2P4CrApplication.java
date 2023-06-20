package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.service.IAutorService;
import com.example.demo.service.IHabitacionService;
import com.example.demo.service.IHotelService;
import com.example.demo.service.ILibroService;

@SpringBootApplication
public class Pa2U2P4CrApplication implements CommandLineRunner {

	@Autowired
	private IHabitacionService habitacionService;
    @Autowired
    private IHotelService hotelService;

	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4CrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*Set<Autor> autores = new HashSet<>();
		Set<Libro>libros = new HashSet<>();
		
		Autor autor= new Autor();
		autor.setNombre("Jhon");
		autor.setApellido("Green");
	   
		Autor autor1= new Autor();
		autor1.setNombre("Carlos");
		autor1.setApellido("Ruiz Zafón");
	    autores.add(autor);
	    autores.add(autor1);
		
		Libro libro = new Libro();
		libro.setTitulo("Buscando a Alaska");
		libro.setEditorial("Bermeu");
		Libro libro1 = new Libro();
		libro1.setTitulo("Buscando a Alaska");
		libro1.setEditorial("Bermeu");
		
		libros.add(libro);
		libros.add(libro1);
		autor.setLibros(libros);
		libro.setAutores(autores);
		
		this.autorService.agregar(autor);
		this.libroService.agregar(libro);*/
		
		Hotel hotel = new Hotel();
		hotel.setNombre("JW Marriott");
		hotel.setDireccion("Av. Francisco de Orellana 1172 Y, Quito 170150");
		
		List<Habitacion> listaHabitacion= new ArrayList<>();
		Habitacion hab1 = new Habitacion();
		hab1.setNumero("A22");
		hab1.setValor(new BigDecimal(90));
		hab1.setHotel(hotel);
		listaHabitacion.add(hab1);
		hotel.setHabitaciones(listaHabitacion);
		this.hotelService.agregar(hotel);
		this.habitacionService.agregar(hab1);
		
		
	}

}
