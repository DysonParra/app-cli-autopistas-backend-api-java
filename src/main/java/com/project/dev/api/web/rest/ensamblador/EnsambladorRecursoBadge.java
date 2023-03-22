/*
 * @fileoverview    {EnsambladorRecursoBadge}
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

import com.project.dev.api.dto.BadgeDTO;
import com.project.dev.api.web.rest.RecursoBadge;
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
