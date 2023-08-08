package com.demo.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.app.models.Libro;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
