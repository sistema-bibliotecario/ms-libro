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

    @PostMapping("/agregarLibros")
    public ResponseEntity<Libro> agregar(@RequestBody Libro libro) {
        return ResponseEntity.status(201).body(libroService.agregarLibro(libro));
    }

    @PutMapping("/actualizarLibro/{id}")
    public ResponseEntity<Libro> actualizar(@PathVariable Integer id, @RequestBody Libro libro) {
        return ResponseEntity.ok(libroService.actualizarLibro(id, libro));
    }

    @DeleteMapping("/eliminarLibro/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar/titulo/{titulo}")
    public ResponseEntity<List<Libro>> buscarPorTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(libroService.listarLibros()
                .stream()
                .filter(libro -> libro.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .toList());
    }
}

