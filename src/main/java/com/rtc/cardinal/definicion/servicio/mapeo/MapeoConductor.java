/*
 * @fileoverview {MapeoConductor} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {MapeoConductor} fue realizada el 31/07/2022.
 * @Dev - La primera version de {MapeoConductor} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.servicio.mapeo;

import com.rtc.cardinal.definicion.dominio.Conductor;
import com.rtc.cardinal.definicion.servicio.dto.ConductorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Definición de {@code MapeoConductor}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoConductor extends MapeoEntidadesGenerico<ConductorDTO, Conductor> {

    @Mapping(source = "intCedulaConductor", target = "intCedulaConductor")
    //TODO: deben ser el campo clave de la base de datos ( la llave )
    @Override
    public ConductorDTO obtenerDto(Conductor entidad);

    @Mapping(source = "intCedulaConductor", target = "intCedulaConductor")
    @Override
    public Conductor obtenerEntidad(ConductorDTO entidadDTO);

    default Conductor desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Conductor entidad = new Conductor();
        entidad.setIntCedulaConductor(Long.parseLong(intId));
        return entidad;
    }
}
