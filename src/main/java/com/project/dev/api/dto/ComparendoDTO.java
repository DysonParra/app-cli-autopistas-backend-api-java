/*
 * @fileoverview    {ComparendoDTO}
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
 * TODO: Description of {@code ComparendoDTO}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ComparendoDTO {

    private Long intIdComparendo;
    private Integer intCodigoComparendo;
    private String strObservaciones;
    private Character enmTipoInfractor;
    private Long intCedulaConductor;
    private Long intIdPolicia;
    private Long intTiqueteNro;
    private String strPlacaVehiculo;

}
