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

import com.rtc.cardinal.definicion.dominio.Mercancia;
import com.rtc.cardinal.definicion.servicio.dto.MercanciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Definición de {@code MapeoMercancia}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoMercancia extends MapeoEntidadesGenerico<MercanciaDTO, Mercancia> {

    @Mapping(source = "intIdMercancia", target = "intIdMercancia")
    //TODO: deben ser el campo clave de la base de datos ( la llave )
    @Override
    public MercanciaDTO obtenerDto(Mercancia entidad);

    @Mapping(source = "intIdMercancia", target = "intIdMercancia")
    @Override
    public Mercancia obtenerEntidad(MercanciaDTO entidadDTO);

    default Mercancia desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Mercancia entidad = new Mercancia();
        entidad.setIntIdMercancia(Long.parseLong(intId));
        return entidad;
    }
}
