/*
 * @fileoverview    {EnsambladorRecursoTramaComunicacion}
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

import com.project.dev.api.dto.TramaComunicacionDTO;
import com.project.dev.api.web.rest.RecursoTramaComunicacion;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Description of {@code EnsambladorRecursoTramaComunicacion}.
 *
 * @author Dyson Parra
 * @since 11
 */
@Component
public class EnsambladorRecursoTramaComunicacion implements RepresentationModelAssembler<TramaComunicacionDTO, EntityModel<TramaComunicacionDTO>> {

    /**
     * TODO: Description of {@code toModel}.
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
