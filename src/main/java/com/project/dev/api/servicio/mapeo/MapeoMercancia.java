/*
 * @fileoverview    {MapeoMercancia}
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

import com.project.dev.api.dominio.Mercancia;
import com.project.dev.api.dto.MercanciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Description of {@code MapeoMercancia}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoMercancia extends MapeoEntidadesGenerico<MercanciaDTO, Mercancia> {

    @Mapping(source = "intIdMercancia", target = "intIdMercancia")
    //TODO: deben ser el campo clave de la base de datos ( la llave )
    @Override
    public MercanciaDTO obtenerDto(Mercancia entidad);

    @Mapping(source = "intIdMercancia", target = "intIdMercancia")
    @Override
    public Mercancia obtenerEntidad(MercanciaDTO entidadDTO);

    default Mercancia desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Mercancia entidad = new Mercancia();
        entidad.setIntIdMercancia(Long.parseLong(intId));
        return entidad;
    }
}
