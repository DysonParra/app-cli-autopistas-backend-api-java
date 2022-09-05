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
package com.rtc.cardinal.definicion.servicio;

import com.rtc.cardinal.definicion.servicio.dto.ComparendoDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO: Definición de {@code ServicioComparendo}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public interface ServicioComparendo extends ServicioGenerico<ComparendoDTO> {

    public List<ComparendoDTO> obtenerEntidades(String id) throws Exception;

    public Page<ComparendoDTO> obtenerEntidades(Pageable pageable) throws Exception;

    public Page<ComparendoDTO> query(String query, Pageable pageable);
}
