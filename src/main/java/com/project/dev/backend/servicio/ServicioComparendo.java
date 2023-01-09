/*
 * @fileoverview    {ServicioComparendo} se encarga de realizar tareas específicas.
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

import com.project.dev.backend.servicio.dto.ComparendoDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO: Definición de {@code ServicioComparendo}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public interface ServicioComparendo extends ServicioGenerico<ComparendoDTO> {

    public List<ComparendoDTO> obtenerEntidades(String id) throws Exception;

    public Page<ComparendoDTO> obtenerEntidades(Pageable pageable) throws Exception;

    public Page<ComparendoDTO> query(String query, Pageable pageable);
}
