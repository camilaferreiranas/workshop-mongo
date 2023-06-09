package com.camilaferreiranas.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

import com.camilaferreiranas.workshopmongo.domain.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String title;
	private String body;
	private Date date;
	private AuthorDTO author;
	
	public PostDTO(Post post) {
		title = post.getTitle();
		body = post.getBody();
		date = post.getDate();
		author = post.getAuthor();
	}
}
