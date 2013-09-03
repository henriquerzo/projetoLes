package com.example.lesprojectprincipal;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import com.example.logica.Pontuacao;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Vencedor extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vencedor);
		int tempo = (int)getIntent().getExtras().getLong("tempo");
		int level = getIntent().getExtras().getInt("level");
		Pontuacao pontos = new Pontuacao(tempo, level);
		TextView pnt = (TextView)findViewById(R.id.textView3);
		pnt.setText(pontos.calculaPontos()+"");
		salvaPontos(pontos);
		
	}

	private void salvaPontos(Pontuacao pontos) {
		int[] p = new int[5];
		boolean salvar = false;
		
		try {
		    BufferedReader inputReader = new BufferedReader(new InputStreamReader(openFileInput("score")));                
		    for(int i=0;i<5;i++){
		        p[i] = Integer.parseInt(inputReader.readLine());	
		    }
		    inputReader.close();
		} catch (Exception e) {
		}
		
		int temp = pontos.getPontos();
		for(int i=0;i<5;i++){
			if(p[i]<temp){
				int t = p[i];
				p[i] = temp;
				temp = t;
				salvar = true;
			}
		}
		
		if(salvar){
			try {
			    FileOutputStream fos = openFileOutput("score", Context.MODE_PRIVATE);
			    String str = p[0]+"\n"+p[1]+"\n"+p[2]+"\n"+p[3]+"\n"+p[4]; 
			    fos.write(str.getBytes());
			    fos.close();
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}
	}

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
