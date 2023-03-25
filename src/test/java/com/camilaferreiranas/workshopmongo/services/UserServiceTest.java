package com.camilaferreiranas.workshopmongo.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.camilaferreiranas.workshopmongo.domain.User;
import com.camilaferreiranas.workshopmongo.repository.UserRepository;

@RunWith( SpringRunner.class )
@SpringBootTest
public class UserServiceTest {

	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository repository;
	
	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void shouldFindAllUsers() {
		List<User> lista = new ArrayList<>();
		Mockito.when(userService.findAll()).thenReturn(lista);
	}
}
