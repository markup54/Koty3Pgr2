package com.example.kotyinformator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> zdjecia;
    private int indeks;
    public Button dalejButton;
    public Button wsteczButton;
    public ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        przygotujZdjecia();
        dalejButton = findViewById(R.id.button2);
        wsteczButton = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        dalejButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        indeks++;
                        if(indeks>zdjecia.size()-1)
                            indeks =0 ;
                        wyswietlZdjecie(indeks);
                    }
                }
        );
        wsteczButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        indeks --;
                        if(indeks<0)
                            indeks = zdjecia.size()-1;
                        wyswietlZdjecie(indeks);
                    }
                }
        );
    }
    private void wyswietlZdjecie(int i){
        imageView.setImageResource(zdjecia.get(i));
    }
    private void przygotujZdjecia(){
        zdjecia = new ArrayList<>();
        zdjecia.add(R.drawable.kot1);
        zdjecia.add(R.drawable.kot2);
        zdjecia.add(R.drawable.kot3);
        zdjecia.add(R.drawable.kot4);
    }
}