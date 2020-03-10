package br.com.value.projects.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.value.projects.builder.CriadorDeJogo;
import br.com.value.projects.dominio.Jogo;
import br.com.value.projects.dominio.Participante;
import br.com.value.projects.dominio.Resultado;

public class JogoTeste {
	
		
	@Test
	public void deveTerJogoComUnicoParticipante() {
		Jogo jogo = new Jogo("Jogo de corrida");
		assertEquals(0, jogo.getResultados().size());

		jogo.anota(new Resultado(new Participante("Leonardo"), 150));

		assertEquals(1, jogo.getResultados().size());

		assertEquals(150.0, jogo.getResultados().get(0).getMetrica(), 0.00001);
	}
	
	

	@Test
	public void deveTerVariosResultados() {
		Jogo jogo = new CriadorDeJogo()
        .para("Cata moedas")
        .resultado(new Participante("Nelson"), 150.0)
        .resultado(new Participante("Pedro"), 200.0)
        .constroi();

		assertEquals(2, jogo.getResultados().size());
		assertEquals(150.0, jogo.getResultados().get(0).getMetrica(), 0.00001);
		assertEquals(200.0, jogo.getResultados().get(1).getMetrica(), 0.00001);
		
	}
	
	@Test
	public void naoDeveAceitarDoisResultadosDoMesmoParticipante(){

		Jogo jogo = new Jogo("Ca�a pe�as");
		Participante leonardo = new Participante("Leonardo");

		jogo.anota(new Resultado(leonardo, 500.0));
		//deve ser ignorado
		jogo.anota(new Resultado(leonardo, 600.0));

		assertEquals(1, jogo.getResultados().size());
        assertEquals(500, jogo.getResultados().get(0).getMetrica(), 0.00001);
	}
	
	//Gabriel Yudi
	@Test
	public void verificarSeTodosOsParticipantesDoJogoPossuemResultados() {
		
		Jogo jogo = new Jogo("Tiro ao alvo");
		Participante leonardo = new Participante("Leonardo");
		Participante joao = new Participante("Joao");
		Participante rafaela = new Participante("Rafaela");
		Participante maria = new Participante("Maria");
		
		jogo.anota(new Resultado(leonardo, 100));
		jogo.anota(new Resultado(joao, 300));
		jogo.anota(new Resultado(rafaela, 150));
		jogo.anota(new Resultado(maria, 200));
		
		List<Resultado> lista = jogo.getResultados() ;
				
		assertEquals(lista.get(0).getParticipante(),leonardo);
		assertEquals(lista.get(1).getParticipante(),joao);
		assertEquals(lista.get(2).getParticipante(),rafaela);
		assertEquals(lista.get(3).getParticipante(),maria);

		
	}
	
	//Lucas Chaves
	@Test(expected=RuntimeException.class)
	public void validarSeAceitaResultadosNegativos() {
		
		Jogo jogo = new Jogo("Tiro ao alvo");
		Participante leonardo = new Participante("Leonardo");
		Participante joao = new Participante("Joao");
		Participante rafaela = new Participante("Rafaela");
		Participante maria = new Participante("Maria");
		
		jogo.anota(new Resultado(leonardo, -100));
		jogo.anota(new Resultado(joao, -300));
		jogo.anota(new Resultado(rafaela, -150));
		jogo.anota(new Resultado(maria, -5));
				
	}
	
	//Laura Padilla
	@Test
	public void validarValorMaximoParaMetrica() {
		
		Jogo jogo = new Jogo("Tiro ao alvo");
		Participante leonardo = new Participante("Leonardo");
		
		jogo.anota(new Resultado(leonardo, 900));
				
		if(jogo.getResultados().get(0).getMetrica() > 1000) 
		{
			assertEquals(true, false);
		}
	}
	
	//Luiz Quintel
	@Test
	public void validarNomesParticipantes() {

	Participante leonardo = new Participante("Leonardo");
	Participante joao = new Participante("Joao");
	Participante rafaela = new Participante("Rafaela");
	Participante maria = new Participante("Maria");

	if(!leonardo.getNome().matches("[A-Za-z]*")){
		assertEquals(true, false);
	}

	if(!joao.getNome().matches("[A-Za-z]*")){
		assertEquals(true, false);
	}

	if(!rafaela.getNome().matches("[A-Za-z]*")){
		assertEquals(true, false);
	}

	if(!maria.getNome().matches("[A-Za-z]*")){
		assertEquals(true, false);
	}

	}
	

}