package com.cata.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cata.models.Conexion;
import com.cata.models.Ubicacion;

public interface ConexionRepository extends JpaRepository<Conexion, Long> {
	Optional<Conexion>  findByUbicacionO(Ubicacion ubicacionO);
}
