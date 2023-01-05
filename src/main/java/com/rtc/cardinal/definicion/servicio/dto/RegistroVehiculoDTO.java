/*
 * @fileoverview    {RegistroVehiculoDTO} se encarga de realizar tareas específicas.
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
package com.rtc.cardinal.definicion.servicio.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Definición de {@code RegistroVehiculoDTO}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class RegistroVehiculoDTO {

    private Long intTiqueteNro;
    private Date dtFechaHoraEstatica;
    private Long intPesoEstatica;
    private Long intSobrepeso;
    private Boolean bitPesajeAutorizado;
    private Boolean bitComparendo;
    private Long intIdCategoria;
    private Long intCedulaConductor;
    private Long intIdMercancia;
    private Long intCedulaUsuario;
    private String strPlacaVehiculo;
    private Long intIdRepeso;

}
