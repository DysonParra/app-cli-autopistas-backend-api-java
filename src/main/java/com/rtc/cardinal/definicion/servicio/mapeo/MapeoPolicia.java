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

import com.rtc.cardinal.definicion.dominio.Policia;
import com.rtc.cardinal.definicion.servicio.dto.PoliciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Definición de {@code MapeoPolicia}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoPolicia extends MapeoEntidadesGenerico<PoliciaDTO, Policia> {

    @Mapping(source = "intIdPolicia", target = "intIdPolicia")
    //TODO: deben ser el campo clave de la base de datos ( la llave )
    @Override
    public PoliciaDTO obtenerDto(Policia entidad);

    @Mapping(source = "intIdPolicia", target = "intIdPolicia")
    @Override
    public Policia obtenerEntidad(PoliciaDTO entidadDTO);

    default Policia desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Policia entidad = new Policia();
        entidad.setIntIdPolicia(Long.parseLong(intId));
        return entidad;
    }
}
