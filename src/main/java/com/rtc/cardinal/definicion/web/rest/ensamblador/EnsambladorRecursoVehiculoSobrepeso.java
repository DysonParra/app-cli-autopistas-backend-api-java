/*
 * @fileoverview {EnsambladorRecursoVehiculoSobrepeso} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {EnsambladorRecursoVehiculoSobrepeso} fue realizada el 31/07/2022.
 * @Dev - La primera version de {EnsambladorRecursoVehiculoSobrepeso} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.web.rest.ensamblador;

import com.rtc.cardinal.definicion.servicio.dto.VehiculoSobrepesoDTO;
import com.rtc.cardinal.definicion.web.rest.RecursoVehiculoSobrepeso;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Definición de {@code EnsambladorRecursoVehiculoSobrepeso}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Component
public class EnsambladorRecursoVehiculoSobrepeso implements RepresentationModelAssembler<VehiculoSobrepesoDTO, EntityModel<VehiculoSobrepesoDTO>> {

    /**
     * TODO: Definición de {@code toModel}.
     *
     * @param entidadDTO
     * @return
     */
    @Override
    public EntityModel<VehiculoSobrepesoDTO> toModel(VehiculoSobrepesoDTO entidadDTO) {
        return new EntityModel<>(entidadDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoVehiculoSobrepeso.class).buscarEntidad(String.valueOf(entidadDTO.getIntIdRepeso()))).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoVehiculoSobrepeso.class).obtenerEntidades()).withRel("VehiculoSobrepeso"));
    }
}
