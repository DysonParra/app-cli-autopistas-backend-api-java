/*
 * @overview        {MapeoUsuario}
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
 * TODO: Description of {@code MapeoUsuario}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@Mapper(componentModel = "spring")
public interface MapeoUsuario extends MapeoEntidadesGenerico<UsuarioDTO, Usuario> {

    /**
     * TODO: Description of method {@code obtenerDto}.
     *
     * @param entidad
     * @return 
     */
    @Mapping(source = "intCedulaUsuario", target = "intCedulaUsuario")
    @Override
    public UsuarioDTO obtenerDto(Usuario entidad);

    /**
     * TODO: Description of method {@code obtenerEntidad}.
     *
     * @param entidadDTO
     * @return 
     */
    @Mapping(source = "intCedulaUsuario", target = "intCedulaUsuario")
    @Override
    public Usuario obtenerEntidad(UsuarioDTO entidadDTO);

    /**
     * TODO: Description of method {@code desdeId}.
     *
     * @param intId
     * @return 
     */
    public default Usuario desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Usuario entidad = new Usuario();
        entidad.setIntCedulaUsuario(Long.parseLong(intId));
        return entidad;
    }
}
