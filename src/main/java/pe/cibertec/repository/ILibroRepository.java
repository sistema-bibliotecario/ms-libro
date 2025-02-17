package pe.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.model.Libro;

import java.util.Optional;


public interface ILibroRepository extends JpaRepository<Libro, Integer> {
    Optional<Libro> findByIsbn(String isbn);
}
