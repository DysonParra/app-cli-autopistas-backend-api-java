/*
 * @overview        {EnsambladorRecursoMenu}
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

import com.project.dev.api.dto.MenuDTO;
import com.project.dev.api.web.rest.RecursoMenu;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Description of {@code EnsambladorRecursoMenu}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@Component
public class EnsambladorRecursoMenu implements RepresentationModelAssembler<MenuDTO, EntityModel<MenuDTO>> {

    /**
     * TODO: Description of method {@code toModel}.
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
