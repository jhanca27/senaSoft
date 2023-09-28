package com.cata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cata.models.Conexion;
import com.cata.models.Ubicacion;

public interface ConexionRepository extends JpaRepository<Conexion, Long> {
	List<Conexion>  findByUbicacion1(Ubicacion ubicacion1);
	Boolean existsByUbicacion1(Ubicacion ubicacion1);
	Boolean existsByUbicacion2(Ubicacion ubicacion2);
}
