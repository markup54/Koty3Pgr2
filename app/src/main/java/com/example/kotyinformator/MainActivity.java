package com.example.kotyinformator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> zdjecia;
    private int indeks;
    public Button dalejButton;
    public Button wsteczButton;
    public ImageView imageView;
    public EditText editText;
    public Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        przygotujZdjecia();
        dalejButton = findViewById(R.id.button2);
        wsteczButton = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editNumber);
        aSwitch = findViewById(R.id.switch1);

        editText.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        try {
                            indeks = Integer.parseInt(s.toString());

                            if (indeks >= 0 && indeks < zdjecia.size())
                                imageView.setImageResource(zdjecia.get(indeks - 1));
                        } catch (Exception ignore) {

                        }
                    }
                }
        );
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
        aSwitch.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked)
                        {
                            //zmienic tlo
                        }
                        else {
                            //zmienic tlo
                        }
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