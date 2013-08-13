package com.example.logica;

import java.util.ArrayList;

public class HistoricoPontuacao {

	private ArrayList<Pontuacao> pontuacoes;

	public HistoricoPontuacao() {
		this.pontuacoes = new ArrayList<Pontuacao>();
	}

	public void addPontuacao(Pontuacao p) {
		pontuacoes.add(p);
	}

	public void removePontuacao(Pontuacao p) {
		for (Pontuacao pont : pontuacoes) {
			if (pont.getPontos() == p.getPontos()) {
				pontuacoes.remove(0);
				break;
			}
		}
	}

	public ArrayList<Pontuacao> getPontuacoes() {
		return pontuacoes;
	}

	public void setPontuacoes(ArrayList<Pontuacao> novoP) {
		pontuacoes = novoP;

	}

}
