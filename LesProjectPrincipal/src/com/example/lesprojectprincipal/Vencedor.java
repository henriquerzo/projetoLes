package com.example.lesprojectprincipal;

import com.example.logica.HistoricoPontuacao;
import com.example.logica.Pontuacao;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Vencedor extends Activity {

	HistoricoPontuacao historico = HistoricoPontuacao.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vencedor);
		int tempo = (int)getIntent().getExtras().getLong("tempo");
		int level = getIntent().getExtras().getInt("level");
		Pontuacao pontos = new Pontuacao(tempo, level);
		TextView pnt = (TextView)findViewById(R.id.textView3);
		pnt.setText(pontos.calculaPontos()+"");
		//salvaPontos(pontos, pnt);
	}

	/*private void salvaPontos(Pontuacao pontos, TextView pnt) {
		historico = HistoricoPontuacao.getInstance();
		historico.addPontuacao(pontos, pnt);
		
	}
*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vencedor, menu);
		return true;
	}

	public void voltar(View view){
		Intent intent = new Intent(this, NivelActivity.class);
		startActivity(intent);
		finish();
	}

	public void back(View v) {
		Intent intent = new Intent();
		setResult(RESULT_OK, intent);
		finish();
	}
}
