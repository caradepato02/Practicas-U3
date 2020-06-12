package com.example.eva3_3_runnable;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Runnable rRun = new Runnable() {
            @Override
            public void run() {

                //Simular una actividad que tome mucho tiempo
                //10s
                for (int i = 0; i < 10; i++) {
                    //Duerme al hilo principal
                    try {
                        Thread.sleep(1000);// 1 s
                        Log.wtf("tHilo1", i + "");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        Thread tHilo = new Thread(rRun);
        tHilo.start();
    }
}
