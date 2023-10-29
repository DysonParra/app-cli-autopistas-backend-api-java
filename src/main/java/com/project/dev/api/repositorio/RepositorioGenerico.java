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
 * @since 11
 */
public interface RepositorioGenerico<T> {

    public T guardarDatos(T t);

    public void eliminarDatos(T t);

    public T obtenerDatos(T t);

    public T actualizarCambios(T t);

    public Iterable<T> obtenerTodos();
}
