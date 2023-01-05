/*
 * @fileoverview    {EnsambladorRecursoTransitoDinamica} se encarga de realizar tareas específicas.
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

import com.rtc.cardinal.definicion.servicio.dto.TransitoDinamicaDTO;
import com.rtc.cardinal.definicion.web.rest.RecursoTransitoDinamica;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Definición de {@code EnsambladorRecursoTransitoDinamica}.
 *
 * @author Dyson Parra
 * @since 1.8
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
