/*
 * @fileoverview    {RecursoConfiguracion} se encarga de realizar tareas específicas.
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
package com.project.dev.api.web.rest;

import com.project.dev.api.dto.ConfiguracionDTO;
import com.project.dev.api.servicio.ServicioConfiguracion;
import com.project.dev.api.web.rest.ensamblador.EnsambladorRecursoConfiguracion;
import com.project.dev.api.web.rest.util.PaginationUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * TODO: Definición de {@code RecursoConfiguracion}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Configuracion API", description = "Gestión de Configuracion")
public class RecursoConfiguracion {

    private final Logger log = LoggerFactory.getLogger(RecursoConfiguracion.class);
    private final ServicioConfiguracion servicioEntidad;
    private final EnsambladorRecursoConfiguracion ensambladorRecursoEntidad;

    public RecursoConfiguracion(ServicioConfiguracion servicioEntidad,
            EnsambladorRecursoConfiguracion ensambladorRecursoEntidad) {
        this.servicioEntidad = servicioEntidad;
        this.ensambladorRecursoEntidad = ensambladorRecursoEntidad;
    }

    @ApiOperation(value = "Lista las [Entidades] existentes paginadas", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @GetMapping("/Configuracion/paginas")
    public ResponseEntity<List<ConfiguracionDTO>> obtenerEntidades(Pageable pageable) {
        log.debug("REST request to get a page of Configuracion");
        Page<ConfiguracionDTO> page = null;
        try {
            page = servicioEntidad.obtenerEntidades(pageable);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/Configuracion/paginas");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @ApiOperation(value = "Lista las [Entidades] existentes paginadas", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @GetMapping("/Configuracion/{expresion}/paginas")
    public ResponseEntity<List<ConfiguracionDTO>> obtenerEntidades(@PathVariable String expresion, Pageable pageable) {
        log.debug("REST request to get a page of Configuracion");
        Page<ConfiguracionDTO> page = null;
        try {
            page = servicioEntidad.query(expresion, pageable);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/Configuracion/{expresion}/paginas/" + expresion);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @ApiOperation(value = "Lista las [Entidades] existentes", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @GetMapping("/Configuracion")
    public CollectionModel<EntityModel<ConfiguracionDTO>> obtenerEntidades() {

        List<EntityModel<ConfiguracionDTO>> entidades = null;

        try {
            entidades = this.servicioEntidad.obtenerEntidades().parallelStream()
                    .map(ensambladorRecursoEntidad::toModel)
                    .collect(Collectors.toList());
            CollectionModel<EntityModel<ConfiguracionDTO>> recursoRetorno = new CollectionModel<>(entidades);
            recursoRetorno.add(linkTo(methodOn(RecursoConfiguracion.class).obtenerEntidades()).withSelfRel());
            return recursoRetorno;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @ApiOperation(value = "Lista la [Entidad] solicitada", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @GetMapping("/Configuracion/requisito/{id}")
    public CollectionModel<EntityModel<ConfiguracionDTO>> obtenerEntidades(@PathVariable String id) {

        List<EntityModel<ConfiguracionDTO>> entidades = null;

        try {
            entidades = this.servicioEntidad.obtenerEntidades(id).parallelStream()
                    .map(ensambladorRecursoEntidad::toModel)
                    .collect(Collectors.toList());
            CollectionModel<EntityModel<ConfiguracionDTO>> recursoRetorno = new CollectionModel<>(entidades);
            recursoRetorno.add(linkTo(methodOn(RecursoConfiguracion.class).obtenerEntidades()).withSelfRel());
            return recursoRetorno;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @ApiOperation(value = "Lista la [Entidad] solicitada", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @GetMapping("/Configuracion/{id}")
    public ResponseEntity<EntityModel<ConfiguracionDTO>> buscarEntidad(@PathVariable String id) {

        log.debug(String.format("servicio-configuracion buscarEntidad() invocado:{} por {} ",
                servicioEntidad.getClass().getName(), id));

        try {
            return Optional.of(this.servicioEntidad.buscarEntidad(id))
                    .map(u -> new ResponseEntity<>(ensambladorRecursoEntidad.toModel(u), HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            log.error("Ocurrio un error en la llamada REST buscarEntidad", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Guarda la [Entidad] solicitada", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @PostMapping("/Configuracion")
    public ResponseEntity<?> guardarEntidad(@RequestBody ConfiguracionDTO entidadDTO) {

        EntityModel<ConfiguracionDTO> resource = null;

        try {
            resource = ensambladorRecursoEntidad.toModel(servicioEntidad.guardarActualizar(entidadDTO));

            return ResponseEntity
                    .created(new URI(resource.getLink("self").orElse(new Link("self")).getHref()))
                    .body(resource);
        } catch (Exception e) {
            log.warn("Ocurrio un error en la llamada REST guardarEntidad", e);
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @ApiOperation(value = "Actualiza la [Entidad] solicitada", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @PutMapping("/Configuracion/{id}")
    public ResponseEntity<?> actualizarEntidad(@RequestBody ConfiguracionDTO entidadDTO, @PathVariable Long id) {
        return guardarEntidad(entidadDTO);
    }

    @ApiOperation(value = "Elimina la [Entidad] solicitada", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @DeleteMapping("/Configuracion/{id}")
    public ResponseEntity<?> eliminarEntidad(@PathVariable String id) {
        log.debug("Solicitud REST para Eliminar la entidad : {}", id);
        try {
            servicioEntidad.eliminarEntidad(id);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return ResponseEntity.noContent().build();
    }
}
