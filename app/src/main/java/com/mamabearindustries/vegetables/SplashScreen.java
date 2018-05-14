package com.mamabearindustries.vegetables;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
      final  VideoView view = (VideoView)findViewById(R.id.videoView);
       final String path = "android.resource://" + getPackageName() + "/" + R.raw.splashpage;
        view.setVideoURI(Uri.parse(path));
        view.start();

        final Handler handler = new Handler();
        final Integer delay = 5000;

        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {

                Intent i = new Intent(SplashScreen.this,Sign_In.class);
                startActivity(i);
            }
        },delay);


    }
}
