package DAO.implemetations;

import DAO.interfaces.Dao;
import DAO.models.CatsEntity;
import DAO.tools.DaoException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import DAO.tools.HibernateUtil;

import java.util.List;

public class CatsDao implements Dao<CatsEntity> {
    @Override
    public List<CatsEntity> findAllEntity() throws DaoException {
        try {
            List<CatsEntity> entity;
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            entity = session.createQuery("select e from CatsEntity e", CatsEntity.class)
                    .getResultList();
            session.getTransaction().commit();
            session.close();
            return entity;
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean changeEntity(CatsEntity entity) throws DaoException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(entity);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean addEntity(CatsEntity entity) throws DaoException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.save(entity);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteEntity(CatsEntity entity) throws DaoException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.delete(entity);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public CatsEntity getById(long id) throws DaoException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            CatsEntity entity = session.byId(CatsEntity.class).load(id);
            session.getTransaction().commit();
            session.close();
            return entity;
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
}
