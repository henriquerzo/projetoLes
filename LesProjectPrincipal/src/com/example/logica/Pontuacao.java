package com.example.logica;

public class Pontuacao {

	public int getPontos() {
		return pontos;
	}



	public void setPontos(int pontos) {
		this.pontos = pontos;
	}



	public int getTempo() {
		return tempo;
	}



	public void setTempo(int tempo) {
		this.tempo = tempo;
	}



	public int getNivel() {
		return nivel;
	}



	public void setNivel(int nivel) {
		this.nivel = nivel;
	}



	private int pontos = 0;
	private int tempo;
	private int nivel;

	public Pontuacao(int tempo, int nivel) {

		this.pontos = pontos;
		this.tempo = tempo;
		this.nivel = nivel;
		
	}
	
	
	
	public int calculaPontos(){
		if(nivel == 3){
			pontos = 300/(tempo);
		}
		else if(nivel == 4){
			pontos = 4000/(tempo);
		}
		else if(nivel == 5){
			pontos = 5000/(tempo);
		}
		
		
		return pontos;
	}

}
