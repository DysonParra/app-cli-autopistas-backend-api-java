/*
 * @fileoverview    {MapeoUsuario}
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
package com.project.dev.api.servicio.mapeo;

import com.project.dev.api.dominio.Usuario;
import com.project.dev.api.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Definición de {@code MapeoUsuario}.
 *
 * @author Dyson Parra
 * @since 11
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
