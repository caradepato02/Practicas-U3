package com.example.eva3_10_imagen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView imgVwImagen;
    Bitmap imagen;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            imgVwImagen.setImageBitmap(imagen);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwImagen = findViewById(R.id.imgVwImagen);

        if (imagen != null){
            imgVwImagen.setImageBitmap(imagen);
        }
        Thread tHilo = new Thread(){
            @Override
            public void run() {
                super.run();
                imagen = cargarImagen("https://i0.wp.com/blogthinkbig.com/wp-content/uploads/2017/04/Android.jpg?resize=610%2C225&ssl=1");
                Message msg = handler.obtainMessage();
                handler.sendMessage(msg);
            }
        };
        tHilo.start();
    }

    public Bitmap cargarImagen(String url){
        try {
            InputStream inputStream = (InputStream) new URL(url).getContent();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
