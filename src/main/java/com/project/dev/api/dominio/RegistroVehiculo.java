/*
 * @fileoverview    {RegistroVehiculo} se encarga de realizar tareas específicas.
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
package com.project.dev.api.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Definición de {@code RegistroVehiculo}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Entity
//@Table(name = "RegistroVehiculo", schema = "cardinal", catalog = "cardinal")
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class RegistroVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long intTiqueteNro;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFechaHoraEstatica;
    private Long intPesoEstatica;
    private Long intSobrepeso;
    private Boolean bitPesajeAutorizado;
    private Boolean bitComparendo;
    @JoinColumn(name = "intIdCategoria", referencedColumnName = "intIdCategoria")
    private Long intIdCategoria;
    @JoinColumn(name = "intCedulaConductor", referencedColumnName = "intCedulaConductor")
    private Long intCedulaConductor;
    @JoinColumn(name = "intIdMercancia", referencedColumnName = "intIdMercancia")
    private Long intIdMercancia;
    @JoinColumn(name = "intCedulaUsuario", referencedColumnName = "intCedulaUsuario")
    private Long intCedulaUsuario;
    @JoinColumn(name = "strPlacaVehiculo", referencedColumnName = "strPlacaVehiculo")
    private String strPlacaVehiculo;
    @JoinColumn(name = "intIdRepeso", referencedColumnName = "intIdRepeso")
    private Long intIdRepeso;

}
