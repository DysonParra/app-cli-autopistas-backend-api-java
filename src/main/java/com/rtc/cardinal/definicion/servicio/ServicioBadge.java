/*
 * @fileoverview {ServicioBadge} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {ServicioBadge} fue realizada el 31/07/2022.
 * @Dev - La primera version de {ServicioBadge} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.servicio;

import com.rtc.cardinal.definicion.servicio.dto.BadgeDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO: Definición de {@code ServicioBadge}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public interface ServicioBadge extends ServicioGenerico<BadgeDTO> {

    public List<BadgeDTO> obtenerEntidades(String id) throws Exception;

    public Page<BadgeDTO> obtenerEntidades(Pageable pageable) throws Exception;

    public Page<BadgeDTO> query(String query, Pageable pageable);
}
