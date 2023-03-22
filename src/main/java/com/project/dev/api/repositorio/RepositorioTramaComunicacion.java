/*
 * @fileoverview    {RepositorioTramaComunicacion}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementación realizada.
 * @version 2.0     Documentación agregada.
 */
package com.project.dev.api.repositorio;

import com.project.dev.api.dominio.TramaComunicacion;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * TODO: Definición de {@code RepositorioTramaComunicacion}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Repository
public interface RepositorioTramaComunicacion extends JpaRepository<TramaComunicacion, Long> {

    public List<TramaComunicacion> findByIntIdTrama(Long id);

    @Query("SELECT m FROM TramaComunicacion m WHERE m.intIdTrama LIKE CONCAT('%', :strBusqueda, '%')")
    public Page<TramaComunicacion> buscarEntidades(@Param("strBusqueda") String strBusqueda, Pageable pageable);
}
