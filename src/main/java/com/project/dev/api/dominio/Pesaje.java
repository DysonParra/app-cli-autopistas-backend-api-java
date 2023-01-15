/*
 * @fileoverview    {Pesaje} se encarga de realizar tareas específicas.
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
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Definición de {@code Pesaje}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Entity
//@Table(name = "Pesaje", schema = "cardinal", catalog = "cardinal")
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Pesaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long intId;
    private Long intTiqueteNumero;
    private String strPlaca;
    private String strCodigo;
    private Long intNumeroInterno;
    private String strTipoVehiculo;
    private String strConductor;
    private String strCedula;
    private String strProducto;
    private String strPlanta;
    private String strCliente;
    private String strTransportadora;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFechaHoraPesoVacio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFechaHoraPesoLleno;
    private String strCiv;
    private String strDireccion;
    private String strEntregadoPor;
    private String strRecibidoPor;
    private String strShipment;
    private String strSello;
    private String strR;
    private String strContenedor;
    private String strObservacion;
    @Column(columnDefinition = "enum")
    private String enmTipoIngreso;

}
