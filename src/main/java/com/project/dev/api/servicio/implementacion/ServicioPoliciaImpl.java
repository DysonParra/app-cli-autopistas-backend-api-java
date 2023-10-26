/*
 * @fileoverview    {ServicioPoliciaImpl}
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

import com.project.dev.api.dominio.Policia;
import com.project.dev.api.dto.PoliciaDTO;
import com.project.dev.api.repositorio.RepositorioPolicia;
import com.project.dev.api.servicio.ServicioPolicia;
import com.project.dev.api.servicio.excepcion.ExcepcionEntidadNoEncontrado;
import com.project.dev.api.servicio.mapeo.MapeoPolicia;
import java.util.List;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: Definición de {@code ServicioPoliciaImpl}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Service
@Transactional
public class ServicioPoliciaImpl implements ServicioPolicia {

    private final Logger log = LoggerFactory.getLogger(ServicioPoliciaImpl.class);

    private final RepositorioPolicia repositorioEntidad;

    private final MapeoPolicia mapeoEntidad = Mappers.getMapper(MapeoPolicia.class);

    /**
     * TODO: Definición de {@code ServicioPoliciaImpl}.
     *
     * @param repositorioEntidad
     */
    public ServicioPoliciaImpl(RepositorioPolicia repositorioEntidad) {
        this.repositorioEntidad = repositorioEntidad;
    }

    /**
     * TODO: Definición de {@code guardarActualizar}.
     *
     */
    @Override
    public PoliciaDTO guardarActualizar(PoliciaDTO entidadDTO) throws Exception {
        log.debug("Solicitud para guardar la entidad : {}", entidadDTO);

        //TODO: agregar validacion especifica del servicio.
        Policia entidad = mapeoEntidad.obtenerEntidad(entidadDTO);
        entidad = repositorioEntidad.save(entidad);

        PoliciaDTO entidadActual = mapeoEntidad.obtenerDto(entidad);
        return entidadActual;
    }

    /**
     * TODO: Definición de {@code obtenerEntidades}.
     *
     */
    @Override
    public List<PoliciaDTO> obtenerEntidades() throws Exception {
        log.debug("Solicitud para listar todas las Entidades");
        return mapeoEntidad.obtenerDto(repositorioEntidad.findAll());
    }

    /**
     * TODO: Definición de {@code buscarEntidad}.
     *
     */
    @Override
    public PoliciaDTO buscarEntidad(String id) throws Exception {
        log.debug("Solicitud para buscar la Entidad : {}", id);
        Policia entidadBuscada = repositorioEntidad.findById(Long.parseLong(id))
                .orElseThrow(() -> new ExcepcionEntidadNoEncontrado(id));
        return mapeoEntidad.obtenerDto(entidadBuscada);
    }

    /**
     * TODO: Definición de {@code obtenerEntidades}.
     *
     * @param strId
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public List<PoliciaDTO> obtenerEntidades(String strId) throws Exception {
        log.debug("Solicitud para listar todas las Entidades");
        return (List<PoliciaDTO>) mapeoEntidad.obtenerDto(repositorioEntidad.findByIntIdPolicia(Long.parseLong(strId)));
    }

    /**
     * TODO: Definición de {@code obtenerEntidades}.
     *
     * @param pageable
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public Page<PoliciaDTO> obtenerEntidades(Pageable pageable) throws Exception {
        log.debug("Solicitud para listar todas las Entidades");
        return repositorioEntidad.findAll(pageable).map(mapeoEntidad::obtenerDto);
    }

    /**
     * TODO: Definición de {@code eliminarEntidad}.
     *
     */
    @Override
    public void eliminarEntidad(String id) throws Exception {
        log.debug("Solicitud para eliminar la entidad : {}", id);
        repositorioEntidad.deleteById(Long.parseLong(id));
    }

    /**
     * TODO: Definición de {@code query}.
     *
     * @param query
     * @param pageable
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public Page<PoliciaDTO> query(String query, Pageable pageable) {
        log.debug("Solicitud de búsqueda de una pagina de la entidad para consulta {}", query);
        return repositorioEntidad.buscarEntidades(query, pageable).map(mapeoEntidad::obtenerDto);
    }
}
