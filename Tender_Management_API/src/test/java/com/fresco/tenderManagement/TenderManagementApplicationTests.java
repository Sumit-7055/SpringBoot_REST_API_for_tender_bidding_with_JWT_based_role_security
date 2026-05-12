package com.fresco.tenderManagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fresco.tenderManagement.dto.LoginDTO;
import com.fresco.tenderManagement.model.RoleModel;
import com.fresco.tenderManagement.model.BiddingModel;
import com.fresco.tenderManagement.model.UserModel;
import com.fresco.tenderManagement.repository.RoleRepository;
import com.fresco.tenderManagement.repository.UserRepository;
import org.hamcrest.Matchers;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static java.lang.System.out;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class TenderManagementApplicationTests {


	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	private MockMvc mockMvc;

	public static final String TOKEN_APPROVER_1 = "token_approver_1";
	public static final String TOKEN_BIDDER_1 = "token_bidder_1";
	public static final String TOKEN_BIDDER_2 = "token_bidder_2";
	public static final String ID_USER_1 = "id_user_1";
	public static final String ID_USER_2 ="id_user_2";
	public static final String ID_BIDDING_1 = "id_bidding_1";
	public static final String ID_BIDDING_2 = "id_bidding_2";

	@Autowired
	WebApplicationContext context;

	@BeforeEach
	void setMockMvc(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}



}
