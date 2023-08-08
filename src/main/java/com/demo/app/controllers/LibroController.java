package com.demo.app.controllers;

import com.demo.app.models.Libro;
import com.demo.app.repositories.LibroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libros")
public class LibroController {

  // Inyectamos LibroRepository mediante la anotación @Autowired para manejar las operaciones de base de datos.
  @Autowired
  private final LibroRepository libroRepository;

  public LibroController(LibroRepository libroRepository) {
    this.libroRepository = libroRepository;
  }

  @GetMapping
  public List<Libro> obtenerLibros() {
    return libroRepository.findAll();
  }

  @PostMapping
  public @ResponseBody String addNewLibro(
    @RequestParam String name,
    @RequestParam String autor,
    @RequestParam int anio
  ) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Libro  n = new Libro();
    n.setTitulo(name);
    n.setAnio(anio);
    n.setAutor(autor);
    libroRepository.save(n);
    return "Saved";
  }

//   @GetMapping("/{id}")
//   public Libro obtenerLibroPorId(@PathVariable Long id) {
//     return libroRepository.findById(id).orElse(null);
//   }

//   @PutMapping("/{id}")
//   public Libro actualizarLibro(
//     @PathVariable Long id,
//     @RequestBody Libro libroActualizado
//   ) {
//     return libroRepository
//       .findById(id)
//       .map(libro -> {
//         libro.setTitulo(libroActualizado.getTitulo());
//         libro.setAutor(libroActualizado.getAutor());
//         libro.setAnio(libroActualizado.getAnio());
//         return libroRepository.save(libro);
//       })
//       .orElse(null);
//   }

//   @DeleteMapping("/{id}")
//   public String eliminarLibro(@PathVariable Long id) {
//     libroRepository.deleteById(id);
//     return "Libro eliminado";
//   }
}
