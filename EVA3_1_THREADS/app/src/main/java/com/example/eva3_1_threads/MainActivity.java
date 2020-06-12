package com.example.eva3_1_threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Simular una actividad que tome mucho tiempo
        //10s
        for (int i =0; i<10; i++){
            //Duerme al hilo principal
            try {
                Thread.sleep(1000);// 1 s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
