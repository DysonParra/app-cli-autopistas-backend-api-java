/*
 * @fileoverview    {RecursoBadge}
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

import com.project.dev.api.dto.BadgeDTO;
import com.project.dev.api.servicio.ServicioBadge;
import com.project.dev.api.web.rest.ensamblador.EnsambladorRecursoBadge;
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
 * TODO: Description of {@code RecursoBadge}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Badge API", description = "Gestión de Badge")
public class RecursoBadge {

    private final Logger log = LoggerFactory.getLogger(RecursoBadge.class);
    private final ServicioBadge servicioEntidad;
    private final EnsambladorRecursoBadge ensambladorRecursoEntidad;

    /**
     * TODO: Description of {@code RecursoBadge}.
     *
     * @param servicioEntidad
     * @param ensambladorRecursoEntidad
     */
    public RecursoBadge(ServicioBadge servicioEntidad,
            EnsambladorRecursoBadge ensambladorRecursoEntidad) {
        this.servicioEntidad = servicioEntidad;
        this.ensambladorRecursoEntidad = ensambladorRecursoEntidad;
    }

    /**
     * TODO: Description of {@code obtenerEntidades}.
     *
     * @param pageable
     */
    @ApiOperation(value = "Lista las [Entidades] existentes paginadas", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @GetMapping("/Badge/paginas")
    public ResponseEntity<List<BadgeDTO>> obtenerEntidades(Pageable pageable) {
        log.debug("REST request to get a page of Badge");
        Page<BadgeDTO> page = null;
        try {
            page = servicioEntidad.obtenerEntidades(pageable);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/Badge/paginas");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * TODO: Description of {@code obtenerEntidades}.
     *
     * @param expresion
     * @param pageable
     */
    @ApiOperation(value = "Lista las [Entidades] existentes paginadas", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @GetMapping("/Badge/{expresion}/paginas")
    public ResponseEntity<List<BadgeDTO>> obtenerEntidades(@PathVariable String expresion, Pageable pageable) {
        log.debug("REST request to get a page of Badge");
        Page<BadgeDTO> page = null;
        try {
            page = servicioEntidad.query(expresion, pageable);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/Badge/{expresion}/paginas/" + expresion);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * TODO: Description of {@code obtenerEntidades}.
     *
     */
    @ApiOperation(value = "Lista las [Entidades] existentes", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @GetMapping("/Badge")
    public CollectionModel<EntityModel<BadgeDTO>> obtenerEntidades() {

        List<EntityModel<BadgeDTO>> entidades = null;

        try {
            entidades = this.servicioEntidad.obtenerEntidades().parallelStream()
                    .map(ensambladorRecursoEntidad::toModel)
                    .collect(Collectors.toList());
            CollectionModel<EntityModel<BadgeDTO>> recursoRetorno = new CollectionModel<>(entidades);
            recursoRetorno.add(linkTo(methodOn(RecursoBadge.class).obtenerEntidades()).withSelfRel());
            return recursoRetorno;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    /**
     * TODO: Description of {@code obtenerEntidades}.
     *
     * @param id
     */
    @ApiOperation(value = "Lista la [Entidad] solicitada", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @GetMapping("/Badge/requisito/{id}")
    public CollectionModel<EntityModel<BadgeDTO>> obtenerEntidades(@PathVariable String id) {

        List<EntityModel<BadgeDTO>> entidades = null;

        try {
            entidades = this.servicioEntidad.obtenerEntidades(id).parallelStream()
                    .map(ensambladorRecursoEntidad::toModel)
                    .collect(Collectors.toList());
            CollectionModel<EntityModel<BadgeDTO>> recursoRetorno = new CollectionModel<>(entidades);
            recursoRetorno.add(linkTo(methodOn(RecursoBadge.class).obtenerEntidades()).withSelfRel());
            return recursoRetorno;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    /**
     * TODO: Description of {@code buscarEntidad}.
     *
     * @param id
     */
    @ApiOperation(value = "Lista la [Entidad] solicitada", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @GetMapping("/Badge/{id}")
    public ResponseEntity<EntityModel<BadgeDTO>> buscarEntidad(@PathVariable String id) {

        log.debug(String.format("servicio-badge buscarEntidad() invocado:{} por {} ",
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

    /**
     * TODO: Description of {@code guardarEntidad}.
     *
     * @param entidadDTO
     */
    @ApiOperation(value = "Guarda la [Entidad] solicitada", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @PostMapping("/Badge")
    public ResponseEntity<?> guardarEntidad(@RequestBody BadgeDTO entidadDTO) {

        EntityModel<BadgeDTO> resource = null;

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

    /**
     * TODO: Description of {@code actualizarEntidad}.
     *
     * @param entidadDTO
     * @param id
     */
    @ApiOperation(value = "Actualiza la [Entidad] solicitada", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @PutMapping("/Badge/{id}")
    public ResponseEntity<?> actualizarEntidad(@RequestBody BadgeDTO entidadDTO, @PathVariable String id) {
        return guardarEntidad(entidadDTO);
    }

    /**
     * TODO: Description of {@code eliminarEntidad}.
     *
     * @param id
     */
    @ApiOperation(value = "Elimina la [Entidad] solicitada", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista recuperada exitosamente"),
        @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso."),
        @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intenta alcanzar"),
        @ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar")
    })
    @DeleteMapping("/Badge/{id}")
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
