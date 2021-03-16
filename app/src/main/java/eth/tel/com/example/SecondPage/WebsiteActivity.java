package eth.tel.com.example.SecondPage;

/**
 * @author t.me/ag3m3chu
 * @version 1.0 16/03/2021
 * @since 1.0
 */

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import eth.tel.com.example.R;

public class WebsiteActivity extends AppCompatActivity {

    WebView etWebs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        etWebs = findViewById(R.id.etWebs);

        WebSettings webSettings = etWebs.getSettings();
        webSettings.setJavaScriptEnabled(true);

        ConnectivityManager connectivityManager = (ConnectivityManager)
        getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo == null || !networkInfo.isConnected() || !networkInfo.isAvailable()){

            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.connection_failed);
            dialog.setCanceledOnTouchOutside(false);
            dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_Dialog;

            Button tryAgain = dialog.findViewById(R.id.tryAgain);

            tryAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    restartApp();
                }
            });
            dialog.show();
        } else {

            etWebs.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            etWebs.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            etWebs.getSettings().setAppCacheEnabled(true);
            etWebs.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            webSettings.setDomStorageEnabled(true);
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            webSettings.setUseWideViewPort(true);
            webSettings.setSavePassword(true);
            webSettings.setSaveFormData(true);
            webSettings.setEnableSmoothTransition(true);

            etWebs.loadUrl("https://www.ethiotelecom.et");
        }
    }

    public void refresh(View v){
        etWebs.reload();
    }
    public void goBack(View v){
        if (etWebs.canGoBack()){
            etWebs.goBack();
        }
    }
    public void goForward(View v){
        if (etWebs.canGoForward()){
            etWebs.goForward();
        }
    }
    public void restartApp () {
        Intent dark = new Intent(getApplicationContext(),WebsiteActivity.class);
        startActivity(dark);
        recreate();
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}