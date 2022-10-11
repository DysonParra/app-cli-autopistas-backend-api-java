/*
 * @fileoverview {EnsambladorRecursoRegistroVehiculo} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {EnsambladorRecursoRegistroVehiculo} fue realizada el 31/07/2022.
 * @Dev - La primera version de {EnsambladorRecursoRegistroVehiculo} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.web.rest.ensamblador;

import com.rtc.cardinal.definicion.servicio.dto.RegistroVehiculoDTO;
import com.rtc.cardinal.definicion.web.rest.RecursoRegistroVehiculo;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Definición de {@code EnsambladorRecursoRegistroVehiculo}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Component
public class EnsambladorRecursoRegistroVehiculo implements RepresentationModelAssembler<RegistroVehiculoDTO, EntityModel<RegistroVehiculoDTO>> {

    /**
     * TODO: Definición de {@code toModel}.
     *
     * @param entidadDTO
     * @return
     */
    @Override
    public EntityModel<RegistroVehiculoDTO> toModel(RegistroVehiculoDTO entidadDTO) {
        return new EntityModel<>(entidadDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoRegistroVehiculo.class).buscarEntidad(String.valueOf(entidadDTO.getIntTiqueteNro()))).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoRegistroVehiculo.class).obtenerEntidades()).withRel("RegistroVehiculo"));
    }
}
