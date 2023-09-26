package com.cata.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cata.models.Ubicacion;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {
    Optional<Ubicacion> findByNombre(String nombre);
}
