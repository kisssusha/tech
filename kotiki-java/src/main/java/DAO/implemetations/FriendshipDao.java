package DAO.implemetations;

import DAO.interfaces.Dao;
import DAO.models.FriendsForCatEntity;
import DAO.tools.DaoException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import DAO.tools.HibernateUtil;

import java.util.List;

public class FriendshipDao implements Dao<FriendsForCatEntity> {
    @Override
    public List<FriendsForCatEntity> findAllEntity() throws DaoException {
        try {
            List<FriendsForCatEntity> entity;
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            entity = session.createQuery("select e from FriendsForCatEntity e",
                            FriendsForCatEntity.class)
                    .getResultList();
            session.getTransaction().commit();
            session.close();
            return entity;
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean changeEntity(FriendsForCatEntity entity) throws DaoException {
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
    public boolean addEntity(FriendsForCatEntity entity) throws DaoException {
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
    public boolean deleteEntity(FriendsForCatEntity entity) throws DaoException {
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
    public FriendsForCatEntity getById(long id) throws DaoException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            FriendsForCatEntity entity = session.byId(FriendsForCatEntity.class).load(id);
            session.getTransaction().commit();
            session.close();
            return entity;
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
}
