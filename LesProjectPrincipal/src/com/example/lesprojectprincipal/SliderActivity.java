package com.example.lesprojectprincipal;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;


public class SliderActivity extends Activity {
	
    
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slider);

		GridView gridview = (GridView) findViewById(R.id.gridView1); 
	    gridview.setAdapter(new ImageAdapter(this)); 

	    gridview.setOnItemClickListener(new OnItemClickListener() { 
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) { 
	            Toast.makeText(SliderActivity.this, "" + position, Toast.LENGTH_SHORT).show(); 
	        } 
	    }); 
	}
	
	
	
	public void voltarMenu(View view){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		
	}

}
