package com.example.lesprojectprincipal;

import com.example.logica.Matriz;
import com.example.logica.MatrizGrau4;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class GameActivity extends Activity {
	
	ImageView imagem;
	int local;
	String local2 = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		local = getIntent().getExtras().getInt("imagem");
		local2 = getIntent().getExtras().getString("imagem");
		reconfigurar();
		Chronometer cr = (Chronometer)findViewById(R.id.chronometer1);
		cr.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}
	
	public Bitmap[] splitBitmap(Bitmap picture){
		
		Bitmap scaledBitmap = Bitmap.createScaledBitmap(picture, 240, 240, true);
		Bitmap[] imgs = new Bitmap[10];
		imgs[1] = Bitmap.createBitmap(scaledBitmap, 0, 0, 60 , 60);
		imgs[2] = Bitmap.createBitmap(scaledBitmap, 60, 0, 60, 60);
		imgs[3] = Bitmap.createBitmap(scaledBitmap,120, 0, 60, 60);
		imgs[4] = Bitmap.createBitmap(scaledBitmap, 0, 60, 60, 60);
		imgs[5] = Bitmap.createBitmap(scaledBitmap, 60, 60, 60,60);
		imgs[6] = Bitmap.createBitmap(scaledBitmap, 120, 60,60,60);
		imgs[7] = Bitmap.createBitmap(scaledBitmap, 0, 120, 60,60);
		imgs[8] = Bitmap.createBitmap(scaledBitmap, 60, 120,60,60);
		imgs[9] = Bitmap.createBitmap(scaledBitmap, 120,120,60,60);
		return imgs;

	}
	public void click(View v){
		int botao = Integer.parseInt((String)v.getTag());
		Matriz m = Matriz.getInstance();
		if(botao == 1){
			if(m.movimentar(0, 0)){
				reconfigurar();
			}
		}else if(botao == 2){
			if(m.movimentar(0, 1)){
				reconfigurar();
			}
		}else if(botao == 3){
			if(m.movimentar(0, 2)){
				reconfigurar();
			}
		}else if(botao == 4){
			if(m.movimentar(1, 0)){
				reconfigurar();
			}
		}else if(botao == 5){
			if(m.movimentar(1, 1)){
				reconfigurar();
			}
		}else if(botao == 6){
			if(m.movimentar(1, 2)){
				reconfigurar();
			}
		}else if(botao == 7){
			if(m.movimentar(2, 0)){
				reconfigurar();
			}
		}else if(botao == 8){
			if(m.movimentar(2, 1)){
				reconfigurar();
			}
		}else{
			if(m.movimentar(2, 2)){
				reconfigurar();
			}
		}
		if(m.completo()){
			venceu();
		}
	}
	
	
	
	public void reconfigurar(){
		Bitmap foto = BitmapFactory.decodeResource(getResources(), local);
		
		if (local == 0){ // Se for zero eh para escolher de galeria
			foto = BitmapFactory.decodeFile(local2);
			
		}
		
		Bitmap foto2 = BitmapFactory.decodeResource(getResources(), R.drawable.preto);
		foto2 = Bitmap.createScaledBitmap(foto2, 60, 60, true);
		Bitmap[] pedacos = splitBitmap(foto);
		int[][] campo = Matriz.getInstance().getCampo();
		for(int i=0;i<3;i++){
			for (int j=0;j<3;j++){
				if(campo[i][j]==0){
					pedacos[campo[i][j]]=foto2;
				}
			}
		}
		imagem = (ImageView)findViewById(R.id.imageButton1);
		imagem.setImageBitmap(pedacos[campo[0][0]]);
		imagem = (ImageView)findViewById(R.id.ImageButton01);
		imagem.setImageBitmap(pedacos[campo[0][1]]);
		imagem = (ImageView)findViewById(R.id.ImageButton02);
		imagem.setImageBitmap(pedacos[campo[0][2]]);
		imagem = (ImageView)findViewById(R.id.ImageButton03);
		imagem.setImageBitmap(pedacos[campo[1][0]]);
		imagem = (ImageView)findViewById(R.id.ImageButton04);
		imagem.setImageBitmap(pedacos[campo[1][1]]);
		imagem = (ImageView)findViewById(R.id.ImageButton05);
		imagem.setImageBitmap(pedacos[campo[1][2]]);
		imagem = (ImageView)findViewById(R.id.ImageButton06);
		imagem.setImageBitmap(pedacos[campo[2][0]]);
		imagem = (ImageView)findViewById(R.id.ImageButton07);
		imagem.setImageBitmap(pedacos[campo[2][1]]);
		imagem = (ImageView)findViewById(R.id.ImageButton08);
		imagem.setImageBitmap(pedacos[campo[2][2]]);
	}
	
	public void reiniciar(View v){
		Matriz m = Matriz.getInstance();
		m.reset();
		reconfigurar();
		Chronometer cr = (Chronometer)findViewById(R.id.chronometer1);
		cr.stop();
		cr.setBase(SystemClock.elapsedRealtime());
		cr.start();
	}
	
    public void sair(View v){
	    this.finish();	
	}
    
    public void back(View v) {
		Intent intent = new Intent();
		setResult(RESULT_OK, intent);
		finish();
	}
    
    private void venceu(){
    	Intent intent = new Intent(this, Vencedor.class);
		startActivity(intent);
		finish();
    }

    
    /*
	 * Pra mostrar mensagens [not used!]
	 */
	public void showMessage(String title, String msg){
		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle(title);
		alertDialog.setMessage(msg);
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// TODO Add your code for the button here.
			}
		});
		// Set the Icon for the Dialog
		alertDialog.show();
	}
}
