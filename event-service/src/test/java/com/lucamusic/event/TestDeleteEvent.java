package com.lucamusic.event;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.lucamusic.event.controller.EventController;
import com.lucamusic.event.repository.EventRepository;
import com.lucamusic.event.service.EventService;
import com.lucamusic.event.service.EventServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EventController.class)
public class TestDeleteEvent {
	
	@Autowired
	private MockMvc mockMvc;
	
	@TestConfiguration
	static class TestModifyEventConfiguration {
		@Bean
		public EventService eventService() {
			return new EventServiceImpl();
		}
	}
	
	@Autowired
	private EventService eventService;
	
	@MockBean
	private EventRepository eventRepository;
	
	

}
