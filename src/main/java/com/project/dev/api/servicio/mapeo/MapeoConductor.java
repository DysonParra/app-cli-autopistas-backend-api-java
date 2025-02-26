/*
 * @fileoverview    {MapeoConductor}
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

import com.project.dev.api.dominio.Conductor;
import com.project.dev.api.dto.ConductorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Description of {@code MapeoConductor}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoConductor extends MapeoEntidadesGenerico<ConductorDTO, Conductor> {

    /**
     * TODO: Description of {@code obtenerDto}.
     *
     * @param entidad
     * @return 
     */
    @Mapping(source = "intCedulaConductor", target = "intCedulaConductor")
    @Override
    public ConductorDTO obtenerDto(Conductor entidad);

    /**
     * TODO: Description of {@code obtenerEntidad}.
     *
     * @param entidadDTO
     * @return 
     */
    @Mapping(source = "intCedulaConductor", target = "intCedulaConductor")
    @Override
    public Conductor obtenerEntidad(ConductorDTO entidadDTO);

    /**
     * TODO: Description of {@code desdeId}.
     *
     * @param intId
     * @return 
     */
    public default Conductor desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Conductor entidad = new Conductor();
        entidad.setIntCedulaConductor(Long.parseLong(intId));
        return entidad;
    }
}
