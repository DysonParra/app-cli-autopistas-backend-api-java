/*
 * @fileoverview    {RepositorioGenerico}
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

/**
 * TODO: Description of {@code RepositorioGenerico}.
 *
 * @param <T>
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
public interface RepositorioGenerico<T> {

    /**
     * TODO: Description of method {@code guardarDatos}.
     *
     * @param t
     * @return 
     */
    public T guardarDatos(T t);

    /**
     * TODO: Description of method {@code eliminarDatos}.
     *
     * @param t
     */
    public void eliminarDatos(T t);

    /**
     * TODO: Description of method {@code obtenerDatos}.
     *
     * @param t
     * @return 
     */
    public T obtenerDatos(T t);

    /**
     * TODO: Description of method {@code actualizarCambios}.
     *
     * @param t
     * @return 
     */
    public T actualizarCambios(T t);

    /**
     * TODO: Description of method {@code obtenerTodos}.
     *
     * @return 
     */
    public Iterable<T> obtenerTodos();
}
