/*
 * @fileoverview {FileName} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {FileName} fue realizada el 31/07/2022.
 * @Dev - La primera version de {FileName} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.servicio.mapeo;

import com.rtc.cardinal.definicion.dominio.Usuario;
import com.rtc.cardinal.definicion.servicio.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Definición de {@code MapeoUsuario}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoUsuario extends MapeoEntidadesGenerico<UsuarioDTO, Usuario> {

    @Mapping(source = "intCedulaUsuario", target = "intCedulaUsuario")
    //TODO: deben ser el campo clave de la base de datos ( la llave )
    @Override
    public UsuarioDTO obtenerDto(Usuario entidad);

    @Mapping(source = "intCedulaUsuario", target = "intCedulaUsuario")
    @Override
    public Usuario obtenerEntidad(UsuarioDTO entidadDTO);

    default Usuario desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Usuario entidad = new Usuario();
        entidad.setIntCedulaUsuario(Long.parseLong(intId));
        return entidad;
    }
}
