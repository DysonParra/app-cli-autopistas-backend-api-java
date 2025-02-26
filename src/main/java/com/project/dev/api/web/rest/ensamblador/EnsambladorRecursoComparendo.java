/*
 * @fileoverview    {EnsambladorRecursoComparendo}
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

import com.project.dev.api.dto.ComparendoDTO;
import com.project.dev.api.web.rest.RecursoComparendo;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Description of {@code EnsambladorRecursoComparendo}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@Component
public class EnsambladorRecursoComparendo implements RepresentationModelAssembler<ComparendoDTO, EntityModel<ComparendoDTO>> {

    /**
     * TODO: Description of method {@code toModel}.
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
