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
			throw new RuntimeException("N�o � permitido valor menor que 0");
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
				throw new Exception("M�trica maior que o valor m�ximo");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
}
