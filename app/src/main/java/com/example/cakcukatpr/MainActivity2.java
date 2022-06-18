package com.example.cakcukatpr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText input;
    Button go;
    WebView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        input=(EditText) findViewById(R.id.editText1);
        go=(Button) findViewById(R.id.button);
        v=(WebView) findViewById(R.id.webview1);

        v.setWebViewClient(new WebViewClient());
        WebSettings wb= v.getSettings();
        wb.setJavaScriptEnabled(true);

        v.setVisibility(View.INVISIBLE);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.getText().toString().length()==0){
                    Toast.makeText(MainActivity2.this, "Enter the url", Toast.LENGTH_LONG).show();
                    if(v.getVisibility()==View.VISIBLE){
                        v.setVisibility(View.INVISIBLE);
                    }
                }
                else{
                    v.setVisibility(View.VISIBLE);
                    String url=input.getText().toString();
                    if(url.contains("https://")|| url.contains("http://")){
                      v.loadUrl(url);
                    }
                    else{
                        v.loadUrl("https://"+url);
                    }



                }
            }
        });


    }
}