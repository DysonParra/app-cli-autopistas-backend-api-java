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
 * TODO: Description of {@code MapeoPolicia}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoPolicia extends MapeoEntidadesGenerico<PoliciaDTO, Policia> {

    /**
     * TODO: Description of method {@code obtenerDto}.
     *
     * @param entidad
     * @return 
     */
    @Mapping(source = "intIdPolicia", target = "intIdPolicia")
    @Override
    public PoliciaDTO obtenerDto(Policia entidad);

    /**
     * TODO: Description of method {@code obtenerEntidad}.
     *
     * @param entidadDTO
     * @return 
     */
    @Mapping(source = "intIdPolicia", target = "intIdPolicia")
    @Override
    public Policia obtenerEntidad(PoliciaDTO entidadDTO);

    /**
     * TODO: Description of method {@code desdeId}.
     *
     * @param intId
     * @return 
     */
    public default Policia desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Policia entidad = new Policia();
        entidad.setIntIdPolicia(Long.parseLong(intId));
        return entidad;
    }
}
