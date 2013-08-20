package com.example.logica;

import java.util.ArrayList;

//import android.view.View;
import android.widget.TextView;

public class HistoricoPontuacao {
	
	private static HistoricoPontuacao historico;

	private ArrayList<Pontuacao> pontuacoes;
	//private ArrayList<TextView> textViewPontuacoes;

	public static HistoricoPontuacao getInstance() {
		if(historico == null){
			historico = new HistoricoPontuacao();
			
		}
		return historico;
	}

	
	protected HistoricoPontuacao(){
		pontuacoes = new ArrayList<Pontuacao>();
		//textViewPontuacoes = new ArrayList<TextView>();
	}
	

	public void addPontuacao(Pontuacao p, TextView pnt) {
		pontuacoes.add(p);
		//textViewPontuacoes.add(pnt);
	}

	//verificar
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


	/*public ArrayList<TextView> gettexViewPontuacoes() {
		
		return textViewPontuacoes;
	}*/


}
