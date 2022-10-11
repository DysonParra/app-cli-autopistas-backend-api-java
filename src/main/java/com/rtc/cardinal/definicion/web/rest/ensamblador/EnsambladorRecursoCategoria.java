/*
 * @fileoverview {EnsambladorRecursoCategoria} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {EnsambladorRecursoCategoria} fue realizada el 31/07/2022.
 * @Dev - La primera version de {EnsambladorRecursoCategoria} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.web.rest.ensamblador;

import com.rtc.cardinal.definicion.servicio.dto.CategoriaDTO;
import com.rtc.cardinal.definicion.web.rest.RecursoCategoria;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Definición de {@code EnsambladorRecursoCategoria}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Component
public class EnsambladorRecursoCategoria implements RepresentationModelAssembler<CategoriaDTO, EntityModel<CategoriaDTO>> {

    /**
     * TODO: Definición de {@code toModel}.
     *
     * @param entidadDTO
     * @return
     */
    @Override
    public EntityModel<CategoriaDTO> toModel(CategoriaDTO entidadDTO) {
        return new EntityModel<>(entidadDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoCategoria.class).buscarEntidad(String.valueOf(entidadDTO.getIntIdCategoria()))).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoCategoria.class).obtenerEntidades()).withRel("Categoria"));
    }
}
