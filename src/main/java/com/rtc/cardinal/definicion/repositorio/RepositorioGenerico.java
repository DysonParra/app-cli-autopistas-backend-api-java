/*
 * @fileoverview    {RepositorioGenerico} se encarga de realizar tareas específicas.
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
package com.rtc.cardinal.definicion.repositorio;

/**
 * TODO: Definición de {@code RepositorioGenerico}.
 *
 * @author Dyson Parra
 * @param <T>
 * @since 1.8
 */
public interface RepositorioGenerico<T> {

    public T guardarDatos(T t);

    public void eliminarDatos(T t);

    public T obtenerDatos(T t);

    public T actualizarCambios(T t);

    public Iterable<T> obtenerTodos();
}
