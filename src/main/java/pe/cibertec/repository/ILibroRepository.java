package pe.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.model.Libro;


public interface ILibroRepository extends JpaRepository<Libro, Integer> {
    
   
}
