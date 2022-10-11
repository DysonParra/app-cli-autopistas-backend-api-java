/*
 * @fileoverview {MapeoRegistroVehiculo} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {MapeoRegistroVehiculo} fue realizada el 31/07/2022.
 * @Dev - La primera version de {MapeoRegistroVehiculo} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.servicio.mapeo;

import com.rtc.cardinal.definicion.dominio.RegistroVehiculo;
import com.rtc.cardinal.definicion.servicio.dto.RegistroVehiculoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Definición de {@code MapeoRegistroVehiculo}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoRegistroVehiculo extends MapeoEntidadesGenerico<RegistroVehiculoDTO, RegistroVehiculo> {

    @Mapping(source = "intTiqueteNro", target = "intTiqueteNro")
    //TODO: deben ser el campo clave de la base de datos ( la llave )
    @Override
    public RegistroVehiculoDTO obtenerDto(RegistroVehiculo entidad);

    @Mapping(source = "intTiqueteNro", target = "intTiqueteNro")
    @Override
    public RegistroVehiculo obtenerEntidad(RegistroVehiculoDTO entidadDTO);

    default RegistroVehiculo desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        RegistroVehiculo entidad = new RegistroVehiculo();
        entidad.setIntTiqueteNro(Long.parseLong(intId));
        return entidad;
    }
}
