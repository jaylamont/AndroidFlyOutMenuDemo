package com.example.flyoutmenuexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.flyoutmenuexample.view.viewgroup.FlyOutContainer;

public class SampleActivity extends Activity {

	FlyOutContainer root;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.root = (FlyOutContainer) this.getLayoutInflater().inflate(R.layout.activity_sample, null);
		
		this.setContentView(root);
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
