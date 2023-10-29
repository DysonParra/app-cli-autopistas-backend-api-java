/*
 * @fileoverview    {ServicioTramaComunicacion}
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

import com.project.dev.api.dto.TramaComunicacionDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO: Definición de {@code ServicioTramaComunicacion}.
 *
 * @author Dyson Parra
 * @since 11
 */
public interface ServicioTramaComunicacion extends ServicioGenerico<TramaComunicacionDTO> {

    public List<TramaComunicacionDTO> obtenerEntidades(String id) throws Exception;

    public Page<TramaComunicacionDTO> obtenerEntidades(Pageable pageable) throws Exception;

    public Page<TramaComunicacionDTO> query(String query, Pageable pageable);
}
