package com.example.lesprojectprincipal;

import com.example.logica.MatrizGrau5;
import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;

public class GameDificilActivity extends Activity {

	ImageView imagem;
	int local;
	String local2 = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_dificil);
		
		local = getIntent().getExtras().getInt("imagem");
		local2 = getIntent().getExtras().getString("imagem");
		reconfigurar();
		Chronometer cr = (Chronometer) findViewById(R.id.chronometer1);
		cr.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_dificil, menu);
		return true;
	}
	
	public Bitmap[] splitBitmap(Bitmap picture) {

		Bitmap scaledBitmap = Bitmap
				.createScaledBitmap(picture, 180, 180, true);
		Bitmap[] imgs = new Bitmap[26];
		imgs[1] = Bitmap.createBitmap(scaledBitmap, 0, 0, 36, 36);
		imgs[2] = Bitmap.createBitmap(scaledBitmap, 36, 0, 36, 36);
		imgs[3] = Bitmap.createBitmap(scaledBitmap, 72, 0, 36, 36);
		imgs[4] = Bitmap.createBitmap(scaledBitmap, 108, 0, 36, 36);
		imgs[5] = Bitmap.createBitmap(scaledBitmap, 144, 0, 36, 36);
		imgs[6] = Bitmap.createBitmap(scaledBitmap, 0, 36, 36, 36);
		imgs[7] = Bitmap.createBitmap(scaledBitmap, 36, 36, 36, 36);
		imgs[8] = Bitmap.createBitmap(scaledBitmap, 72, 36, 36, 36);
		imgs[9] = Bitmap.createBitmap(scaledBitmap, 108, 36, 36, 36);
		imgs[10] = Bitmap.createBitmap(scaledBitmap, 144, 36, 36, 36);
		imgs[11] = Bitmap.createBitmap(scaledBitmap, 0, 72, 36, 36);
		imgs[12] = Bitmap.createBitmap(scaledBitmap, 36, 72, 36, 36);
		imgs[13] = Bitmap.createBitmap(scaledBitmap, 72, 72, 36, 36);
		imgs[14] = Bitmap.createBitmap(scaledBitmap, 108, 72, 36, 36);
		imgs[15] = Bitmap.createBitmap(scaledBitmap, 144, 72, 36, 36);
		imgs[16] = Bitmap.createBitmap(scaledBitmap, 0, 108, 36, 36);
		imgs[17] = Bitmap.createBitmap(scaledBitmap, 36, 108, 36, 36);
		imgs[18] = Bitmap.createBitmap(scaledBitmap, 72, 108, 36, 36);
		imgs[19] = Bitmap.createBitmap(scaledBitmap, 108, 108, 36, 36);
		imgs[20] = Bitmap.createBitmap(scaledBitmap, 144, 108, 36, 36);
		imgs[21] = Bitmap.createBitmap(scaledBitmap, 0, 144, 36, 36);
		imgs[22] = Bitmap.createBitmap(scaledBitmap, 36, 144, 36, 36);
		imgs[23] = Bitmap.createBitmap(scaledBitmap, 72, 144, 36, 36);
		imgs[24] = Bitmap.createBitmap(scaledBitmap, 108, 144, 36, 36);
		imgs[25] = Bitmap.createBitmap(scaledBitmap, 144, 144, 36, 36);
		return imgs;

	}
	
	public void reconfigurar() {
		Bitmap foto = BitmapFactory.decodeResource(getResources(), local);

		if (local == 0) { // Se for zero eh para escolher de galeria
			foto = BitmapFactory.decodeFile(local2);

		}

		Bitmap foto2 = BitmapFactory.decodeResource(getResources(),
				R.drawable.preto);
		foto2 = Bitmap.createScaledBitmap(foto2, 36, 36, true);
		Bitmap[] pedacos = splitBitmap(foto);
		int[][] campo = MatrizGrau5.getInstance().getCampo();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (campo[i][j] == 0) {
					pedacos[campo[i][j]] = foto2;
				}
			}
		}
		imagem = (ImageView) findViewById(R.id.ImageView02);
		imagem.setImageBitmap(pedacos[campo[0][0]]);
		imagem = (ImageView) findViewById(R.id.ImageView01);
		imagem.setImageBitmap(pedacos[campo[0][1]]);
		imagem = (ImageView) findViewById(R.id.ImageView03);
		imagem.setImageBitmap(pedacos[campo[0][2]]);
		imagem = (ImageView) findViewById(R.id.ImageView04);
		imagem.setImageBitmap(pedacos[campo[0][3]]);
		imagem = (ImageView) findViewById(R.id.ImageView05);
		imagem.setImageBitmap(pedacos[campo[0][4]]);
		imagem = (ImageView) findViewById(R.id.ImageView06);
		imagem.setImageBitmap(pedacos[campo[1][0]]);
		imagem = (ImageView) findViewById(R.id.ImageView07);
		imagem.setImageBitmap(pedacos[campo[1][1]]);
		imagem = (ImageView) findViewById(R.id.ImageView08);
		imagem.setImageBitmap(pedacos[campo[1][2]]);
		imagem = (ImageView) findViewById(R.id.ImageView09);
		imagem.setImageBitmap(pedacos[campo[1][3]]);
		imagem = (ImageView) findViewById(R.id.ImageView10);
		imagem.setImageBitmap(pedacos[campo[1][4]]);
		imagem = (ImageView) findViewById(R.id.ImageView11);
		imagem.setImageBitmap(pedacos[campo[2][0]]);
		imagem = (ImageView) findViewById(R.id.ImageView14);
		imagem.setImageBitmap(pedacos[campo[2][1]]);
		imagem = (ImageView) findViewById(R.id.ImageView15);
		imagem.setImageBitmap(pedacos[campo[2][2]]);
		imagem = (ImageView) findViewById(R.id.ImageView16);
		imagem.setImageBitmap(pedacos[campo[2][3]]);
		imagem = (ImageView) findViewById(R.id.ImageView17);
		imagem.setImageBitmap(pedacos[campo[2][4]]);
		imagem = (ImageView) findViewById(R.id.ImageView12);
		imagem.setImageBitmap(pedacos[campo[3][0]]);
		imagem = (ImageView) findViewById(R.id.ImageView18);
		imagem.setImageBitmap(pedacos[campo[3][1]]);
		imagem = (ImageView) findViewById(R.id.ImageView19);
		imagem.setImageBitmap(pedacos[campo[3][2]]);
		imagem = (ImageView) findViewById(R.id.ImageView20);
		imagem.setImageBitmap(pedacos[campo[3][3]]);
		imagem = (ImageView) findViewById(R.id.ImageView21);
		imagem.setImageBitmap(pedacos[campo[3][4]]);
		imagem = (ImageView) findViewById(R.id.ImageView13);
		imagem.setImageBitmap(pedacos[campo[4][0]]);
		imagem = (ImageView) findViewById(R.id.ImageView22);
		imagem.setImageBitmap(pedacos[campo[4][1]]);
		imagem = (ImageView) findViewById(R.id.ImageView23);
		imagem.setImageBitmap(pedacos[campo[4][2]]);
		imagem = (ImageView) findViewById(R.id.ImageView24);
		imagem.setImageBitmap(pedacos[campo[4][3]]);
		imagem = (ImageView) findViewById(R.id.ImageView25);
		imagem.setImageBitmap(pedacos[campo[4][4]]);
	}
	
	public void click(View v){
		int botao = Integer.parseInt((String)v.getTag());
		MatrizGrau5 m = MatrizGrau5.getInstance();
		
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
			if(m.movimentar(0, 3)){
				reconfigurar();
			}
		}else if(botao == 5){
			if(m.movimentar(0, 4)){
				reconfigurar();
			}
		}else if(botao == 6){
			if(m.movimentar(1, 0)){
				reconfigurar();
			}
		}else if(botao == 7){
			if(m.movimentar(1, 1)){
				reconfigurar();
			}
		}else if(botao == 8){
			if(m.movimentar(1, 2)){
				reconfigurar();
			}
		}else if(botao == 9){
			if(m.movimentar(1, 3)){
				reconfigurar();
			}
		}else if(botao == 10){
			if(m.movimentar(1, 4)){
				reconfigurar();
			}
		}else if(botao == 11){
			if(m.movimentar(2, 0)){
				reconfigurar();
			}
		}else if(botao == 12){
			if(m.movimentar(2, 1)){
				reconfigurar();
			}
		}else if(botao == 13){
			if(m.movimentar(2, 2)){
				reconfigurar();
			}
		}else if(botao == 14){
			if(m.movimentar(2, 3)){
				reconfigurar();
			}
		}else if(botao == 15){
			if(m.movimentar(2, 4)){
				reconfigurar();
			}
		}else if(botao == 16){
			if(m.movimentar(3, 0)){
				reconfigurar();
			}
		}else if(botao == 17){
			if(m.movimentar(3, 1)){
				reconfigurar();
			}
		}else if(botao == 18){
			if(m.movimentar(3, 2)){
				reconfigurar();
			}
		}else if(botao == 19){
			if(m.movimentar(3, 3)){
				reconfigurar();
			}
		}else if(botao == 20){
			if(m.movimentar(3, 4)){
				reconfigurar();
			}
		}else if(botao == 21){
			if(m.movimentar(4, 0)){
				reconfigurar();
			}
		}else if(botao == 22){
			if(m.movimentar(4, 1)){
				reconfigurar();
			}
		}else if(botao == 23){
			if(m.movimentar(4, 2)){
				reconfigurar();
			}
		}else if(botao == 24){
			if(m.movimentar(4, 3)){
				reconfigurar();
			}
		}else{
			if(m.movimentar(4, 4)){
				reconfigurar();
			}
		}
		if(m.completo()){
			venceu();
		}
	}
	
	public void reiniciar(View v){
		MatrizGrau5 m = MatrizGrau5.getInstance();
		m.reset();
		reconfigurar();
		Chronometer cr = (Chronometer)findViewById(R.id.chronometer1);
		cr.stop();
		cr.setBase(SystemClock.elapsedRealtime());
		cr.start();
	}
	
	public void sair(View v) {
		this.finish();
	}

	public void back(View v) {
		Intent intent = new Intent();
		setResult(RESULT_OK, intent);
		finish();
	}

	private void venceu() {
		Intent intent = new Intent(this, Vencedor.class);
		startActivity(intent);
		finish();
	}

}
