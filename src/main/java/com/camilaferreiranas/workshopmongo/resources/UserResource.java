package com.camilaferreiranas.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.camilaferreiranas.workshopmongo.domain.Post;
import com.camilaferreiranas.workshopmongo.domain.User;
import com.camilaferreiranas.workshopmongo.dto.UserDTO;
import com.camilaferreiranas.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")

public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>>  findAllUsers() {
		List<User> listaUsers = service.findAll();
		List<UserDTO> listaUsersDTO = listaUsers.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaUsersDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findUserById(@PathVariable String id) {
		User user = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
		}
	
	@PostMapping
	public ResponseEntity<Void> insertUser(@RequestBody UserDTO objDto) {
		User user = service.fromDto(objDto);
		user = service.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable String id) {
		 service.delete(id);
		return ResponseEntity.noContent().build();
		}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> updateUserById(@RequestBody UserDTO objDto, @PathVariable String id) {
		User user = service.fromDto(objDto);
		user.setId(id);
		user = service.update(user);
		return ResponseEntity.noContent().build();
	}
	
	
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> findPostsById(@PathVariable String id) {
		User user = service.findById(id);
		return ResponseEntity.ok().body(user.getPosts());
		}

}
