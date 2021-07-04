package com.course.leonil.prjecoponto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imgBtnBuscar = (ImageButton)findViewById(R.id.imgBtnBuscar);
        ImageButton imgBtnInfo = (ImageButton)findViewById(R.id.imgBtnInfo);

        imgBtnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it = new Intent(MainActivity.this, ConsultarBairros.class);
                startActivity(it);
            }
        });

        imgBtnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it = new Intent(MainActivity.this, Informacoes.class);
                startActivity(it);
            }
        });
    }
}
