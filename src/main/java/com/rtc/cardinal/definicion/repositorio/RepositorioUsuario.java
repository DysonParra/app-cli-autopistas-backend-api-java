/*
 * @fileoverview {RepositorioUsuario} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {RepositorioUsuario} fue realizada el 31/07/2022.
 * @Dev - La primera version de {RepositorioUsuario} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.repositorio;

import com.rtc.cardinal.definicion.dominio.Usuario;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * TODO: Definición de {@code RepositorioUsuario}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

    public List<Usuario> findByIntCedulaUsuario(Long id);

    @Query("SELECT m FROM Usuario m WHERE m.intCedulaUsuario LIKE CONCAT('%', :strBusqueda, '%')")
    public Page<Usuario> buscarEntidades(@Param("strBusqueda") String strBusqueda, Pageable pageable);
}
