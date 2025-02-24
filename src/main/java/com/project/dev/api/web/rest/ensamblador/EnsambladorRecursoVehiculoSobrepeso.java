/*
 * @fileoverview    {EnsambladorRecursoVehiculoSobrepeso}
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

import com.project.dev.api.dto.VehiculoSobrepesoDTO;
import com.project.dev.api.web.rest.RecursoVehiculoSobrepeso;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Description of {@code EnsambladorRecursoVehiculoSobrepeso}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@Component
public class EnsambladorRecursoVehiculoSobrepeso implements RepresentationModelAssembler<VehiculoSobrepesoDTO, EntityModel<VehiculoSobrepesoDTO>> {

    /**
     * TODO: Description of {@code toModel}.
     *
     * @param entidadDTO
     * @return
     */
    @Override
    public EntityModel<VehiculoSobrepesoDTO> toModel(VehiculoSobrepesoDTO entidadDTO) {
        return new EntityModel<>(entidadDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoVehiculoSobrepeso.class).buscarEntidad(String.valueOf(entidadDTO.getIntIdRepeso()))).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoVehiculoSobrepeso.class).obtenerEntidades()).withRel("VehiculoSobrepeso"));
    }
}
