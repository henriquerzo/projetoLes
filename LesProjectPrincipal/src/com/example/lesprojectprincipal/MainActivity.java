package com.example.lesprojectprincipal;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends Activity {

	
	MediaPlayer player;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		AssetFileDescriptor afd;
		player = new MediaPlayer();

		try {
			afd = getAssets().openFd("audio.mp3");
			player.setDataSource(afd.getFileDescriptor());
			player.prepare();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void jogar(View view) {
		Intent intent = new Intent(this, NivelActivity.class);
		startActivity(intent);
	}

	public void back(View v) {
		Intent intent = new Intent();
		setResult(RESULT_OK, intent);
		this.finish();
	}

	public void onCheckboxClicked(View view) {

		// Is the view now checked?
		CheckBox checkbox = (CheckBox)findViewById(R.id.checkBox1);
		boolean checked = checkbox.isChecked();

		// Check which checkbox was clicked
		switch (view.getId()) {
		case R.id.checkBox1:
			if (checked)

				// Put some meat on the sandwich

				player.start();
			else
				// Remove the meat
				player.pause();
			break;

		}
	}

	
	public void tutorial(View view){
		Intent intent = new Intent(this, TutorialActivity.class);
		startActivity(intent);
		
	}
	
}
