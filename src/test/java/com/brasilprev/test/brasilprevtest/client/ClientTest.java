package com.brasilprev.test.brasilprevtest.client;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import com.brasilprev.test.brasilprevtest.controller.ClientController;
import com.brasilprev.test.brasilprevtest.model.Client;
import com.brasilprev.test.brasilprevtest.service.ClientService;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@WebMvcTest
public class ClientTest {
	
	
    @Autowired
	private ClientController clientController;
    
    @MockBean
    private ClientService clientService;
    
    @Autowired
    MockMvc mockMvc;
    
    @BeforeEach
    public void setup() {
    	RestAssuredMockMvc.standaloneSetup(this.clientController);
    	
    	
    }

	@Test
	public void clientTestGetAll() throws Exception{
		mockMvc.perform(get("/clientes"))
				.andExpect(status.isOK());
										
	}

}
