/*
 * @fileoverview {FileName} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {FileName} fue realizada el 31/07/2022.
 * @Dev - La primera version de {FileName} fue escrita por Dyson A. Parra T.
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
 * TODO: Definición de {@code Menu}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Entity
//@Table(name = "Menu", schema = "cardinal", catalog = "cardinal")
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 200)
    private String strId;
    @Column(length = 100)
    private String strTitle;
    @Column(length = 200)
    private String strSubtitle;
    @Column(length = 100)
    private String strType;
    @Column(length = 100)
    private String strIcon;
    @Column(length = 100)
    private String strLink;
    private Boolean bitExactMatch;
    private Boolean bitActive;
    private Boolean bitDisabled;
    @JoinColumn(name = "strBadge", referencedColumnName = "strTitle")
    private String strBadge;
    @JoinColumn(name = "strFather", referencedColumnName = "strId")
    private String strFather;

}
