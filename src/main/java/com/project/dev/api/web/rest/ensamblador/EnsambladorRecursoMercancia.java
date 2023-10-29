/*
 * @fileoverview    {EnsambladorRecursoMercancia}
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

import com.project.dev.api.dto.MercanciaDTO;
import com.project.dev.api.web.rest.RecursoMercancia;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Description of {@code EnsambladorRecursoMercancia}.
 *
 * @author Dyson Parra
 * @since 11
 */
@Component
public class EnsambladorRecursoMercancia implements RepresentationModelAssembler<MercanciaDTO, EntityModel<MercanciaDTO>> {

    /**
     * TODO: Description of {@code toModel}.
     *
     * @param entidadDTO
     * @return
     */
    @Override
    public EntityModel<MercanciaDTO> toModel(MercanciaDTO entidadDTO) {
        return new EntityModel<>(entidadDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoMercancia.class).buscarEntidad(String.valueOf(entidadDTO.getIntIdMercancia()))).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoMercancia.class).obtenerEntidades()).withRel("Mercancia"));
    }
}
