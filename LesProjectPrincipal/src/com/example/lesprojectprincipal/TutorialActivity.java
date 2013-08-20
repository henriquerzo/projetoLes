package com.example.lesprojectprincipal;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class TutorialActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutorial);
		
		TextView textoTutorial = (TextView) findViewById(R.id.textTutorial);
		
		textoTutorial.setText("O jogo consiste num puzzle onde o jogador deverá " +
				"montá-lo movimentando as peças horizontalmente e verticalmente. " +
				"O jogador vence quando montar o puzzle corretamente.");
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tutorial, menu);
		return true;
	}
	
	
	public void back(View v) {
		Intent intent = new Intent();
		setResult(RESULT_OK, intent);
		this.finish();
	}
	
	public void visualizaTexto(){
		 final TextView tv = new TextView(this);

		 
		   tv.setTextSize(18);

		   tv.setGravity(Gravity.CENTER_VERTICAL| Gravity.CENTER_HORIZONTAL);
		   /*tv.setOnTouchListener(new OnTouchListener(){


		           public boolean onTouch(View v, MotionEvent e)
		           {


		                   Random r = new Random();
		                   int i = r.nextInt(101);

		                   if (e.getAction() == e.ACTION_DOWN)
		                   {
		                           tv.setText(tips[i]);
		                           tv.setBackgroundResource(R.drawable.inner);


		                   }

		           return true;
		           }

				

		   });*/

		   setContentView(tv);
	}

}
