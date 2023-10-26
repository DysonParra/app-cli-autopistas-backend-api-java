/*
 * @fileoverview    {EnsambladorRecursoVehiculo}
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

import com.project.dev.api.dto.VehiculoDTO;
import com.project.dev.api.web.rest.RecursoVehiculo;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Definición de {@code EnsambladorRecursoVehiculo}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Component
public class EnsambladorRecursoVehiculo implements RepresentationModelAssembler<VehiculoDTO, EntityModel<VehiculoDTO>> {

    /**
     * TODO: Definición de {@code toModel}.
     *
     * @param entidadDTO
     * @return
     */
    @Override
    public EntityModel<VehiculoDTO> toModel(VehiculoDTO entidadDTO) {
        return new EntityModel<>(entidadDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoVehiculo.class).buscarEntidad(String.valueOf(entidadDTO.getStrPlacaVehiculo()))).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoVehiculo.class).obtenerEntidades()).withRel("Vehiculo"));
    }
}
