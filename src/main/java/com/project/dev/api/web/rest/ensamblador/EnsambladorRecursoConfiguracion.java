/*
 * @fileoverview    {EnsambladorRecursoConfiguracion}
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

import com.project.dev.api.dto.ConfiguracionDTO;
import com.project.dev.api.web.rest.RecursoConfiguracion;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Definición de {@code EnsambladorRecursoConfiguracion}.
 *
 * @author Dyson Parra
 * @since 11
 */
@Component
public class EnsambladorRecursoConfiguracion implements RepresentationModelAssembler<ConfiguracionDTO, EntityModel<ConfiguracionDTO>> {

    /**
     * TODO: Definición de {@code toModel}.
     *
     * @param entidadDTO
     * @return
     */
    @Override
    public EntityModel<ConfiguracionDTO> toModel(ConfiguracionDTO entidadDTO) {
        return new EntityModel<>(entidadDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoConfiguracion.class).buscarEntidad(String.valueOf(entidadDTO.getIntIdConfiguracion()))).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoConfiguracion.class).obtenerEntidades()).withRel("Configuracion"));
    }
}
