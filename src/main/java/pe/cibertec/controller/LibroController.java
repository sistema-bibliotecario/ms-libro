package pe.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.model.Libro;
import pe.cibertec.service.LibroService;

import java.util.List;

@RestController
@RequestMapping("/api/ms-libro")
public class LibroController {

	@Autowired
    LibroService libroService;

    @GetMapping("/listLibros")
    public ResponseEntity<List<Libro>> obtenerTodos() {
        return ResponseEntity.ok(libroService.listarLibros());
    }

    @GetMapping("/libro/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(libroService.obtenerLibroPorId(id));
    }

    @PostMapping("/agregarLibro")
    public void agregar(@RequestBody Libro libro) {
        libroService.agregarLibro(libro);
    }

    @PutMapping("/actualizarLibro/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody Libro libro) {
        return ResponseEntity.ok(libroService.actualizarLibro(id, libro));
    }

    @DeleteMapping("/eliminarLibro/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/libroPorIsbn")
    public ResponseEntity<Libro> obtenerPorIsbn(@RequestParam String isbn) {
        return ResponseEntity.ok(libroService.obtenerPorIsbn(isbn));
    }
}

