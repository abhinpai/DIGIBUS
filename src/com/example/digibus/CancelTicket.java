package com.example.digibus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebViewClient;


public class CancelTicket extends AppCompatActivity {
	private WebView mCancel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cancel_ticket);
		mCancel = (WebView) findViewById(R.id.wv_book_ticket);
		startWebView("http://m.ksrtc.in/mobile/preTicketCancellation.do");
	}
	
	
	
	private void startWebView(String url) {
		// TODO Auto-generated method stub
		mCancel.setWebViewClient(new WebViewClient() 
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
                    
                    progressDialog = new ProgressDialog(CancelTicket.this);
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
		
		
		
		mCancel.getSettings().setJavaScriptEnabled(true);
		mCancel.loadUrl(url);
	}
	@Override
	   
    public void onBackPressed() {
        if(mCancel.canGoBack()) {
        	mCancel.goBack();
        } else {
           
            super.onBackPressed();
        }
    }

	
}
