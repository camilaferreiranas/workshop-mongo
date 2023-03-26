package com.camilaferreiranas.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camilaferreiranas.workshopmongo.domain.Post;
import com.camilaferreiranas.workshopmongo.dto.PostDTO;
import com.camilaferreiranas.workshopmongo.resources.util.URL;
import com.camilaferreiranas.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService postService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findPostById(@PathVariable String id) {
		Post post = postService.findPostById(id);
		return ResponseEntity.ok().body(new PostDTO(post));
	}

	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<PostDTO>> findPostByTitle(@RequestParam(value = "text", defaultValue = "text") String text) {
		text = URL.decodeParam(text);
		List<Post> list = postService.findByTitle(text);
		List<PostDTO> listDto = list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);

	}
}
