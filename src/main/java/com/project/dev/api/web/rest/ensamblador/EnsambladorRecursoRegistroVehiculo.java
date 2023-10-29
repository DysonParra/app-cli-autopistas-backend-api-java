/*
 * @fileoverview    {EnsambladorRecursoRegistroVehiculo}
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

import com.project.dev.api.dto.RegistroVehiculoDTO;
import com.project.dev.api.web.rest.RecursoRegistroVehiculo;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Definición de {@code EnsambladorRecursoRegistroVehiculo}.
 *
 * @author Dyson Parra
 * @since 11
 */
@Component
public class EnsambladorRecursoRegistroVehiculo implements RepresentationModelAssembler<RegistroVehiculoDTO, EntityModel<RegistroVehiculoDTO>> {

    /**
     * TODO: Definición de {@code toModel}.
     *
     * @param entidadDTO
     * @return
     */
    @Override
    public EntityModel<RegistroVehiculoDTO> toModel(RegistroVehiculoDTO entidadDTO) {
        return new EntityModel<>(entidadDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoRegistroVehiculo.class).buscarEntidad(String.valueOf(entidadDTO.getIntTiqueteNro()))).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoRegistroVehiculo.class).obtenerEntidades()).withRel("RegistroVehiculo"));
    }
}
