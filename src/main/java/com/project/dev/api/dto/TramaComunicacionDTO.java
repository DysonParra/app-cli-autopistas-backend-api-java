/*
 * @fileoverview    {TramaComunicacionDTO}
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
package com.project.dev.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Description of {@code TramaComunicacionDTO}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class TramaComunicacionDTO {

    private Long intIdTrama;
    private String strNombreTrama;
    private Integer intPosicionInicial;
    private Integer intTotalDatosPeso;
    private String crCaracterFin;
    private String crCaracterInicio;

}
