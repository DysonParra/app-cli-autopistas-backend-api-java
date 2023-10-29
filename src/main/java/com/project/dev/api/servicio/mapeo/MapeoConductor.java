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
 * TODO: Definición de {@code MapeoConductor}.
 *
 * @author Dyson Parra
 * @since 11
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoConductor extends MapeoEntidadesGenerico<ConductorDTO, Conductor> {

    @Mapping(source = "intCedulaConductor", target = "intCedulaConductor")
    //TODO: deben ser el campo clave de la base de datos ( la llave )
    @Override
    public ConductorDTO obtenerDto(Conductor entidad);

    @Mapping(source = "intCedulaConductor", target = "intCedulaConductor")
    @Override
    public Conductor obtenerEntidad(ConductorDTO entidadDTO);

    default Conductor desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Conductor entidad = new Conductor();
        entidad.setIntCedulaConductor(Long.parseLong(intId));
        return entidad;
    }
}
