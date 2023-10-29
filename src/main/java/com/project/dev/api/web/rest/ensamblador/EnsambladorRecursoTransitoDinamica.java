/*
 * @fileoverview    {EnsambladorRecursoTransitoDinamica}
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

import com.project.dev.api.dto.TransitoDinamicaDTO;
import com.project.dev.api.web.rest.RecursoTransitoDinamica;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Definición de {@code EnsambladorRecursoTransitoDinamica}.
 *
 * @author Dyson Parra
 * @since 11
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
