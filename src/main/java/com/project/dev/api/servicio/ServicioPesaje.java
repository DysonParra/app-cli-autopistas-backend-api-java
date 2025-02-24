/*
 * @fileoverview    {ServicioPesaje}
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

import com.project.dev.api.dto.PesajeDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO: Description of {@code ServicioPesaje}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
public interface ServicioPesaje extends ServicioGenerico<PesajeDTO> {

    public List<PesajeDTO> obtenerEntidades(String id) throws Exception;

    public Page<PesajeDTO> obtenerEntidades(Pageable pageable) throws Exception;

    public Page<PesajeDTO> query(String query, Pageable pageable);
}
