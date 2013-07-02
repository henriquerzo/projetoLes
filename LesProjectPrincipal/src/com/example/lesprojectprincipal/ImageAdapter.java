package com.example.lesprojectprincipal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;



public class ImageAdapter extends BaseAdapter {
	
	private Context mContext;
	
	// references to our images 
	private Integer[] mThumbIds = {
	R.drawable.um,
	R.drawable.dois,
	R.drawable.tres,
	R.drawable.quatro,
	R.drawable.cinco,
	R.drawable.seis,
	R.drawable.sete,
	R.drawable.oito,
	R.drawable.vazio,
	};
	
	public ImageAdapter(Context c) { 
		mContext = c; 
		} 

	@Override
	public int getCount() {
		return mThumbIds.length; 
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	// create a new ImageView for each item referenced by the Adapter
	@Override
	public View getView(int position, View convertView, ViewGroup parent) { 
	ImageView imageView; 
	if (convertView == null) {  // if it's not recycled, initialize some attributes 
	    imageView = new ImageView(mContext); 
	    imageView.setLayoutParams(new GridView.LayoutParams(85, 85)); 
	    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP); 
	    imageView.setPadding(8, 8, 8, 8); 
	} else { 
	    imageView = (ImageView) convertView; 
	} 

	imageView.setImageResource(mThumbIds[position]); 
	return imageView; 
	} 

	
}
