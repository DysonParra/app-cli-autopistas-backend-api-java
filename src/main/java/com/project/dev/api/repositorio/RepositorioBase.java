/*
 * @fileoverview    {RepositorioBase}
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

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * TODO: Description of {@code RepositorioBase}.
 *
 * @param <T>
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
public class RepositorioBase<T> implements RepositorioGenerico<T> {

    protected EntityManager entityManager;
    private Class<T> type;

    /**
     * TODO: Description of method {@code getEntityManager}.
     *
     * @return
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * TODO: Description of method {@code setEntityManager}.
     *
     * @param entityManager
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * TODO: Description of method {@code RepositorioBase}.
     *
     */
    public RepositorioBase() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    /**
     * TODO: Description of method {@code guardarDatos}.
     *
     * @param t
     * @return
     */
    @Override
    public T guardarDatos(final T t) {
        entityManager.persist(t);
        return t;
    }

    /**
     * TODO: Description of method {@code eliminarDatos}.
     *
     * @param objeto
     */
    @Override
    public void eliminarDatos(final Object objeto) {
        entityManager.remove(entityManager.merge(objeto));
    }

    /**
     * TODO: Description of method {@code obtenerDatos}.
     *
     * @param id
     * @return
     */
    @Override
    public T obtenerDatos(final Object id) {
        return (T) entityManager.find(type, id);
    }

    /**
     * TODO: Description of method {@code actualizarCambios}.
     *
     * @param t
     * @return
     */
    @Override
    public T actualizarCambios(final T t) {
        return entityManager.merge(t);
    }

    /**
     * TODO: Description of method {@code obtenerTodos}.
     *
     * @return
     */
    @Override
    public Iterable<T> obtenerTodos() {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
        Root<T> root = criteriaQuery.from(type);
        criteriaQuery.select(root);
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
