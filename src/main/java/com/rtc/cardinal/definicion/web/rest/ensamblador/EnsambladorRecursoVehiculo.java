/*
 * @fileoverview {EnsambladorRecursoVehiculo} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {EnsambladorRecursoVehiculo} fue realizada el 31/07/2022.
 * @Dev - La primera version de {EnsambladorRecursoVehiculo} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.web.rest.ensamblador;

import com.rtc.cardinal.definicion.servicio.dto.VehiculoDTO;
import com.rtc.cardinal.definicion.web.rest.RecursoVehiculo;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Definición de {@code EnsambladorRecursoVehiculo}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Component
public class EnsambladorRecursoVehiculo implements RepresentationModelAssembler<VehiculoDTO, EntityModel<VehiculoDTO>> {

    /**
     * TODO: Definición de {@code toModel}.
     *
     * @param entidadDTO
     * @return
     */
    @Override
    public EntityModel<VehiculoDTO> toModel(VehiculoDTO entidadDTO) {
        return new EntityModel<>(entidadDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoVehiculo.class).buscarEntidad(String.valueOf(entidadDTO.getStrPlacaVehiculo()))).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoVehiculo.class).obtenerEntidades()).withRel("Vehiculo"));
    }
}
