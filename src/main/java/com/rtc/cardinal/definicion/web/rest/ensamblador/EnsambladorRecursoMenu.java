/*
 * @fileoverview {EnsambladorRecursoMenu} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {EnsambladorRecursoMenu} fue realizada el 31/07/2022.
 * @Dev - La primera version de {EnsambladorRecursoMenu} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.web.rest.ensamblador;

import com.rtc.cardinal.definicion.servicio.dto.MenuDTO;
import com.rtc.cardinal.definicion.web.rest.RecursoMenu;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Definición de {@code EnsambladorRecursoMenu}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Component
public class EnsambladorRecursoMenu implements RepresentationModelAssembler<MenuDTO, EntityModel<MenuDTO>> {

    /**
     * TODO: Definición de {@code toModel}.
     *
     * @param entidadDTO
     * @return
     */
    @Override
    public EntityModel<MenuDTO> toModel(MenuDTO entidadDTO) {
        return new EntityModel<>(entidadDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoMenu.class).buscarEntidad(String.valueOf(entidadDTO.getId()))).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoMenu.class).obtenerEntidades()).withRel("Menu"));
    }
}
