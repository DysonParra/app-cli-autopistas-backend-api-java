/*
 * @fileoverview    {EnsambladorRecursoPolicia}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementation done.
 * @version 2.0     Documentation added.
 */
package com.project.dev.api.web.rest.ensamblador;

import com.project.dev.api.dto.PoliciaDTO;
import com.project.dev.api.web.rest.RecursoPolicia;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Definición de {@code EnsambladorRecursoPolicia}.
 *
 * @author Dyson Parra
 * @since 11
 */
@Component
public class EnsambladorRecursoPolicia implements RepresentationModelAssembler<PoliciaDTO, EntityModel<PoliciaDTO>> {

    /**
     * TODO: Definición de {@code toModel}.
     *
     * @param entidadDTO
     * @return
     */
    @Override
    public EntityModel<PoliciaDTO> toModel(PoliciaDTO entidadDTO) {
        return new EntityModel<>(entidadDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoPolicia.class).buscarEntidad(String.valueOf(entidadDTO.getIntIdPolicia()))).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoPolicia.class).obtenerEntidades()).withRel("Policia"));
    }
}
