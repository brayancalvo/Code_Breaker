package com.udea.appempresariales.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.udea.appempresariales.CodeBreaker;

public class CodeBreakerTest {
	
	private CodeBreaker codeBreaker = new CodeBreaker("1234");

	@Test
	public void todosBuenos() {
		String resultado = codeBreaker.adivinar("1234");
		assertEquals("XXXX", resultado);		
	}
	
	@Test
	public void existencia() {
		String resultado = codeBreaker.adivinar("4521");
		assertEquals("---", resultado);		
	}
	
	@Test
	public void existenciaCorrectos() {
		String resultado = codeBreaker.adivinar("1435");
		assertEquals("XX-", resultado);		
	}
	
	@Test
	public void validaLetras() {
		String resultado = codeBreaker.adivinar("14b5");
		assertEquals("error", resultado);		
	}

	@Test
	public void validaLongitud() {
		String resultado = codeBreaker.adivinar("145");
		assertEquals("error", resultado);		
	}
}
