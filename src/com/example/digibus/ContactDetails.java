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



public class ContactDetails extends AppCompatActivity {
	//private WebView mContact;
	
	WebView mWebView;
	ProgressDialog mProgress;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_details);
		
		
		mWebView = (WebView) findViewById(R.id.wv_contact);
		mWebView.loadUrl("file:///android_asset/mobile/index.html");
		  mWebView.getSettings().setJavaScriptEnabled(true);
	      mWebView.getSettings().setDomStorageEnabled(true);
	}

	

	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();            
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
 
	  private class Geninfo extends WebViewClient {
	    	
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        	System.out.println("URL: " + url);
	        	view.loadUrl("javascript:changeLocation('" + url + "')");
	            return true;
	        }
	    	public void onPageFinished(WebView view, String url) {
	    		if(mProgress.isShowing()) {
	    			mProgress.dismiss();
	    		}
	    	}
	    }
	 

	

	
}
