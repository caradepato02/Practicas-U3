package com.example.eva3_8_handler_runnables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVwDatos;
    Handler miHandler = new Handler();
    int i;
    Runnable backGroundRun = new Runnable() {
        @Override
        public void run() {

            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                miHandler.post(foreGroundRun);
                Log.wtf("MiHilo", i +"");
                i++;
            }
        }
    };

    Runnable foreGroundRun = new Runnable() {
        @Override
        public void run() {
            txtVwDatos.append("Valor i = " + i + "\n");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread tHilo = new Thread(backGroundRun);
        tHilo.start();
    }
}
