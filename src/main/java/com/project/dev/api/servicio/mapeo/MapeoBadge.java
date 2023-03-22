/*
 * @fileoverview    {MapeoBadge}
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
package com.project.dev.api.servicio.mapeo;

import com.project.dev.api.dominio.Badge;
import com.project.dev.api.dto.BadgeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Definición de {@code MapeoBadge}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoBadge extends MapeoEntidadesGenerico<BadgeDTO, Badge> {

    @Mapping(source = "strTitle", target = "title")
    @Mapping(source = "strClasses", target = "classes")
    //TODO: deben ser el campo clave de la base de datos ( la llave )
    @Override
    public BadgeDTO obtenerDto(Badge entidad);

    @Mapping(source = "title", target = "strTitle")
    @Mapping(source = "classes", target = "strClasses")
    @Override
    public Badge obtenerEntidad(BadgeDTO entidadDTO);

    default Badge desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Badge entidad = new Badge();
        entidad.setStrTitle(String.valueOf(intId));
        return entidad;
    }
}
