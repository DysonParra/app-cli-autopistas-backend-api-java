/*
 * @fileoverview    {ComparendoDTO} se encarga de realizar tareas específicas.
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
package com.project.dev.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Definición de {@code ComparendoDTO}.
 *
 * @author Dyson Parra
 * @since 1.8
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
