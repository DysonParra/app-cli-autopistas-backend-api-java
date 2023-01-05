/*
 * @fileoverview    {RepositorioBadge} se encarga de realizar tareas específicas.
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
package com.rtc.cardinal.definicion.repositorio;

import com.rtc.cardinal.definicion.dominio.Badge;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * TODO: Definición de {@code RepositorioBadge}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Repository
public interface RepositorioBadge extends JpaRepository<Badge, String> {

    public List<Badge> findByStrTitle(String id);

    @Query("SELECT m FROM Badge m WHERE m.strTitle LIKE CONCAT('%', :strBusqueda, '%')")
    public Page<Badge> buscarEntidades(@Param("strBusqueda") String strBusqueda, Pageable pageable);
}
