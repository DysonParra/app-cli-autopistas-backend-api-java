/*
 * @fileoverview {MapeoPesaje} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {MapeoPesaje} fue realizada el 31/07/2022.
 * @Dev - La primera version de {MapeoPesaje} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.servicio.mapeo;

import com.rtc.cardinal.definicion.dominio.Pesaje;
import com.rtc.cardinal.definicion.servicio.dto.PesajeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Definición de {@code MapeoPesaje}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoPesaje extends MapeoEntidadesGenerico<PesajeDTO, Pesaje> {

    @Mapping(source = "intId", target = "intId")
    //TODO: deben ser el campo clave de la base de datos ( la llave )
    @Override
    public PesajeDTO obtenerDto(Pesaje entidad);

    @Mapping(source = "intId", target = "intId")
    @Override
    public Pesaje obtenerEntidad(PesajeDTO entidadDTO);

    default Pesaje desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Pesaje entidad = new Pesaje();
        entidad.setIntId(Long.parseLong(intId));
        return entidad;
    }
}
