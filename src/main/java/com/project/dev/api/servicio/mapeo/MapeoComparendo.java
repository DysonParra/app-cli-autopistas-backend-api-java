/*
 * @fileoverview    {MapeoComparendo}
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

import com.project.dev.api.dominio.Comparendo;
import com.project.dev.api.dto.ComparendoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Description of {@code MapeoComparendo}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoComparendo extends MapeoEntidadesGenerico<ComparendoDTO, Comparendo> {

    @Mapping(source = "intIdComparendo", target = "intIdComparendo")
    //TODO: deben ser el campo clave de la base de datos ( la llave )
    @Override
    public ComparendoDTO obtenerDto(Comparendo entidad);

    @Mapping(source = "intIdComparendo", target = "intIdComparendo")
    @Override
    public Comparendo obtenerEntidad(ComparendoDTO entidadDTO);

    default Comparendo desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Comparendo entidad = new Comparendo();
        entidad.setIntIdComparendo(Long.parseLong(intId));
        return entidad;
    }
}
