package com.camilaferreiranas.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.camilaferreiranas.workshopmongo.dto.AuthorDTO;
import com.camilaferreiranas.workshopmongo.dto.CommentDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Document
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Date date;
	private String title;
	private String body;

	private AuthorDTO author;

	private List<CommentDTO> comments = new ArrayList<>();

	public Post(String id, Date date, String title, String body, AuthorDTO author) {
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}
}
