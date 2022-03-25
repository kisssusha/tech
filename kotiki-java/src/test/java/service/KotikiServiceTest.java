package service;

import DAO.enums.MyColors;
import DAO.interfaces.Dao;
import DAO.models.CatsEntity;
import DAO.models.CatsForOwnerEntity;
import DAO.models.FriendsForCatEntity;
import DAO.models.OwnersEntity;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.tools.KotikiException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

class KotikiServiceTest {
    @Mock
    private  Dao<CatsEntity> catsDao;
    @Mock
    private  Dao<OwnersEntity> ownerDao;
    @Mock
    private  Dao<FriendsForCatEntity> friendshipDao;
    @Mock
    private  Dao<CatsForOwnerEntity> shelterDao;
    private KotikiService kotikiService;

    public KotikiServiceTest() {
        MockitoAnnotations.initMocks(this);
        this.kotikiService = new KotikiService(catsDao, ownerDao, friendshipDao, shelterDao);
    }


    @Test
    void deleteCat() throws KotikiException {
        CatsEntity cat = new CatsEntity();
        FriendsForCatEntity friends = new FriendsForCatEntity();
        List<FriendsForCatEntity> listFriends = new ArrayList<>();
        try {
            given(friendshipDao.findAllEntity()).willReturn(listFriends);
        } catch (DAO.tools.DaoException e) {
            e.printStackTrace();
        }
        try {
            given(friendshipDao.deleteEntity(friends)).willReturn(true);
        } catch (DAO.tools.DaoException e) {
            e.printStackTrace();
        }
        try {
            given(catsDao.deleteEntity(cat)).willReturn(true);
        } catch (DAO.tools.DaoException e) {
            e.printStackTrace();
        }
        try {
            given(catsDao.getById(1)).willReturn(cat);
        } catch (DAO.tools.DaoException e) {
            e.printStackTrace();
        }
        boolean exist = kotikiService.deleteCat(1);
        assertTrue(exist);
    }

    @Test
    void addCat() throws KotikiException {
        CatsEntity cat = new CatsEntity();
        cat.setBirth(Timestamp.valueOf("2002-07-13 00:00:00"));
        cat.setName("nice");
        cat.setColor(MyColors.Black);
        try {
            given(catsDao.addEntity(cat)).willReturn(true);
        } catch (DAO.tools.DaoException e) {
            e.printStackTrace();
        }
        boolean exist = kotikiService.addCat("nice", Timestamp.valueOf("2002-07-13 00:00:00"), MyColors.Black);
        assertTrue(exist);
    }

    @Test
    void friendship() throws KotikiException {
        CatsEntity cat = new CatsEntity();
        CatsEntity cat1 = new CatsEntity();
        cat.setName("hfhf");
        cat1.setName("hkh");
        FriendsForCatEntity friends = new FriendsForCatEntity();
        friends.setIdCat(1);
        friends.setIdFriend(2);
        try {
            given(friendshipDao.addEntity(friends)).willReturn(true);
        } catch (DAO.tools.DaoException e) {
            e.printStackTrace();
        }
        boolean exist = kotikiService.friendship(1,2);
        assertTrue(exist);
    }

    @Test
    void shelterCat() throws KotikiException {
            CatsEntity cat = new CatsEntity();
            OwnersEntity own = new OwnersEntity();
            CatsForOwnerEntity pets = new CatsForOwnerEntity();
            pets.setIdCat(1);
            pets.setIdOwner(2);
        try {
            given(shelterDao.addEntity(pets)).willReturn(true);
        } catch (DAO.tools.DaoException e) {
            e.printStackTrace();
        }
        boolean exist = kotikiService.shelterCat(2,1);
            assertTrue(exist);
    }

    @Test
    void deleteFriendship() throws KotikiException {

        FriendsForCatEntity friends = new FriendsForCatEntity();
        friends.setIdFriend(1);
        friends.setIdCat(2);
        List<FriendsForCatEntity> listFriends = new ArrayList<>();
        listFriends.add(friends);
        try {
            given(friendshipDao.findAllEntity()).willReturn(listFriends);
        } catch (DAO.tools.DaoException e) {
            e.printStackTrace();
        }
        try {
            given(friendshipDao.deleteEntity(friends)).willReturn(true);
        } catch (DAO.tools.DaoException e) {
            e.printStackTrace();
        }
        boolean exist = kotikiService.deleteFriendship(1,2);
        assertTrue(exist);
    }
}