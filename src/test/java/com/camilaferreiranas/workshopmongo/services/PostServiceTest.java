package com.camilaferreiranas.workshopmongo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.camilaferreiranas.workshopmongo.domain.Post;
import com.camilaferreiranas.workshopmongo.domain.User;
import com.camilaferreiranas.workshopmongo.dto.AuthorDTO;
import com.camilaferreiranas.workshopmongo.repository.PostRepository;

@RunWith( SpringRunner.class )
@SpringBootTest
public class PostServiceTest {
	
	@InjectMocks
	private PostService postService;
	
	@Mock
	private PostRepository postRepository;
	
	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	
	@Test
	public void shouldSalvarPost() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		try {
			Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",
					new AuthorDTO(maria));
			Mockito.when(postRepository.save(post1)).thenReturn(post1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
