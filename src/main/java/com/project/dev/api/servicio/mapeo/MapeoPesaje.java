/*
 * @fileoverview    {MapeoPesaje}
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

import com.project.dev.api.dominio.Pesaje;
import com.project.dev.api.dto.PesajeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Description of {@code MapeoPesaje}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoPesaje extends MapeoEntidadesGenerico<PesajeDTO, Pesaje> {

    /**
     * TODO: Description of method {@code obtenerDto}.
     *
     * @param entidad
     * @return 
     */
    @Mapping(source = "intId", target = "intId")
    @Override
    public PesajeDTO obtenerDto(Pesaje entidad);

    /**
     * TODO: Description of method {@code obtenerEntidad}.
     *
     * @param entidadDTO
     * @return 
     */
    @Mapping(source = "intId", target = "intId")
    @Override
    public Pesaje obtenerEntidad(PesajeDTO entidadDTO);

    /**
     * TODO: Description of method {@code desdeId}.
     *
     * @param intId
     * @return 
     */
    public default Pesaje desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Pesaje entidad = new Pesaje();
        entidad.setIntId(Long.parseLong(intId));
        return entidad;
    }
}
