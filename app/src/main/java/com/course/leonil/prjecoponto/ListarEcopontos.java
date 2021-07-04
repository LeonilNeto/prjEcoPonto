package com.course.leonil.prjecoponto;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.course.leonil.prjecoponto.database.DataBase;
import com.course.leonil.prjecoponto.dominio.Repositorio;
import com.course.leonil.prjecoponto.dominio.entidade.Ecopontos;

public class ListarEcopontos extends AppCompatActivity {

    private ListView listEcoponto;
    private ArrayAdapter<Ecopontos> adpEcopontos;

    private Repositorio repositorio;
    private DataBase dataBase;
    private SQLiteDatabase conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_ecopontos);

        listEcoponto = (ListView)findViewById(R.id.listEcoponto);

        Bundle bundle = getIntent().getExtras();
        int id_bairro = (Integer)bundle.getSerializable(ConsultarBairros.ECOPONTO);

        try {
            dataBase = new DataBase(this);
            conn = dataBase.getReadableDatabase();
            repositorio = new Repositorio(conn);
            adpEcopontos = repositorio.buscarEcoponto(this, id_bairro);
            listEcoponto.setAdapter(adpEcopontos);
        } catch (SQLException ex) {
            Log.e("Error", ex.getMessage());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(conn != null) {
            conn.close();
        }
    }
}
