/*
 * @fileoverview {MapeoTramaComunicacion} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {MapeoTramaComunicacion} fue realizada el 31/07/2022.
 * @Dev - La primera version de {MapeoTramaComunicacion} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.servicio.mapeo;

import com.rtc.cardinal.definicion.dominio.TramaComunicacion;
import com.rtc.cardinal.definicion.servicio.dto.TramaComunicacionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Definición de {@code MapeoTramaComunicacion}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoTramaComunicacion extends MapeoEntidadesGenerico<TramaComunicacionDTO, TramaComunicacion> {

    @Mapping(source = "intIdTrama", target = "intIdTrama")
    //TODO: deben ser el campo clave de la base de datos ( la llave )
    @Override
    public TramaComunicacionDTO obtenerDto(TramaComunicacion entidad);

    @Mapping(source = "intIdTrama", target = "intIdTrama")
    @Override
    public TramaComunicacion obtenerEntidad(TramaComunicacionDTO entidadDTO);

    default TramaComunicacion desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        TramaComunicacion entidad = new TramaComunicacion();
        entidad.setIntIdTrama(Long.parseLong(intId));
        return entidad;
    }
}
