/*
 * @fileoverview    {ServicioBadge}
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

import com.project.dev.api.dto.BadgeDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO: Description of {@code ServicioBadge}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
public interface ServicioBadge extends ServicioGenerico<BadgeDTO> {

    public List<BadgeDTO> obtenerEntidades(String id) throws Exception;

    public Page<BadgeDTO> obtenerEntidades(Pageable pageable) throws Exception;

    public Page<BadgeDTO> query(String query, Pageable pageable);
}
