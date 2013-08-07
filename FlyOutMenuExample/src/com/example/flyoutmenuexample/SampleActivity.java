package com.example.flyoutmenuexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.util.DisplayMetrics;
import android.view.Display;

import com.example.flyoutmenuexample.view.viewgroup.FlyOutContainer;

public class SampleActivity extends Activity {
	
	public static int outWidth;//needed for getScreenDimens
	public static float density, dpHeight, dpWidth;//needed for getScreenDimens
	
	FlyOutContainer root;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//get display info to make the ammount of the original content after flyout dynamic based on screen size and density.
		getScreenDimens();
		
		this.root = (FlyOutContainer) this.getLayoutInflater().inflate(R.layout.activity_sample, null);
		
		this.setContentView(root);
	}
	
	//get info on our current screen
	private void getScreenDimens(){
		Display display = getWindowManager().getDefaultDisplay();
		DisplayMetrics outMetrics = new DisplayMetrics();
		display.getMetrics(outMetrics);
		density = getResources().getDisplayMetrics().density;
		dpHeight = outMetrics.heightPixels / density;
		dpWidth = outMetrics.widthPixels / density;
		outWidth = Math.round(dpWidth);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sample, menu);
		return true;
	}
	
	public void toggleMenu(View v){
		this.root.toggleMenu();
	}

}
