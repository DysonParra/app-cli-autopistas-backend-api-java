/*
 * @fileoverview {Comparendo} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {Comparendo} fue realizada el 31/07/2022.
 * @Dev - La primera version de {Comparendo} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Definición de {@code Comparendo}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Entity
//@Table(name = "Comparendo", schema = "cardinal", catalog = "cardinal")
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Comparendo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Long intIdComparendo;
    private Integer intCodigoComparendo;
    @Column(length = 200)
    private String strObservaciones;
    private Character enmTipoInfractor;
    @JoinColumn(name = "intCedulaConductor", referencedColumnName = "intCedulaConductor")
    private Long intCedulaConductor;
    @JoinColumn(name = "intIdPolicia", referencedColumnName = "intIdPolicia")
    private Long intIdPolicia;
    @JoinColumn(name = "intTiqueteNro", referencedColumnName = "intTiqueteNro")
    private Long intTiqueteNro;
    @JoinColumn(name = "strPlacaVehiculo", referencedColumnName = "strPlacaVehiculo")
    private String strPlacaVehiculo;

}
