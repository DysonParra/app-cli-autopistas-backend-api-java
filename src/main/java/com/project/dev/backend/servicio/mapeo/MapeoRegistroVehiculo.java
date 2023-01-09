/*
 * @fileoverview    {MapeoRegistroVehiculo} se encarga de realizar tareas específicas.
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
package com.project.dev.backend.servicio.mapeo;

import com.project.dev.backend.dominio.RegistroVehiculo;
import com.project.dev.backend.servicio.dto.RegistroVehiculoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Definición de {@code MapeoRegistroVehiculo}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoRegistroVehiculo extends MapeoEntidadesGenerico<RegistroVehiculoDTO, RegistroVehiculo> {

    @Mapping(source = "intTiqueteNro", target = "intTiqueteNro")
    //TODO: deben ser el campo clave de la base de datos ( la llave )
    @Override
    public RegistroVehiculoDTO obtenerDto(RegistroVehiculo entidad);

    @Mapping(source = "intTiqueteNro", target = "intTiqueteNro")
    @Override
    public RegistroVehiculo obtenerEntidad(RegistroVehiculoDTO entidadDTO);

    default RegistroVehiculo desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        RegistroVehiculo entidad = new RegistroVehiculo();
        entidad.setIntTiqueteNro(Long.parseLong(intId));
        return entidad;
    }
}
