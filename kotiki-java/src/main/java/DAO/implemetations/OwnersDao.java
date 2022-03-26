package DAO.implemetations;

import DAO.models.OwnersEntity;
import DAO.tools.DaoException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import DAO.interfaces.Dao;
import DAO.tools.HibernateUtil;

import java.util.List;

public class OwnersDao implements Dao<OwnersEntity> {
    @Override
    public List<OwnersEntity> findAllEntity() throws DaoException {
        try {
            List<OwnersEntity> entity;
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            entity = session.createQuery("select e from OwnersEntity e", OwnersEntity.class)
                    .getResultList();
            session.getTransaction().commit();
            session.close();
            return entity;
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean changeEntity(OwnersEntity entity) throws DaoException {
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
    public boolean addEntity(OwnersEntity entity) throws DaoException {
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
    public boolean deleteEntity(OwnersEntity entity) throws DaoException {
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
    public OwnersEntity getById(long id) throws DaoException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            OwnersEntity entity = session.byId(OwnersEntity.class).load(id);
            session.getTransaction().commit();
            session.close();
            return entity;
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
}
