/*
 * @fileoverview    {RepositorioComparendo}
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

import com.project.dev.api.dominio.Comparendo;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * TODO: Definición de {@code RepositorioComparendo}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Repository
public interface RepositorioComparendo extends JpaRepository<Comparendo, Long> {

    public List<Comparendo> findByIntIdComparendo(Long id);

    @Query("SELECT m FROM Comparendo m WHERE m.intIdComparendo LIKE CONCAT('%', :strBusqueda, '%')")
    public Page<Comparendo> buscarEntidades(@Param("strBusqueda") String strBusqueda, Pageable pageable);
}
