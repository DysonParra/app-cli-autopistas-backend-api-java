/*
 * @fileoverview    {MapeoTramaComunicacion}
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

import com.project.dev.api.dominio.TramaComunicacion;
import com.project.dev.api.dto.TramaComunicacionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Description of {@code MapeoTramaComunicacion}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoTramaComunicacion extends MapeoEntidadesGenerico<TramaComunicacionDTO, TramaComunicacion> {

    /**
     * TODO: Description of method {@code obtenerDto}.
     *
     * @param entidad
     * @return 
     */
    @Mapping(source = "intIdTrama", target = "intIdTrama")
    @Override
    public TramaComunicacionDTO obtenerDto(TramaComunicacion entidad);

    /**
     * TODO: Description of method {@code obtenerEntidad}.
     *
     * @param entidadDTO
     * @return 
     */
    @Mapping(source = "intIdTrama", target = "intIdTrama")
    @Override
    public TramaComunicacion obtenerEntidad(TramaComunicacionDTO entidadDTO);

    /**
     * TODO: Description of method {@code desdeId}.
     *
     * @param intId
     * @return 
     */
    public default TramaComunicacion desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        TramaComunicacion entidad = new TramaComunicacion();
        entidad.setIntIdTrama(Long.parseLong(intId));
        return entidad;
    }
}
