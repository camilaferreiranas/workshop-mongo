package com.camilaferreiranas.workshopmongo.resources.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	

}
