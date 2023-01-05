/*
 * @fileoverview    {MapeoMenu} se encarga de realizar tareas específicas.
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
package com.rtc.cardinal.definicion.servicio.mapeo;

import com.rtc.cardinal.definicion.dominio.Menu;
import com.rtc.cardinal.definicion.servicio.dto.MenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO: Definición de {@code MapeoMenu}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Mapper(componentModel = "spring") //, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeoMenu extends MapeoEntidadesGenerico<MenuDTO, Menu> {

    @Mapping(source = "strId", target = "id")
    @Mapping(source = "strTitle", target = "title")
    @Mapping(source = "strSubtitle", target = "subtitle")
    @Mapping(source = "strType", target = "type")
    @Mapping(source = "strIcon", target = "icon")
    @Mapping(source = "strLink", target = "link")
    @Mapping(source = "bitExactMatch", target = "exactMatch")
    @Mapping(source = "bitActive", target = "active")
    @Mapping(source = "bitDisabled", target = "disabled")
    @Mapping(source = "strBadge", target = "badge")
    @Mapping(source = "strFather", target = "father")
    //TODO: deben ser el campo clave de la base de datos ( la llave )
    @Override
    public MenuDTO obtenerDto(Menu entidad);

    @Mapping(source = "id", target = "strId")
    @Mapping(source = "title", target = "strTitle")
    @Mapping(source = "subtitle", target = "strSubtitle")
    @Mapping(source = "type", target = "strType")
    @Mapping(source = "icon", target = "strIcon")
    @Mapping(source = "link", target = "strLink")
    @Mapping(source = "exactMatch", target = "bitExactMatch")
    @Mapping(source = "active", target = "bitActive")
    @Mapping(source = "disabled", target = "bitDisabled")
    @Mapping(source = "badge", target = "strBadge")
    @Mapping(source = "father", target = "strFather")
    @Override
    public Menu obtenerEntidad(MenuDTO entidadDTO);

    default Menu desdeId(String intId) {
        if (intId == null) {
            return null;
        }
        Menu entidad = new Menu();
        entidad.setStrId(String.valueOf(intId));
        return entidad;
    }
}
