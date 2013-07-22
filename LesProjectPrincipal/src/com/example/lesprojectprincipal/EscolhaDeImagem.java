package com.example.lesprojectprincipal;

import com.example.logica.Matriz;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class EscolhaDeImagem extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_escolha_de_imagem);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.escolha_de_imagem, menu);
		return true;
	}
	
	public void click(View view){
		Intent intent = new Intent(this, GameActivity.class);
		int botao = Integer.parseInt((String)view.getTag());
		if(botao == 1){
			intent.putExtra("imagem",R.drawable.dragao);	
		}else if(botao == 2){
			intent.putExtra("imagem",R.drawable.jacare);
		}else if(botao == 3){
			intent.putExtra("imagem",R.drawable.hipopotamo);
		}else if(botao == 4){
			intent.putExtra("imagem",R.drawable.leopardo);
		}else if(botao == 5){
			intent.putExtra("imagem",R.drawable.mamute);
		}else if(botao == 6){
			intent.putExtra("imagem",R.drawable.tigre);
		}
		Matriz m = Matriz.getInstance();
    	m.reset();
		startActivity(intent);
	}

}
