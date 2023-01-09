/*
 * @fileoverview    {ServicioPesaje} se encarga de realizar tareas específicas.
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
package com.project.dev.backend.servicio;

import com.project.dev.backend.servicio.dto.PesajeDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO: Definición de {@code ServicioPesaje}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public interface ServicioPesaje extends ServicioGenerico<PesajeDTO> {

    public List<PesajeDTO> obtenerEntidades(String id) throws Exception;

    public Page<PesajeDTO> obtenerEntidades(Pageable pageable) throws Exception;

    public Page<PesajeDTO> query(String query, Pageable pageable);
}
