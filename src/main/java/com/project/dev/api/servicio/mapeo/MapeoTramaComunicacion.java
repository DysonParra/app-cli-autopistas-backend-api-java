/*
 * @fileoverview    {MapeoTramaComunicacion} se encarga de realizar tareas específicas.
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

import com.project.dev.api.dominio.TramaComunicacion;
import com.project.dev.api.dto.TramaComunicacionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Definición de {@code MapeoTramaComunicacion}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoTramaComunicacion extends MapeoEntidadesGenerico<TramaComunicacionDTO, TramaComunicacion> {

    @Mapping(source = "intIdTrama", target = "intIdTrama")
    //TODO: deben ser el campo clave de la base de datos ( la llave )
    @Override
    public TramaComunicacionDTO obtenerDto(TramaComunicacion entidad);

    @Mapping(source = "intIdTrama", target = "intIdTrama")
    @Override
    public TramaComunicacion obtenerEntidad(TramaComunicacionDTO entidadDTO);

    default TramaComunicacion desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        TramaComunicacion entidad = new TramaComunicacion();
        entidad.setIntIdTrama(Long.parseLong(intId));
        return entidad;
    }
}
