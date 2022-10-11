/*
 * @fileoverview {EnsambladorRecursoTramaComunicacion} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {EnsambladorRecursoTramaComunicacion} fue realizada el 31/07/2022.
 * @Dev - La primera version de {EnsambladorRecursoTramaComunicacion} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.web.rest.ensamblador;

import com.rtc.cardinal.definicion.servicio.dto.TramaComunicacionDTO;
import com.rtc.cardinal.definicion.web.rest.RecursoTramaComunicacion;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Definición de {@code EnsambladorRecursoTramaComunicacion}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Component
public class EnsambladorRecursoTramaComunicacion implements RepresentationModelAssembler<TramaComunicacionDTO, EntityModel<TramaComunicacionDTO>> {

    /**
     * TODO: Definición de {@code toModel}.
     *
     * @param entidadDTO
     * @return
     */
    @Override
    public EntityModel<TramaComunicacionDTO> toModel(TramaComunicacionDTO entidadDTO) {
        return new EntityModel<>(entidadDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoTramaComunicacion.class).buscarEntidad(String.valueOf(entidadDTO.getIntIdTrama()))).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoTramaComunicacion.class).obtenerEntidades()).withRel("TramaComunicacion"));
    }
}
