/*
 * @fileoverview    {EnsambladorRecursoVehiculoSobrepeso} se encarga de realizar tareas específicas.
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementación realizada.
 * @version 2.0     Documentación agregada.
 */
package com.rtc.cardinal.definicion.web.rest.ensamblador;

import com.rtc.cardinal.definicion.servicio.dto.VehiculoSobrepesoDTO;
import com.rtc.cardinal.definicion.web.rest.RecursoVehiculoSobrepeso;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Definición de {@code EnsambladorRecursoVehiculoSobrepeso}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Component
public class EnsambladorRecursoVehiculoSobrepeso implements RepresentationModelAssembler<VehiculoSobrepesoDTO, EntityModel<VehiculoSobrepesoDTO>> {

    /**
     * TODO: Definición de {@code toModel}.
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
