package com.example.lesprojectprincipal;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;
import android.view.Menu;
import android.view.View;

public class CameraActivity extends Activity {

	private static final int REQUEST_PICTURE = 1000;

	File photo = null;
	File _file;
	File _dir;
	
	private String selectedImagePath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);

		takePicture();
	}

	/**
	 * M�todo que tira uma foto.
	 */
	public void takePicture() {
		
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

		_file = new File(_dir, "myPhoto_{0}.jpg");

		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(_file));

		startActivityForResult(intent, 0);
	}

	/**
	 * M�todo chamado quando a aplica��o nativa da c�mera � finalizada
	 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// Verifica o c�digo de requisi��o e se o resultado � OK (outro resultado indica que
		// o usu�rio cancelou a tirada da foto)

		Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
		Uri contentUri = Uri.fromFile(_file);
		
		String path = contentUri.toString(); // "/mnt/sdcard/FileName.mp3"
		try {
			File myfile = new File(new URI(path));
			selectedImagePath = myfile.getAbsolutePath();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//File myFile = new File(contentUri.toString());
				
		//selectedImagePath = getRealPathFromURI(contentUri);
		//showMessage("Teste de path", _file.getAbsolutePath()+"");
		this.finish();
		Intent intent = new Intent(this, EscolhaDeImagem.class);
		
		//TODO
		//Adicionar extra com path da imagem tirada pela cam aqui
		//Intent intent = new Intent(this, GameActivity.class);
		//intent.putExtra("imagem",contentUri);

		//Matriz m = Matriz.getInstance();
		//m.reset();
		startActivity(intent);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.camera, menu);
		return true;
	}
	
	public String getRealPathFromURI(Uri contentUri) {
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
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
	

	public void back(View v) {
		Intent intent = new Intent();
		setResult(RESULT_OK, intent);
		finish();
	}
}
