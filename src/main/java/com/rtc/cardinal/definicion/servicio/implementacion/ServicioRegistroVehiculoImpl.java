/*
 * @fileoverview {FileName} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {FileName} fue realizada el 31/07/2022.
 * @Dev - La primera version de {FileName} fue escrita por Dyson A. Parra T.
 */
package com.rtc.cardinal.definicion.servicio.implementacion;

import com.rtc.cardinal.definicion.dominio.RegistroVehiculo;
import com.rtc.cardinal.definicion.repositorio.RepositorioRegistroVehiculo;
import com.rtc.cardinal.definicion.servicio.ServicioRegistroVehiculo;
import com.rtc.cardinal.definicion.servicio.dto.RegistroVehiculoDTO;
import com.rtc.cardinal.definicion.servicio.implementacion.excepciones.ExcepcionEntidadNoEncontrado;
import com.rtc.cardinal.definicion.servicio.mapeo.MapeoRegistroVehiculo;
import java.util.List;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: Definición de {@code ServicioRegistroVehiculoImpl}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@Service
@Transactional
public class ServicioRegistroVehiculoImpl implements ServicioRegistroVehiculo {

    private final Logger log = LoggerFactory.getLogger(ServicioRegistroVehiculoImpl.class);

    private final RepositorioRegistroVehiculo repositorioEntidad;

    private final MapeoRegistroVehiculo mapeoEntidad = Mappers.getMapper(MapeoRegistroVehiculo.class);

    /**
     * TODO: Definición de {@code ServicioRegistroVehiculoImpl}.
     *
     * @param repositorioEntidad
     */
    public ServicioRegistroVehiculoImpl(RepositorioRegistroVehiculo repositorioEntidad) {
        this.repositorioEntidad = repositorioEntidad;
    }

    /**
     * TODO: Definición de {@code guardarActualizar}.
     *
     */
    @Override
    public RegistroVehiculoDTO guardarActualizar(RegistroVehiculoDTO entidadDTO) throws Exception {
        log.debug("Solicitud para guardar la entidad : {}", entidadDTO);

        //TODO: agregar validacion especifica del servicio.
        RegistroVehiculo entidad = mapeoEntidad.obtenerEntidad(entidadDTO);
        entidad = repositorioEntidad.save(entidad);

        RegistroVehiculoDTO entidadActual = mapeoEntidad.obtenerDto(entidad);
        return entidadActual;
    }

    /**
     * TODO: Definición de {@code obtenerEntidades}.
     *
     */
    @Override
    public List<RegistroVehiculoDTO> obtenerEntidades() throws Exception {
        log.debug("Solicitud para listar todas las Entidades");
        return mapeoEntidad.obtenerDto(repositorioEntidad.findAll(Sort.by(Sort.Direction.DESC, "dtFechaHoraEstatica")));
    }

    /**
     * TODO: Definición de {@code buscarEntidad}.
     *
     */
    @Override
    public RegistroVehiculoDTO buscarEntidad(String id) throws Exception {
        log.debug("Solicitud para buscar la Entidad : {}", id);
        RegistroVehiculo entidadBuscada = repositorioEntidad.findById(Long.parseLong(id))
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
    public List<RegistroVehiculoDTO> obtenerEntidades(String strId) throws Exception {
        log.debug("Solicitud para listar todas las Entidades");
        return (List<RegistroVehiculoDTO>) mapeoEntidad.obtenerDto(repositorioEntidad.findByIntTiqueteNro(Long.parseLong(strId)));
    }

    /**
     * TODO: Definición de {@code ObtenerImpresion}.
     *
     * @param strId
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public List<RegistroVehiculoDTO> ObtenerImpresion(String strId) throws Exception {
        log.debug("Solicitud para listar todas las Entidades");
        return (List<RegistroVehiculoDTO>) mapeoEntidad.obtenerDto(repositorioEntidad.buscarRegistroVehiculo(strId));
    }

    /**
     * TODO: Definición de {@code obtenerEntidades}.
     *
     * @param pageable
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public Page<RegistroVehiculoDTO> obtenerEntidades(Pageable pageable) throws Exception {
        log.debug("Solicitud para listar todas las Entidades");
        Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("dtFechaHoraEstatica").descending());
        return repositorioEntidad.findAll(page).map(mapeoEntidad::obtenerDto);
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
    public Page<RegistroVehiculoDTO> query(String query, Pageable pageable) {
        log.debug("Solicitud de búsqueda de una pagina de la entidad para consulta {}", query);
        return repositorioEntidad.buscarEntidades(query, pageable).map(mapeoEntidad::obtenerDto);
    }
}
