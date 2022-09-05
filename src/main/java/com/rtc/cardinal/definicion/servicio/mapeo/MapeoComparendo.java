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
package com.rtc.cardinal.definicion.servicio.mapeo;

import com.rtc.cardinal.definicion.dominio.Comparendo;
import com.rtc.cardinal.definicion.servicio.dto.ComparendoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Definición de {@code MapeoComparendo}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoComparendo extends MapeoEntidadesGenerico<ComparendoDTO, Comparendo> {

    @Mapping(source = "intIdComparendo", target = "intIdComparendo")
    //TODO: deben ser el campo clave de la base de datos ( la llave )
    @Override
    public ComparendoDTO obtenerDto(Comparendo entidad);

    @Mapping(source = "intIdComparendo", target = "intIdComparendo")
    @Override
    public Comparendo obtenerEntidad(ComparendoDTO entidadDTO);

    default Comparendo desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Comparendo entidad = new Comparendo();
        entidad.setIntIdComparendo(Long.parseLong(intId));
        return entidad;
    }
}
