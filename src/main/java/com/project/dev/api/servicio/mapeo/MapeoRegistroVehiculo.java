/*
 * @overview        {MapeoRegistroVehiculo}
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

import com.project.dev.api.dominio.RegistroVehiculo;
import com.project.dev.api.dto.RegistroVehiculoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Description of {@code MapeoRegistroVehiculo}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@Mapper(componentModel = "spring")
public interface MapeoRegistroVehiculo extends MapeoEntidadesGenerico<RegistroVehiculoDTO, RegistroVehiculo> {

    /**
     * TODO: Description of method {@code obtenerDto}.
     *
     * @param entidad
     * @return 
     */
    @Mapping(source = "intTiqueteNro", target = "intTiqueteNro")
    @Override
    public RegistroVehiculoDTO obtenerDto(RegistroVehiculo entidad);

    /**
     * TODO: Description of method {@code obtenerEntidad}.
     *
     * @param entidadDTO
     * @return 
     */
    @Mapping(source = "intTiqueteNro", target = "intTiqueteNro")
    @Override
    public RegistroVehiculo obtenerEntidad(RegistroVehiculoDTO entidadDTO);

    /**
     * TODO: Description of method {@code desdeId}.
     *
     * @param intId
     * @return 
     */
    public default RegistroVehiculo desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        RegistroVehiculo entidad = new RegistroVehiculo();
        entidad.setIntTiqueteNro(Long.parseLong(intId));
        return entidad;
    }
}
