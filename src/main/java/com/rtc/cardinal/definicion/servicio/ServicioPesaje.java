/*
 * @fileoverview {ServicioPesaje} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {ServicioPesaje} fue realizada el 31/07/2022.
 * @Dev - La primera version de {ServicioPesaje} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.servicio;

import com.rtc.cardinal.definicion.servicio.dto.PesajeDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO: Definición de {@code ServicioPesaje}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public interface ServicioPesaje extends ServicioGenerico<PesajeDTO> {

    public List<PesajeDTO> obtenerEntidades(String id) throws Exception;

    public Page<PesajeDTO> obtenerEntidades(Pageable pageable) throws Exception;

    public Page<PesajeDTO> query(String query, Pageable pageable);
}
