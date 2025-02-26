/*
 * @fileoverview    {ServicioPesajeImpl}
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

import com.project.dev.api.dominio.Pesaje;
import com.project.dev.api.dto.PesajeDTO;
import com.project.dev.api.repositorio.RepositorioPesaje;
import com.project.dev.api.servicio.ServicioPesaje;
import com.project.dev.api.servicio.excepcion.ExcepcionEntidadNoEncontrado;
import com.project.dev.api.servicio.mapeo.MapeoPesaje;
import java.util.List;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: Description of {@code ServicioPesajeImpl}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@Service
@Transactional
public class ServicioPesajeImpl implements ServicioPesaje {

    private final Logger log = LoggerFactory.getLogger(ServicioPesajeImpl.class);

    private final RepositorioPesaje repositorioEntidad;

    private final MapeoPesaje mapeoEntidad = Mappers.getMapper(MapeoPesaje.class);

    /**
     * TODO: Description of method {@code ServicioPesajeImpl}.
     *
     * @param repositorioEntidad
     */
    public ServicioPesajeImpl(RepositorioPesaje repositorioEntidad) {
        this.repositorioEntidad = repositorioEntidad;
    }

    /**
     * TODO: Description of method {@code guardarActualizar}.
     *
     */
    @Override
    public PesajeDTO guardarActualizar(PesajeDTO entidadDTO) throws Exception {
        log.debug("Solicitud para guardar la entidad tipo Pesaje: {}", entidadDTO);

        //TODO: agregar validacion especifica del servicio.
        Pesaje entidad = mapeoEntidad.obtenerEntidad(entidadDTO);
        entidad = repositorioEntidad.save(entidad);

        PesajeDTO entidadActual = mapeoEntidad.obtenerDto(entidad);
        return entidadActual;
    }

    /**
     * TODO: Description of method {@code obtenerEntidades}.
     *
     */
    @Override
    public List<PesajeDTO> obtenerEntidades() throws Exception {
        log.debug("Solicitud para listar todas las Entidades tipo Pesaje");
        return mapeoEntidad.obtenerDto(repositorioEntidad.findAll());
    }

    /**
     * TODO: Description of method {@code buscarEntidad}.
     *
     */
    @Override
    public PesajeDTO buscarEntidad(String id) throws Exception {
        log.debug("Solicitud para buscar la Entidad tipo Pesaje: {}", id);
        Pesaje entidadBuscada = repositorioEntidad.findById(Long.parseLong(id))
                .orElseThrow(() -> new ExcepcionEntidadNoEncontrado(id));
        return mapeoEntidad.obtenerDto(entidadBuscada);
    }

    /**
     * TODO: Description of method {@code obtenerEntidades}.
     *
     * @param strId
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public List<PesajeDTO> obtenerEntidades(String strId) throws Exception {
        log.debug("Solicitud para listar todas las Entidades tipo Pesaje: {}", strId);
        return (List<PesajeDTO>) mapeoEntidad.obtenerDto(repositorioEntidad.findByIntId(Long.parseLong(strId)));
    }

    /**
     * TODO: Description of method {@code obtenerEntidades}.
     *
     * @param pageable
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public Page<PesajeDTO> obtenerEntidades(Pageable pageable) throws Exception {
        log.debug("Solicitud para listar todas las Entidades tipo Pesaje con paginacion");
        return repositorioEntidad.findAll(pageable).map(mapeoEntidad::obtenerDto);
    }

    /**
     * TODO: Description of method {@code eliminarEntidad}.
     *
     */
    @Override
    public void eliminarEntidad(String id) throws Exception {
        log.debug("Solicitud para eliminar la entidad tipo Pesaje: {}", id);
        repositorioEntidad.deleteById(Long.parseLong(id));
    }

    /**
     * TODO: Description of method {@code query}.
     *
     * @param query
     * @param pageable
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public Page<PesajeDTO> query(String query, Pageable pageable) {
        log.debug("Solicitud para buscar una pagina de la entidad tipo Pesaje para consulta {}", query);
        return repositorioEntidad.buscarEntidades(query, pageable).map(mapeoEntidad::obtenerDto);
    }
}
