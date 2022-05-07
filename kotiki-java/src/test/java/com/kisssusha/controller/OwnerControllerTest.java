package com.kisssusha.controller;


import com.kisssusha.DAO.dto.OwnersDto;
import com.kisssusha.DAO.implemetations.OwnersDao;
import com.kisssusha.DAO.models.Owners;
import com.kisssusha.service.KotikiService;
import com.kisssusha.service.SecurityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OwnerController.class)
public class OwnerControllerTest {

    @MockBean
    KotikiService service;

    @MockBean
    OwnersDao ownerDao;

    @MockBean
    SecurityService securityService;

    @Autowired
    private MockMvc mockMvc;
    private Owners owner;
    private  OwnersDto ownerDto;

    @BeforeEach
    public void setUp(){
        owner = new Owners();
        owner.setLogin("Ksusha");
        owner.setPassword("$2a$12$NlJDln/GpsyGKxR5nG2W1eMyFxLRZsNuQHMKUdQtnTbGa46ImV90q");
        owner.setRole("ROLE_USER");
        ownerDto = new OwnersDto(owner);
        Mockito.when(securityService.loadUserByUsername("Ksusha")).
                thenReturn(securityService.mapUserBDtoUserDetails(ownerDto));
        Mockito.when(service.findOwnerByLogin("Ksusha")).thenReturn(ownerDto);
        Mockito.when(ownerDao.findByLogin("Ksusha")).thenReturn(owner);
    }

    @Test
    public void dontAllowPageUser() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/admin")
                        .with(SecurityMockMvcRequestPostProcessors.
                                user("Ksusha")
                                .password("$2a$12$NlJDln/GpsyGKxR5nG2W1eMyFxLRZsNuQHMKUdQtnTbGa46ImV90q")
                                .roles("USER")))
                .andExpect(status().isForbidden());
    }

}