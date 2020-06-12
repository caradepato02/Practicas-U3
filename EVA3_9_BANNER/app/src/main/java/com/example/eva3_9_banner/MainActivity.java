package com.example.eva3_9_banner;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imgVwBanner;
    Handler miHandler = new Handler();
    SeekBar sBarVelocidad;
    TextView txtVwVelocidad;
    int velocidad = 100;
    int imagenes[] = {R.drawable.f1, R.drawable.f2, R.drawable.f3};
    int indice = 0;

    Runnable backG = new Runnable() {
        @Override
        public void run() {
            while (true) {

                try {
                    Thread.sleep(velocidad);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                miHandler.post(foreG);
            }
        }
    };

    Runnable foreG = new Runnable() {
        @Override
        public void run() {
            velocidad = sBarVelocidad.getProgress();
            txtVwVelocidad.setText(String.valueOf(velocidad));
            imgVwBanner.setImageResource(imagenes[indice]);
            if (indice == 2) {
                indice = 0;
            } else {
                indice++;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwBanner = findViewById(R.id.imgVwBanner);
        sBarVelocidad = findViewById(R.id.sBarVelocidad);
        txtVwVelocidad = findViewById(R.id.txtVwVelocidad);
        txtVwVelocidad.setText(String.valueOf(velocidad));
        Thread tHilo = new Thread(backG);
        tHilo.start();
    }
}
