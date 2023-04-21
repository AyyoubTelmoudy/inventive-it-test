package com.inventiveit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventiveit.request.DreamCaseRequest;
import com.inventiveit.service.DreamCaseService;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class InventiveitTestApplicationTests {

	@MockBean
	private DreamCaseService dreamCaseService;
	@Autowired
	private MockMvc mockMvc;


	@Test
	@DisplayName("Verify if the endpoint of creating a record verifies the input")
	void testIfCreateDreamCaseRecordEndpointValidatesTheInput() throws Exception {

		DreamCaseRequest dreamCaseRequest=new DreamCaseRequest(null,"Description");
		mockMvc.perform(post("/cases")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(dreamCaseRequest)))
				.andExpect(status().isBadRequest());
	}

	@Test
	@DisplayName("Verify if the endpoint of updating a record verifies the input and checks if the record exists ")
	void testIfDeleteADreamRecordEndpointDeletesARecordSuccessfully() throws Exception {
		DreamCaseRequest dreamCaseRequest=new DreamCaseRequest(null,"Description");
		mockMvc.perform(put("/cases/1")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(dreamCaseRequest)))
				.andExpect(status().isBadRequest());
	}



}
