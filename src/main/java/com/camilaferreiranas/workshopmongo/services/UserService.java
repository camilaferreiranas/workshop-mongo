package com.camilaferreiranas.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camilaferreiranas.workshopmongo.domain.User;
import com.camilaferreiranas.workshopmongo.dto.UserDTO;
import com.camilaferreiranas.workshopmongo.repository.UserRepository;
import com.camilaferreiranas.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDto(UserDTO objDto) {
		return new User(objDto.getName(), objDto.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User usuario = findById(obj.getId());
		updateData(usuario, obj);
		return repo.save(usuario);
	}
	
	public void updateData(User newUser, User oldUser) {
		newUser.setName(oldUser.getName());
		newUser.setEmail(oldUser.getEmail());
	}
}
