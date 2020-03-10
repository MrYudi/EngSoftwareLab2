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
	
	public void validaResultadoMaximoMetrica(double metrica) {
		try {
			if(metrica > 1000)
			{
				throw new Exception("Métrica maior que o valor máximo");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
}
