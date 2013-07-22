package com.example.lesprojectprincipal;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Vencedor extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vencedor);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vencedor, menu);
		return true;
	}

	public void voltar(View view){
		Intent intent = new Intent(this, EscolhaDeImagem.class);
		startActivity(intent);
	}
}
