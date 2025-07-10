/*
 * @overview        {RepositorioRegistroVehiculo}
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
package com.project.dev.api.repositorio;

import com.project.dev.api.dominio.RegistroVehiculo;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * TODO: Description of {@code RepositorioRegistroVehiculo}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
@Repository
public interface RepositorioRegistroVehiculo extends JpaRepository<RegistroVehiculo, Long> {

    /**
     * TODO: Description of method {@code findByIntTiqueteNro}.
     *
     * @param id
     * @return 
     */
    public List<RegistroVehiculo> findByIntTiqueteNro(Long id);

    /**
     * TODO: Description of method {@code buscarRegistroVehiculo}.
     *
     * @param strBusqueda
     * @return 
     */
    @Query("SELECT m FROM RegistroVehiculo m WHERE m.strPlacaVehiculo LIKE CONCAT('%', :strBusqueda, '%') ORDER BY m.dtFechaHoraEstatica desc")
    public List<RegistroVehiculo> buscarRegistroVehiculo(@Param("strBusqueda") String strBusqueda);

    /**
     * TODO: Description of method {@code buscarEntidades}.
     *
     * @param strBusqueda
     * @param pageable
     */
    @Query("SELECT m FROM RegistroVehiculo m WHERE m.strPlacaVehiculo LIKE CONCAT('%', :strBusqueda, '%')")
    public Page<RegistroVehiculo> buscarEntidades(@Param("strBusqueda") String strBusqueda, Pageable pageable);
}
