package com.example.lesprojectprincipal;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GameDificilActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_dificil);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_dificil, menu);
		return true;
	}

}
