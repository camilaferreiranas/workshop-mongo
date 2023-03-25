package com.camilaferreiranas.workshopmongo.dto;

import java.io.Serializable;

import com.camilaferreiranas.workshopmongo.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;

	public AuthorDTO(User obj) {
		name = obj.getName();
	}
}
