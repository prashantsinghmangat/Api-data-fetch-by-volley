package com.demotxt.myapp.myapplication.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.demotxt.myapp.myapplication.R;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        Logo xyz = new Logo();
        xyz.start();

    }
    private class Logo extends Thread{
        public void run(){
            try{
                sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            Intent intent = new Intent(SplashScreen.this, LoginBmr.class);
            startActivity(intent);
            SplashScreen.this.finish();
        }
    }
}