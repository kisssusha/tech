package com.kisssusha;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.kisssusha.DAO.dto.CatsDto;
import com.kisssusha.DAO.implemetations.CatsDao;
import com.kisssusha.DAO.implemetations.FriendshipDao;
import com.kisssusha.DAO.implemetations.ShelterDao;
import com.kisssusha.DAO.models.Cats;
import com.kisssusha.service.KotikiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class KotikiServiceTest {
    @InjectMocks
    private KotikiService kotikiService;

    @Mock
    private CatsDao catDAO;

    @Mock
    private FriendshipDao friendshipDao;

    @Mock
    private ShelterDao shelterDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCats() {
        List<Cats> cats = new ArrayList<>();
        Cats cat1 = new Cats();
        cat1.setName("Cat1");
        cats.add(cat1);

        when(catDAO.findAll()).thenReturn(cats);

        List<CatsDto> result = kotikiService.getCats();

        assertEquals(1, result.size());
        assertEquals("Cat1", result.get(0).getName());
        verify(catDAO, times(1)).findAll();
    }

    @Test
    public void testAddCat() {
        Cats cat1 = new Cats();
        cat1.setName("Cat1");
        CatsDto catsDto = new CatsDto(cat1);

        boolean result = kotikiService.addCat(catsDto);

        assertTrue(result);
        verify(catDAO, times(1)).save(any(Cats.class));
    }

    @Test
    public void testDeleteCat() {
        Long catId = 1L;

        boolean result = kotikiService.deleteCat(catId);

        assertTrue(result);
        verify(shelterDao, times(1)).deleteAllByIdCat(catId);
        verify(friendshipDao, times(1)).deleteAllByIdCatOrIdFriend(catId, catId);
        verify(catDAO, times(1)).deleteById(catId);
    }
}
