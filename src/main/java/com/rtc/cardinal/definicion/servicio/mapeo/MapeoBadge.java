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

import com.rtc.cardinal.definicion.dominio.Badge;
import com.rtc.cardinal.definicion.servicio.dto.BadgeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Definición de {@code MapeoBadge}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoBadge extends MapeoEntidadesGenerico<BadgeDTO, Badge> {

    @Mapping(source = "strTitle", target = "title")
    @Mapping(source = "strClasses", target = "classes")
    //TODO: deben ser el campo clave de la base de datos ( la llave )
    @Override
    public BadgeDTO obtenerDto(Badge entidad);

    @Mapping(source = "title", target = "strTitle")
    @Mapping(source = "classes", target = "strClasses")
    @Override
    public Badge obtenerEntidad(BadgeDTO entidadDTO);

    default Badge desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Badge entidad = new Badge();
        entidad.setStrTitle(String.valueOf(intId));
        return entidad;
    }
}
