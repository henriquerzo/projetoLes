package com.example.lesprojectprincipal;

import java.util.ArrayList;

import com.example.logica.HistoricoPontuacao;
import com.example.logica.Pontuacao;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class PontuacaoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pontuacao);
		
		/*HistoricoPontuacao historicoP = HistoricoPontuacao.getInstance();
		
		ScrollView scrollPontos = (ScrollView) findViewById(R.id.scrollViewPontuacao);
		
		for(TextView txV : historicoP.gettexViewPontuacoes()){
			scrollPontos.addView(txV);
			
		}*/
	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pontuacao, menu);
		return true;
	}

}
