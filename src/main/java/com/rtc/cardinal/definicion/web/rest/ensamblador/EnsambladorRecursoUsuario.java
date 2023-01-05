/*
 * @fileoverview    {EnsambladorRecursoUsuario} se encarga de realizar tareas específicas.
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

import com.rtc.cardinal.definicion.servicio.dto.UsuarioDTO;
import com.rtc.cardinal.definicion.web.rest.RecursoUsuario;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * TODO: Definición de {@code EnsambladorRecursoUsuario}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Component
public class EnsambladorRecursoUsuario implements RepresentationModelAssembler<UsuarioDTO, EntityModel<UsuarioDTO>> {

    /**
     * TODO: Definición de {@code toModel}.
     *
     * @param entidadDTO
     * @return
     */
    @Override
    public EntityModel<UsuarioDTO> toModel(UsuarioDTO entidadDTO) {
        return new EntityModel<>(entidadDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoUsuario.class).buscarEntidad(String.valueOf(entidadDTO.getIntCedulaUsuario()))).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecursoUsuario.class).obtenerEntidades()).withRel("Usuario"));
    }
}
