package com.example.digibus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.app.ProgressDialog;
import android.os.Bundle;

public class ViewTicket extends AppCompatActivity {
	WebView mVeiw;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_ticket);
		mVeiw = (WebView) findViewById(R.id.wv_view_ticket);
		startWebView("http://m.ksrtc.in/mobile/preViewBookingHistory.do");
	}
	private void startWebView(String url) {
		// TODO Auto-generated method stub
		mVeiw.setWebViewClient(new WebViewClient() 
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
                    
                    progressDialog = new ProgressDialog(ViewTicket.this);
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
		
		mVeiw.getSettings().setJavaScriptEnabled(true);
		mVeiw.loadUrl(url);
		
	}
	
	 @Override
	   
	    public void onBackPressed() {
	        if(mVeiw.canGoBack()) {
	        	mVeiw.goBack();
	        } else {
	           
	            super.onBackPressed();
	        }
	    }
	
}
