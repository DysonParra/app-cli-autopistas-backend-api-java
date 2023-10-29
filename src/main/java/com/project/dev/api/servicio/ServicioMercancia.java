/*
 * @fileoverview    {ServicioMercancia}
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

import com.project.dev.api.dto.MercanciaDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO: Definición de {@code ServicioMercancia}.
 *
 * @author Dyson Parra
 * @since 11
 */
public interface ServicioMercancia extends ServicioGenerico<MercanciaDTO> {

    public List<MercanciaDTO> obtenerEntidades(String id) throws Exception;

    public Page<MercanciaDTO> obtenerEntidades(Pageable pageable) throws Exception;

    public Page<MercanciaDTO> query(String query, Pageable pageable);
}
