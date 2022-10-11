/*
 * @fileoverview {EnsambladorRecursoTransitoDinamica} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {EnsambladorRecursoTransitoDinamica} fue realizada el 31/07/2022.
 * @Dev - La primera version de {EnsambladorRecursoTransitoDinamica} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.web.rest.ensamblador;

import com.rtc.cardinal.definicion.servicio.dto.TransitoDinamicaDTO;
import com.rtc.cardinal.definicion.web.rest.RecursoTransitoDinamica;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Definición de {@code EnsambladorRecursoTransitoDinamica}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Component
public class EnsambladorRecursoTransitoDinamica implements RepresentationModelAssembler<TransitoDinamicaDTO, EntityModel<TransitoDinamicaDTO>> {

    /**
     * TODO: Definición de {@code toModel}.
     *
     * @param entidadDTO
     * @return
     */
    @Override
    public EntityModel<TransitoDinamicaDTO> toModel(TransitoDinamicaDTO entidadDTO) {
        return new EntityModel<>(entidadDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoTransitoDinamica.class).buscarEntidad(String.valueOf(entidadDTO.getIntIdDinamica()))).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoTransitoDinamica.class).obtenerEntidades()).withRel("TransitoDinamica"));
    }
}
