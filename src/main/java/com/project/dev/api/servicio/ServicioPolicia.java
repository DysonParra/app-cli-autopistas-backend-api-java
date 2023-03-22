/*
 * @fileoverview    {ServicioPolicia}
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
package com.project.dev.api.servicio;

import com.project.dev.api.dto.PoliciaDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO: Definición de {@code ServicioPolicia}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public interface ServicioPolicia extends ServicioGenerico<PoliciaDTO> {

    public List<PoliciaDTO> obtenerEntidades(String id) throws Exception;

    public Page<PoliciaDTO> obtenerEntidades(Pageable pageable) throws Exception;

    public Page<PoliciaDTO> query(String query, Pageable pageable);
}
