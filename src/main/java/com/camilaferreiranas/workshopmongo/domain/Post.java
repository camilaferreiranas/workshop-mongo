package com.camilaferreiranas.workshopmongo.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
	
	private User author;
}
