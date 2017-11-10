package com.example.digibus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.app.ProgressDialog;

public class AboutUs extends AppCompatActivity {
	private WebView mAbout;
	ProgressDialog mProgress;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_us);

		mAbout = (WebView) findViewById(R.id.wv_contact);
		mAbout.loadUrl("file:///android_asset/mobile/index.html");
		mAbout.getSettings().setJavaScriptEnabled(true);
		mAbout.getSettings().setDomStorageEnabled(true);
	}
	
	private void startWebView(String url) {
		// TODO Auto-generated method stub
		
		mAbout.setWebViewClient(new WebViewClient() 
		{      
            ProgressDialog progressDialog;
          
           
            public boolean shouldOverrideUrlLoading(WebView view, String url) 
            {              
                view.loadUrl(url);
                return true;
            }
            
       
            public void onLoadResource (WebView view, String url)
            {
                if (progressDialog == null)
                {
                    
                    progressDialog = new ProgressDialog(AboutUs.this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.show();
                }
            }
            
            public void onPageFinished(WebView view, String url) 
            {
                try
                {
                if (progressDialog.isShowing()) 
                {
                    progressDialog.dismiss();
                    progressDialog = null;
                }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
            }
             
        }); 
		
		
		
		mAbout.getSettings().setJavaScriptEnabled(true);
		mAbout.loadUrl(url);
	}
	
	
	@Override
	   
    public void onBackPressed() {
        if(mAbout.canGoBack()) {
        	mAbout.goBack();
        } else {
           
            super.onBackPressed();
        }
    }

	
}
