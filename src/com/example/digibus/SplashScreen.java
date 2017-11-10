package com.example.digibus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;

public class SplashScreen extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		Thread timer = new Thread()
		{
			public void run()
			{
				try 
				{
					sleep(3000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				} finally
				{
					Intent menu = new Intent(SplashScreen.this,UserDash.class);
					startActivity(menu);
					
				}
			}
		};timer.start();
		
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//ourSong.release();
		//kills the splash activity once it has been displayed at the start.
		finish();
	}
	
}
