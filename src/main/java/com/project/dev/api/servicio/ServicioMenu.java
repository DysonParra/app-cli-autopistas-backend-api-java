/*
 * @fileoverview    {ServicioMenu}
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
package com.project.dev.api.servicio;

import com.project.dev.api.dto.MenuDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO: Description of {@code ServicioMenu}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
public interface ServicioMenu extends ServicioGenerico<MenuDTO> {

    /**
     * TODO: Description of {@code obtenerEntidades}.
     *
     * @param id
     * @return 
     * @throws java.lang.Exception 
     */
    public List<MenuDTO> obtenerEntidades(String id) throws Exception;

    /**
     * TODO: Description of {@code obtenerEntidades}.
     *
     * @param pageable
     * @throws java.lang.Exception
     */
    public Page<MenuDTO> obtenerEntidades(Pageable pageable) throws Exception;

    /**
     * TODO: Description of {@code query}.
     *
     * @param query
     * @param pageable
     */
    public Page<MenuDTO> query(String query, Pageable pageable);
}
