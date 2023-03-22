/*
 * @fileoverview    {EnsambladorRecursoCategoria}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementación realizada.
 * @version 2.0     Documentación agregada.
 */
package com.project.dev.api.web.rest.ensamblador;

import com.project.dev.api.dto.CategoriaDTO;
import com.project.dev.api.web.rest.RecursoCategoria;
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
