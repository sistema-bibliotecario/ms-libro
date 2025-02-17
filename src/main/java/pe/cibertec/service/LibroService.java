package pe.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pe.cibertec.model.Libro;
import pe.cibertec.repository.ILibroRepository;

import java.util.List;

@Service
public class LibroService {
	
	@Autowired
    ILibroRepository libroRepository;

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public Libro obtenerLibroPorId(Integer id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado"));
    }

    public void agregarLibro(Libro libro) {
        libroRepository.save(libro);
    }

    public String actualizarLibro(Integer id, Libro libroActualizado) {
        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(libroActualizado.getTitulo());
            libro.setAutor(libroActualizado.getAutor());
            libro.setGenero(libroActualizado.getGenero());
            libro.setAnioPublicacion(libroActualizado.getAnioPublicacion());
            libroRepository.save(libro);
            return "Libro actualizado con exito";
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado"));
    }

    public String eliminarLibro(Integer id) {
        return libroRepository.findById(id).
                map(existingLibro -> {
                    libroRepository.delete(existingLibro);
                    return "Libro eliminado correctamente";
                }).orElse("Libro no encontrado con ID: " + id);
    }

    public Libro obtenerPorIsbn(String isbn) {
        return libroRepository.findByIsbn(isbn)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado con ISBN: " + isbn));
    }
}
