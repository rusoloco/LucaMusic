package com.lucamusic.user;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.lucamusic.user.control.UserControl;
import com.lucamusic.user.entity.User;
import com.lucamusic.user.service.UserServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserControl.class)
public class UserTest03_getUserById {



	@Autowired
	private MockMvc mockMvc;


	@MockBean
	private UserServiceImpl serv;

	@Test
	void assertUserSearchById() throws Exception {
		Long id = null;
		
		User user = new User(id, "Pepe", "pepe@", "qqq", new Date(2020));
		user.setId(1L);
		
		when(serv.findByID(id)).thenReturn(user);

		mockMvc
		.perform(get("/user").param("id", "1L"))
		.andDo(print())
		.andExpect(status().isOk());
		
		
		
	}
}

