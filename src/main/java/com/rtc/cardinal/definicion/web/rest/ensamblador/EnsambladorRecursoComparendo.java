/*
 * @fileoverview {EnsambladorRecursoComparendo} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {EnsambladorRecursoComparendo} fue realizada el 31/07/2022.
 * @Dev - La primera version de {EnsambladorRecursoComparendo} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.web.rest.ensamblador;

import com.rtc.cardinal.definicion.servicio.dto.ComparendoDTO;
import com.rtc.cardinal.definicion.web.rest.RecursoComparendo;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Definición de {@code EnsambladorRecursoComparendo}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Component
public class EnsambladorRecursoComparendo implements RepresentationModelAssembler<ComparendoDTO, EntityModel<ComparendoDTO>> {

    /**
     * TODO: Definición de {@code toModel}.
     *
     * @param entidadDTO
     * @return
     */
    @Override
    public EntityModel<ComparendoDTO> toModel(ComparendoDTO entidadDTO) {
        return new EntityModel<>(entidadDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoComparendo.class).buscarEntidad(String.valueOf(entidadDTO.getIntIdComparendo()))).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoComparendo.class).obtenerEntidades()).withRel("Comparendo"));
    }
}
