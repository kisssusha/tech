package DAO.interfaces;

import DAO.tools.DaoException;

import java.util.List;

public interface Dao<T> {
    List<T> findAllEntity() throws DaoException;

    boolean changeEntity(T entity) throws DaoException;

    boolean addEntity(T entity) throws DaoException;

    boolean deleteEntity(T entity) throws DaoException;

    T getById(long entity) throws DaoException;
}
