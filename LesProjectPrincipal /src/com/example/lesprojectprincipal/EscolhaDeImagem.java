package com.example.lesprojectprincipal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;

import com.example.logica.Matriz;

public class EscolhaDeImagem extends Activity {

	private static final int SELECT_PICTURE = 1;	 
	private String selectedImagePath;
	private boolean enabled = false;
	private int botao;

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
		botao = Integer.parseInt((String)view.getTag());

		if(botao == 7){
			enabled = true;
			intent = new Intent();
			intent.setType("image/*");
			intent.setAction(Intent.ACTION_GET_CONTENT);
			startActivityForResult(Intent.createChooser(intent,
					"Select Picture"), SELECT_PICTURE);
		}else{
			
			intent.putExtra("imagem",getBotaoImage(botao));
			Matriz m = Matriz.getInstance();
			m.reset();
			startActivity(intent);
		}



	}


	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (resultCode == RESULT_OK && enabled) {

			if (requestCode == SELECT_PICTURE) {
				
				Uri selectedImageUri = data.getData();
				selectedImagePath = getPath(selectedImageUri);
				
				Intent intent = new Intent(this, GameActivity.class);
				intent.putExtra("imagem",selectedImagePath);
				
				Matriz m = Matriz.getInstance();
				m.reset();
				startActivity(intent);
			}

		}
		
	}


	public int getBotaoImage(int botao){

		if(botao == 1){
			return R.drawable.dragao;
		}else if(botao == 2){
			return R.drawable.jacare;

		}else if(botao == 3){
			return R.drawable.hipopotamo;

		}else if(botao == 4){
			return R.drawable.leopardo;

		}else if(botao == 5){
			return R.drawable.mamute;

		}else if(botao == 6){
			return R.drawable.tigre;

		}else{
			return R.drawable.tigre;
		}
	}

	public String getPath(Uri uri) {
		String[] projection = { MediaStore.Images.Media.DATA };
		Cursor cursor = managedQuery(uri, projection, null, null, null);
		int column_index = cursor
				.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		return cursor.getString(column_index);
	}


	public void takePicture(View view){
		Intent intent = new Intent(this, CameraActivity.class);
		startActivity(intent);
	}


	public void back(View v) {
		Intent intent = new Intent();
		setResult(RESULT_OK, intent);
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
