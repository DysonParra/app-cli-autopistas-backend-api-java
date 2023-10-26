/*
 * @fileoverview    {ServicioConductor}
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

import com.project.dev.api.dto.ConductorDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO: Definición de {@code ServicioConductor}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public interface ServicioConductor extends ServicioGenerico<ConductorDTO> {

    public List<ConductorDTO> obtenerEntidades(String id) throws Exception;

    public Page<ConductorDTO> obtenerEntidades(Pageable pageable) throws Exception;

    public Page<ConductorDTO> query(String query, Pageable pageable);
}
