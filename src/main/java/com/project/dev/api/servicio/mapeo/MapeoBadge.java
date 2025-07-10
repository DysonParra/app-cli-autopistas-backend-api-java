/*
 * @overview        {MapeoBadge}
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

import com.project.dev.api.dominio.Badge;
import com.project.dev.api.dto.BadgeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Description of {@code MapeoBadge}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@Mapper(componentModel = "spring")
public interface MapeoBadge extends MapeoEntidadesGenerico<BadgeDTO, Badge> {

    /**
     * TODO: Description of method {@code obtenerDto}.
     *
     * @param entidad
     * @return 
     */
    @Mapping(source = "strTitle", target = "title")
    @Mapping(source = "strClasses", target = "classes")
    @Override
    public BadgeDTO obtenerDto(Badge entidad);

    /**
     * TODO: Description of method {@code obtenerEntidad}.
     *
     * @param entidadDTO
     * @return 
     */
    @Mapping(source = "title", target = "strTitle")
    @Mapping(source = "classes", target = "strClasses")
    @Override
    public Badge obtenerEntidad(BadgeDTO entidadDTO);

    /**
     * TODO: Description of method {@code desdeId}.
     *
     * @param intId
     * @return 
     */
    public default Badge desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Badge entidad = new Badge();
        entidad.setStrTitle(String.valueOf(intId));
        return entidad;
    }
}
