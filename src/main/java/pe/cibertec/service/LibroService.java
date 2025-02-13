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

    public Libro agregarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro actualizarLibro(Integer id, Libro libroActualizado) {
        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(libroActualizado.getTitulo());
            libro.setAutor(libroActualizado.getAutor());
            libro.setGenero(libroActualizado.getGenero());
            libro.setAnioPublicacion(libroActualizado.getAnioPublicacion());
            return libroRepository.save(libro);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado"));
    }

    public void eliminarLibro(Integer id) {
        if (!libroRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado");
        }
        libroRepository.deleteById(id);
    }
}
