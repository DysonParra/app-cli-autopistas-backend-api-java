/*
 * @fileoverview    {RecursoPolicia}
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
package com.project.dev.api.web.rest;

import com.project.dev.api.dto.PoliciaDTO;
import com.project.dev.api.servicio.ServicioPolicia;
import com.project.dev.api.web.rest.ensamblador.EnsambladorRecursoPolicia;
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
 * TODO: Description of {@code RecursoPolicia}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Policia API", description = "Gestión de Policia")
public class RecursoPolicia {

    private final Logger log = LoggerFactory.getLogger(RecursoPolicia.class);
    private final ServicioPolicia servicioEntidad;
    private final EnsambladorRecursoPolicia ensambladorRecursoEntidad;

    public RecursoPolicia(ServicioPolicia servicioEntidad,
            EnsambladorRecursoPolicia ensambladorRecursoEntidad) {
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
    @GetMapping("/Policia/paginas")
    public ResponseEntity<List<PoliciaDTO>> obtenerEntidades(Pageable pageable) {
        log.debug("REST request to get a page of Policia");
        Page<PoliciaDTO> page = null;
        try {
            page = servicioEntidad.obtenerEntidades(pageable);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/Policia/paginas");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @ApiOperation(value = "Lista las [Entidades] existentes paginadas", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @GetMapping("/Policia/{expresion}/paginas")
    public ResponseEntity<List<PoliciaDTO>> obtenerEntidades(@PathVariable String expresion, Pageable pageable) {
        log.debug("REST request to get a page of Policia");
        Page<PoliciaDTO> page = null;
        try {
            page = servicioEntidad.query(expresion, pageable);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/Policia/{expresion}/paginas/" + expresion);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @ApiOperation(value = "Lista las [Entidades] existentes", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @GetMapping("/Policia")
    public CollectionModel<EntityModel<PoliciaDTO>> obtenerEntidades() {

        List<EntityModel<PoliciaDTO>> entidades = null;

        try {
            entidades = this.servicioEntidad.obtenerEntidades().parallelStream()
                    .map(ensambladorRecursoEntidad::toModel)
                    .collect(Collectors.toList());
            CollectionModel<EntityModel<PoliciaDTO>> recursoRetorno = new CollectionModel<>(entidades);
            recursoRetorno.add(linkTo(methodOn(RecursoPolicia.class).obtenerEntidades()).withSelfRel());
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
    @GetMapping("/Policia/requisito/{id}")
    public CollectionModel<EntityModel<PoliciaDTO>> obtenerEntidades(@PathVariable String id) {

        List<EntityModel<PoliciaDTO>> entidades = null;

        try {
            entidades = this.servicioEntidad.obtenerEntidades(id).parallelStream()
                    .map(ensambladorRecursoEntidad::toModel)
                    .collect(Collectors.toList());
            CollectionModel<EntityModel<PoliciaDTO>> recursoRetorno = new CollectionModel<>(entidades);
            recursoRetorno.add(linkTo(methodOn(RecursoPolicia.class).obtenerEntidades()).withSelfRel());
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
    @GetMapping("/Policia/{id}")
    public ResponseEntity<EntityModel<PoliciaDTO>> buscarEntidad(@PathVariable String id) {

        log.debug(String.format("servicio-policia buscarEntidad() invocado:{} por {} ",
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
    @PostMapping("/Policia")
    public ResponseEntity<?> guardarEntidad(@RequestBody PoliciaDTO entidadDTO) {

        EntityModel<PoliciaDTO> resource = null;

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
    @PutMapping("/Policia/{id}")
    public ResponseEntity<?> actualizarEntidad(@RequestBody PoliciaDTO entidadDTO, @PathVariable Long id) {
        return guardarEntidad(entidadDTO);
    }

    @ApiOperation(value = "Elimina la [Entidad] solicitada", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @DeleteMapping("/Policia/{id}")
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
