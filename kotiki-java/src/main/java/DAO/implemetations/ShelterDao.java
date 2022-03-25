package DAO.implemetations;

import DAO.interfaces.Dao;
import DAO.models.CatsForOwnerEntity;
import DAO.tools.DaoException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import DAO.tools.HibernateUtil;

import java.util.List;

public class ShelterDao implements Dao<CatsForOwnerEntity> {
    @Override
    public List<CatsForOwnerEntity> findAllEntity() throws DaoException {
        try {
            List<CatsForOwnerEntity> entity;
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            entity = session.createQuery("select e from CatsForOwnerEntity e",
                            CatsForOwnerEntity.class)
                    .getResultList();
            session.getTransaction().commit();
            session.close();
            return entity;
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean changeEntity(CatsForOwnerEntity entity) throws DaoException {
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
    public boolean addEntity(CatsForOwnerEntity entity) throws DaoException {
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
    public boolean deleteEntity(CatsForOwnerEntity pets) throws DaoException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.delete(pets);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public CatsForOwnerEntity getById(long id) throws DaoException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            CatsForOwnerEntity entity = session.byId(CatsForOwnerEntity.class).load(id);
            session.getTransaction().commit();
            session.close();
            return entity;
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
}