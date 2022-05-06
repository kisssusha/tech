package com.kisssusha.controller;

import com.kisssusha.DAO.implemetations.CatsDao;
import com.kisssusha.DAO.implemetations.FriendshipDao;
import com.kisssusha.DAO.implemetations.OwnersDao;
import com.kisssusha.DAO.implemetations.ShelterDao;
import com.kisssusha.DAO.models.Cats;
import com.kisssusha.DAO.models.Friendship;
import com.kisssusha.DAO.models.Owners;
import com.kisssusha.DAO.models.Shelter;
import com.kisssusha.service.KotikiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CatController.class)
public class CatControllerTest {
    @MockBean
    CatsDao catDAO;

    @MockBean
    OwnersDao ownerDAO;

    @MockBean
    FriendshipDao friendshipDAO;

    @MockBean
    ShelterDao shelterDao;

    @MockBean
    Cats cat;

    @MockBean
    Owners owner;

    @MockBean
    Friendship friendship;

    @MockBean
    Shelter shelter;

    @MockBean
    KotikiService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void checkCatsColor() throws Exception {
        String url = "http://localhost:8080/cats/findAllOneColorCats/Pink";
        mockMvc.perform(get(url)).andExpect(status().is4xxClientError());
    }
}