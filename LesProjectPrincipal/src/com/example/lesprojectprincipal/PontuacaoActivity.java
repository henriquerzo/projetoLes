package com.example.lesprojectprincipal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


import com.example.logica.Pontuacao;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class PontuacaoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pontuacao);
		
		int[] p = new int[5];
		
		try {
		    BufferedReader inputReader = new BufferedReader(new InputStreamReader(openFileInput("score")));                
		    for(int i=0;i<5;i++){
		        p[i] = Integer.parseInt(inputReader.readLine());	
		    }
		    inputReader.close();
		} catch (Exception e) {
		}
		
		TextView scores = (TextView)findViewById(R.id.textView3);
		scores.setText(p[0]+"");
		scores = (TextView)findViewById(R.id.textView5);
		scores.setText(p[1]+"");
		scores = (TextView)findViewById(R.id.textView7);
		scores.setText(p[2]+"");
		scores = (TextView)findViewById(R.id.textView9);
		scores.setText(p[3]+"");
		scores = (TextView)findViewById(R.id.textView11);
		scores.setText(p[4]+"");	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pontuacao, menu);
		return true;
	}

}
