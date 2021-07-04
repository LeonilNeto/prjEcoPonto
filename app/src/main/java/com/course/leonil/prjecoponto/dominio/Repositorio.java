package com.course.leonil.prjecoponto.dominio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ArrayAdapter;
import com.course.leonil.prjecoponto.dominio.entidade.Bairro;
import com.course.leonil.prjecoponto.dominio.entidade.Ecopontos;

/**
 * Created by Leonil on 08/05/2018.
 */

public class Repositorio {

    private SQLiteDatabase conn;

    public Repositorio(SQLiteDatabase conn) {
        this.conn = conn;
    }

    public ArrayAdapter<Bairro> buscarBairro(Context context) {
        ArrayAdapter<Bairro> adpBairro = new ArrayAdapter<Bairro>(context, android.R.layout.simple_list_item_1);

        Cursor cursor = conn.query("BAIRRO", null, null, null, null, null, "nome");

        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            do{
                Bairro bairro = new Bairro();

                bairro.setId(cursor.getInt(0));
                Log.i("Bairro id", Integer.toString(bairro.getId()));
                bairro.setNome(cursor.getString(1));
                Log.i("Bairro nome: ", bairro.getNome());
                adpBairro.add(bairro);
            } while(cursor.moveToNext());
        }
        return adpBairro;
    }

    public ArrayAdapter<Ecopontos> buscarEcoponto(Context context, int id_bairro) {
        ArrayAdapter<Ecopontos> adpEcoponto = new ArrayAdapter<Ecopontos>(context, android.R.layout.simple_list_item_1);
        String bairro[] = {Integer.toString(id_bairro)};
        Cursor cursor = conn.query("ECOPONTO", null, "id_bairro = ?" , bairro, null, null, "nome");

        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            do{

                Ecopontos ecopontos = new Ecopontos();
                ecopontos.setId(cursor.getInt(0));
                ecopontos.setNome(cursor.getString(1));
                ecopontos.setEndereco(cursor.getString(2));
                ecopontos.setFuncionamento(cursor.getInt(3));
                ecopontos.setAbre(cursor.getString(4));
                ecopontos.setFecha(cursor.getString(5));
                ecopontos.setBairro(cursor.getInt(6));
                adpEcoponto.add(ecopontos);

            } while(cursor.moveToNext());
        }

        return adpEcoponto;
    }

}
