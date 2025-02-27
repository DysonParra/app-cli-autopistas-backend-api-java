/*
 * @fileoverview    {RepositorioUsuario}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementation done.
 * @version 2.0     Documentation added.
 */
package com.project.dev.api.repositorio;

import com.project.dev.api.dominio.Usuario;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * TODO: Description of {@code RepositorioUsuario}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

    /**
     * TODO: Description of method {@code findByIntCedulaUsuario}.
     *
     * @param id
     * @return 
     */
    public List<Usuario> findByIntCedulaUsuario(Long id);

    /**
     * TODO: Description of method {@code buscarEntidades}.
     *
     * @param strBusqueda
     * @param pageable
     */
    @Query("SELECT m FROM Usuario m WHERE m.intCedulaUsuario LIKE CONCAT('%', :strBusqueda, '%')")
    public Page<Usuario> buscarEntidades(@Param("strBusqueda") String strBusqueda, Pageable pageable);
}
