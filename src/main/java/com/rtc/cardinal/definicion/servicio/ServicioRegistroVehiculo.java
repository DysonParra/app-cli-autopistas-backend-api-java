/*
 * @fileoverview {ServicioRegistroVehiculo} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {ServicioRegistroVehiculo} fue realizada el 31/07/2022.
 * @Dev - La primera version de {ServicioRegistroVehiculo} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.servicio;

import com.rtc.cardinal.definicion.servicio.dto.RegistroVehiculoDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO: Definición de {@code ServicioRegistroVehiculo}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public interface ServicioRegistroVehiculo extends ServicioGenerico<RegistroVehiculoDTO> {

    public List<RegistroVehiculoDTO> obtenerEntidades(String id) throws Exception;

    public List<RegistroVehiculoDTO> ObtenerImpresion(String id) throws Exception;

    public Page<RegistroVehiculoDTO> obtenerEntidades(Pageable pageable) throws Exception;

    public Page<RegistroVehiculoDTO> query(String query, Pageable pageable);
}
