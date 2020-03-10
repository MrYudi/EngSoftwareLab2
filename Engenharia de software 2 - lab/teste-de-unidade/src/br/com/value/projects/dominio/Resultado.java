package br.com.value.projects.dominio;

public class Resultado {

	private Participante participante;
	private double metrica;
	
	public Resultado(Participante participante, double metrica) {
		this.participante = participante;
		this.metrica = metrica;
		
		//Lucas Chaves
		if (metrica<0)
		{
			throw new RuntimeException("Não é permitido valor menor que 0");
		}
	}

	public Participante getParticipante() {
		return participante;
	}

	public double getMetrica() {
		return metrica;
	}
	
	
	
}
