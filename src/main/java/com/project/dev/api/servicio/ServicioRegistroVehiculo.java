/*
 * @fileoverview    {ServicioRegistroVehiculo}
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
package com.project.dev.api.servicio;

import com.project.dev.api.dto.RegistroVehiculoDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO: Description of {@code ServicioRegistroVehiculo}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
public interface ServicioRegistroVehiculo extends ServicioGenerico<RegistroVehiculoDTO> {

    public List<RegistroVehiculoDTO> obtenerEntidades(String id) throws Exception;

    public List<RegistroVehiculoDTO> ObtenerImpresion(String id) throws Exception;

    public Page<RegistroVehiculoDTO> obtenerEntidades(Pageable pageable) throws Exception;

    public Page<RegistroVehiculoDTO> query(String query, Pageable pageable);
}
