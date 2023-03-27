package com.camilaferreiranas.workshopmongo.exception;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.camilaferreiranas.workshopmongo.services.exception.ObjectNotFoundException;

public class ObjectNotFoundExceptionTest {

	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	
	@Test
	public void shouldThrowException()  {
		exception.expect(ObjectNotFoundException.class);
		exception.expectMessage("Objeto não encontrado");
	}
}
