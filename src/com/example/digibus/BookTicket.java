package com.example.digibus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebViewClient;

public class BookTicket  extends AppCompatActivity{
	private WebView mBook;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_ticket);
	    mBook = (WebView) findViewById(R.id.wv_book_ticket);
		startWebView("http://m.ksrtc.in/mobile/search.do");
	}
	
	
	private void startWebView(String url) {
		// TODO Auto-generated method stub
		mBook.setWebViewClient(new WebViewClient() 
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
                    
                    progressDialog = new ProgressDialog(BookTicket.this);
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
		
		
		
		 mBook.getSettings().setJavaScriptEnabled(true);
		 mBook.loadUrl(url);
	}
	
	@Override
	   
    public void onBackPressed() {
        if(mBook.canGoBack()) {
        	mBook.goBack();
        } else {
           
            super.onBackPressed();
        }
    }

	
}
