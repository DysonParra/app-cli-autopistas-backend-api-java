/*
 * @fileoverview    {MapeoPolicia}
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

import com.project.dev.api.dominio.Policia;
import com.project.dev.api.dto.PoliciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Definición de {@code MapeoPolicia}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoPolicia extends MapeoEntidadesGenerico<PoliciaDTO, Policia> {

    @Mapping(source = "intIdPolicia", target = "intIdPolicia")
    //TODO: deben ser el campo clave de la base de datos ( la llave )
    @Override
    public PoliciaDTO obtenerDto(Policia entidad);

    @Mapping(source = "intIdPolicia", target = "intIdPolicia")
    @Override
    public Policia obtenerEntidad(PoliciaDTO entidadDTO);

    default Policia desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Policia entidad = new Policia();
        entidad.setIntIdPolicia(Long.parseLong(intId));
        return entidad;
    }
}
