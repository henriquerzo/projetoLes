package com.example.lesprojectprincipal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class NivelActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nivel);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nivel, menu);
		return true;
	}
	
	public void escolheImagem(View view){
		Intent intent = new Intent(this, EscolhaDeImagem.class);
		
		Integer nivel_temp = Integer.parseInt((String) view.getTag());
		
		intent.putExtra("nivel", nivel_temp);
		
		startActivity(intent);
	}

}
