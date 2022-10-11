/*
 * @fileoverview {EnsambladorRecursoBadge} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {EnsambladorRecursoBadge} fue realizada el 31/07/2022.
 * @Dev - La primera version de {EnsambladorRecursoBadge} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.web.rest.ensamblador;

import com.rtc.cardinal.definicion.servicio.dto.BadgeDTO;
import com.rtc.cardinal.definicion.web.rest.RecursoBadge;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Definición de {@code EnsambladorRecursoBadge}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Component
public class EnsambladorRecursoBadge implements RepresentationModelAssembler<BadgeDTO, EntityModel<BadgeDTO>> {

    /**
     * TODO: Definición de {@code toModel}.
     *
     * @param entidadDTO
     * @return
     */
    @Override
    public EntityModel<BadgeDTO> toModel(BadgeDTO entidadDTO) {
        return new EntityModel<>(entidadDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoBadge.class).buscarEntidad(String.valueOf(entidadDTO.getTitle()))).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoBadge.class).obtenerEntidades()).withRel("Badge"));
    }
}
