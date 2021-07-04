package com.course.leonil.prjecoponto;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.course.leonil.prjecoponto.database.DataBase;
import com.course.leonil.prjecoponto.dominio.Repositorio;
import com.course.leonil.prjecoponto.dominio.entidade.Bairro;

public class ConsultarBairros extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listViewBairros;
    private ArrayAdapter<Bairro> adpBairro;
    private Repositorio repositorio;
    private DataBase dataBase;
    private SQLiteDatabase conn;

    public static final String ECOPONTO = "ECOPONTO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_bairros);

        listViewBairros = (ListView)findViewById(R.id.listViewBairros);
        listViewBairros.setOnItemClickListener(this);

        try{
            dataBase = new DataBase(this);
            conn = dataBase.getReadableDatabase();
            repositorio = new Repositorio(conn);
            adpBairro = repositorio.buscarBairro(this);
            listViewBairros.setAdapter(adpBairro);
        } catch (SQLException ex) {
            Log.e("Error", ex.getMessage());
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Bairro bairro = adpBairro.getItem(i);

        Intent it = new Intent(ConsultarBairros.this, ListarEcopontos.class);
        it.putExtra(ECOPONTO, bairro.getId());
        startActivity(it);
    }
}
