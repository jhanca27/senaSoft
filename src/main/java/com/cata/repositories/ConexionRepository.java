package com.cata.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cata.models.Conexion;
import com.cata.models.Ubicacion;

public interface ConexionRepository extends JpaRepository<Conexion, Long> {
	List<Conexion>  findByUbicacionO(Ubicacion ubicacionO);
	Boolean existsByUbicacionO(Ubicacion ubicacionO);
	Boolean existsByUbicacionT(Ubicacion ubicacionT);
}
