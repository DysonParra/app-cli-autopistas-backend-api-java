/*
 * @fileoverview    {ServicioImplementacionBase}
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

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO: Description of {@code ServicioImplementacionBase}.
 *
 * @param <T>
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
public class ServicioImplementacionBase<T> implements ServicioGenerico<T> {

    private Class<T> type;

    private final Logger log = LoggerFactory.getLogger(type);

    /**
     * TODO: Description of method {@code ServicioImplementacionBase}.
     *
     */
    public ServicioImplementacionBase() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    /**
     * TODO: Description of method {@code guardarActualizar}.
     *
     * @param entidadDTO
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public T guardarActualizar(T entidadDTO) throws Exception {
        return null;
    }

    /**
     * TODO: Description of method {@code obtenerEntidades}.
     *
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public List<T> obtenerEntidades() throws Exception {
        return null;
    }

    /**
     * TODO: Description of method {@code buscarEntidad}.
     *
     * @param id
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public T buscarEntidad(String id) throws Exception {
        return null;
    }

    /**
     * TODO: Description of method {@code eliminarEntidad}.
     *
     * @param id
     * @throws java.lang.Exception
     */
    @Override
    public void eliminarEntidad(String id) throws Exception {

    }
}
