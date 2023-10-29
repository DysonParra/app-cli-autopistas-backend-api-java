/*
 * @fileoverview    {Policia}
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
package com.project.dev.api.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Description of {@code Policia}.
 *
 * @author Dyson Parra
 * @since 11
 */
@Entity
//@Table(name = "Policia", schema = "cardinal", catalog = "cardinal")
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Policia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Long intIdPolicia;
    @Column(length = 50)
    private String strNombrePolicia;
    @Column(length = 50)
    private String strApellidoPolicia;
    @Column(length = 20)
    private String strTelefono;

}
