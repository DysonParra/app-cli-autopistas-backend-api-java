/*
 * @fileoverview    {ServicioMenuImpl}
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
package com.project.dev.api.servicio.implementacion;

import com.project.dev.api.dominio.Menu;
import com.project.dev.api.dto.MenuDTO;
import com.project.dev.api.repositorio.RepositorioMenu;
import com.project.dev.api.servicio.ServicioMenu;
import com.project.dev.api.servicio.excepcion.ExcepcionEntidadNoEncontrado;
import com.project.dev.api.servicio.mapeo.MapeoMenu;
import java.util.List;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: Description of {@code ServicioMenuImpl}.
 *
 * @author Dyson Parra
 * @since 11
 */
@Service
@Transactional
public class ServicioMenuImpl implements ServicioMenu {

    private final Logger log = LoggerFactory.getLogger(ServicioMenuImpl.class);

    private final RepositorioMenu repositorioEntidad;

    private final MapeoMenu mapeoEntidad = Mappers.getMapper(MapeoMenu.class);

    /**
     * TODO: Description of {@code ServicioMenuImpl}.
     *
     * @param repositorioEntidad
     */
    public ServicioMenuImpl(RepositorioMenu repositorioEntidad) {
        this.repositorioEntidad = repositorioEntidad;
    }

    /**
     * TODO: Description of {@code guardarActualizar}.
     *
     */
    @Override
    public MenuDTO guardarActualizar(MenuDTO entidadDTO) throws Exception {
        log.debug("Solicitud para guardar la entidad : {}", entidadDTO);

        //TODO: agregar validacion especifica del servicio.
        Menu entidad = mapeoEntidad.obtenerEntidad(entidadDTO);
        entidad = repositorioEntidad.save(entidad);

        MenuDTO entidadActual = mapeoEntidad.obtenerDto(entidad);
        return entidadActual;
    }

    /**
     * TODO: Description of {@code obtenerEntidades}.
     *
     */
    @Override
    public List<MenuDTO> obtenerEntidades() throws Exception {
        log.debug("Solicitud para listar todas las Entidades");
        return mapeoEntidad.obtenerDto(repositorioEntidad.findAll());
    }

    /**
     * TODO: Description of {@code buscarEntidad}.
     *
     */
    @Override
    public MenuDTO buscarEntidad(String id) throws Exception {
        log.debug("Solicitud para buscar la Entidad : {}", id);
        Menu entidadBuscada = repositorioEntidad.findById(String.valueOf(id))
                .orElseThrow(() -> new ExcepcionEntidadNoEncontrado(id));
        return mapeoEntidad.obtenerDto(entidadBuscada);
    }

    /**
     * TODO: Description of {@code obtenerEntidades}.
     *
     * @param strId
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public List<MenuDTO> obtenerEntidades(String strId) throws Exception {
        log.debug("Solicitud para listar todas las Entidades");
        return (List<MenuDTO>) mapeoEntidad.obtenerDto(repositorioEntidad.findByStrId(String.valueOf(strId)));
    }

    /**
     * TODO: Description of {@code obtenerEntidades}.
     *
     * @param pageable
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public Page<MenuDTO> obtenerEntidades(Pageable pageable) throws Exception {
        log.debug("Solicitud para listar todas las Entidades");
        return repositorioEntidad.findAll(pageable).map(mapeoEntidad::obtenerDto);
    }

    /**
     * TODO: Description of {@code eliminarEntidad}.
     *
     */
    @Override
    public void eliminarEntidad(String id) throws Exception {
        log.debug("Solicitud para eliminar la entidad : {}", id);
        repositorioEntidad.deleteById(String.valueOf(id));
    }

    /**
     * TODO: Description of {@code query}.
     *
     * @param query
     * @param pageable
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public Page<MenuDTO> query(String query, Pageable pageable) {
        log.debug("Solicitud de búsqueda de una pagina de la entidad para consulta {}", query);
        return repositorioEntidad.buscarEntidades(query, pageable).map(mapeoEntidad::obtenerDto);
    }
}
