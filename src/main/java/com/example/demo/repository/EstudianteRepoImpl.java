package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.dto.EstudianteDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional //Se necesita la anotación para acceder a la base de datos.
public class EstudianteRepoImpl implements IEstudianteRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
	   this.entityManager.merge(estudiante);
		
	}

	@Override
	public Estudiante buscar(String cedula) {
		return this.entityManager.find(Estudiante.class, cedula);
	}

	@Override
	public void eliminar(String cedula) {
		Estudiante estu = this.buscar(cedula);
		this.entityManager.remove(estu);
	}

	@Override
	public Estudiante seleccionarPorApellido(String apellido) {
		//SQL
		//SELECT * FROM estudiante e WHERE e.estu_apellido=
		//JPQL 
		//SELECT e FROM Estudiante e WHERE e.apellido = 
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> seleccionarListaApellido(String apellido) {
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public Estudiante seleccionarPorApellidoyNombre(String apellido, String nombre) {
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido AND e.nombre = :datoNombre");
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
		
	}

	@Override
	public Estudiante seleccionarPorApellidoTyped(String apellido) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNamed(String apellido) {
		TypedQuery<Estudiante>myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellido",Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNamedQuery(String apellido) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellido");
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNativeQuery(String apellido) {
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE estu_apellido = :datoApellido",Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNativeQueryNamed(String apellido) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellidoNative", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorNombreNamedQuery(String nombre) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombre");
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorNombreNativeQueryNamed(String nombre) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombreNative", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoCriteriaAPIQuery(String apellido) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder(); //me permite construir desde 0, metodo por metodo
		//1. Especificamos el tipo de retorno que tiene mi Query
		CriteriaQuery<Estudiante>myCriteriaQuery = myBuilder.createQuery(Estudiante.class);
		//2. Empezamos a crear el SQL
		//2.1. Definimos el FROM (Root)
		Root<Estudiante> miTablaFrom = myCriteriaQuery.from(Estudiante.class); //FROM Estudiante
		//3. Construir las condiciones de mi SQL, las condiciones se las conoce como predicados, cada condicion es un predicado
		//e.apellido = :datoApellido
		Predicate condicionApellido = myBuilder.equal(miTablaFrom.get("apellido"),apellido);
		//4. Armar mi SQL final
		myCriteriaQuery.select(miTablaFrom).where(condicionApellido);		
		//5. La ejecucion del query lo realizamos con TypedQuery
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myCriteriaQuery);	
		return myQueryFinal.getSingleResult();
	}

	@Override
	public Estudiante seleccionarEstudianteDinamico(String nombre, String apellido, Double peso) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante>myCriteriaQuery = myBuilder.createQuery(Estudiante.class);
		Root<Estudiante> miTablaFrom = myCriteriaQuery.from(Estudiante.class);
		//3. Construimos las condicines
		//peso>100 e.nombre=? AND e.apellido=? tiene que cumplir ambas condiciones
		//peso<=100 e.nombre=? OR e.apellido=? basta con que cumpla una sola condicion
		//AND, OR son predicados en funcion de la condicion
		//e.nombre=?
		Predicate pNombre = myBuilder.equal(miTablaFrom.get("nombre"), nombre);
		//e.apellido=?
		Predicate pApellido = myBuilder.equal(miTablaFrom.get("apellido"), apellido);
		Predicate predicadoFinal = null;
		if(peso.compareTo(Double.valueOf(100))<=0) {
			predicadoFinal=myBuilder.or(pNombre,pApellido);
		}else {
			predicadoFinal=myBuilder.and(pNombre, pApellido);
		}
		myCriteriaQuery.select(miTablaFrom).where(predicadoFinal);		
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myCriteriaQuery);	
		return myQueryFinal.getSingleResult();
	}

	@Override
	public int eliminarPorNombre(String nombre) {
		//DELETE FROM estudiante WHERE estu_nombre=?
		//DELETE FROM Estudiante e WHERE e.nombre = :datoNombre
		Query myQuery = this.entityManager.createQuery("DELETE FROM Estudiante e WHERE e.nombre = :datoNombre");
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.executeUpdate();
	}

	@Override
	public int actualizarPorApellido(String nombre, String apellido) {
		//UPDATE estudiante SET estu_apellido=? WHERE estu_apellido=?
		//UPDATE Estudiante e SET e.nombre = :datoNombre Where e.apellido = :datoApellido
		Query myQuery = this.entityManager.createQuery("UPDATE Estudiante e SET e.nombre = :datoNombre Where e.apellido = :datoApellido\r\n"
				+ "");
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.executeUpdate();
	}

	@Override
	public List<EstudianteDTO> seleccionarTodosDTO() {
		//crea un EstudianteDTO mediante la tabla Estudiante
		//EstudianteDTO debe incluir el nombre completo, incluido el paquete
		TypedQuery<EstudianteDTO>myQuery = this.entityManager.createQuery("SELECT NEW com.example.demo.repository.modelo.dto.EstudianteDTO(e.nombre,e.apellido) FROM Estudiante e",EstudianteDTO.class);
		return myQuery.getResultList();
	}
	
}
