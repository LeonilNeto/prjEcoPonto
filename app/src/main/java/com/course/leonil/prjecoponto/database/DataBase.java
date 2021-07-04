package com.course.leonil.prjecoponto.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Leonil on 08/05/2018.
 */

public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context) {
        super(context, "BD", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS BAIRRO (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nome VARCHAR(45) NOT NULL)");
            sqLiteDatabase.execSQL("INSERT INTO BAIRRO(nome) VALUES ('Centro')");
            sqLiteDatabase.execSQL("INSERT INTO BAIRRO(nome) VALUES ('Jardim Virgínia')");
            sqLiteDatabase.execSQL("INSERT INTO BAIRRO(nome) VALUES ('Jardim Maringá')");
            sqLiteDatabase.execSQL("INSERT INTO BAIRRO(nome) VALUES ('Parque São Jorge')");
            sqLiteDatabase.execSQL("INSERT INTO BAIRRO(nome) VALUES ('Parque Santana')");

            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ECOPONTO (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nome VARCHAR(45) NOT NULL," +
                    "endereco VARCHAR(100) NOT NULL, funcionamento INTEGER NOT NULL, horarioabre VACHAR(5) NOT NULL, " +
                    "horariofecha VARCHAR(5) NOT NULL, id_bairro INTEGER NOT NULL)");
            sqLiteDatabase.execSQL("INSERT INTO ECOPONTO(nome, endereco, funcionamento, horarioabre, horariofecha, id_bairro) VALUES(" +
                    "'ECOPONTO A', 'RUA A da Silva Santos', 0, '08:00', '17:00', 1)");
            sqLiteDatabase.execSQL("INSERT INTO ECOPONTO(nome, endereco, funcionamento, horarioabre, horariofecha, id_bairro) VALUES(" +
                    "'ECOPONTO A1', 'RUA B Souza Cruz', 1, '08:00', '17:00', 2)");
            sqLiteDatabase.execSQL("INSERT INTO ECOPONTO(nome, endereco, funcionamento, horarioabre, horariofecha, id_bairro) VALUES(" +
                    "'ECOPONTO A2', 'RUA C do Brasil', 0, '08:00', '17:00', 3)");
            sqLiteDatabase.execSQL("INSERT INTO ECOPONTO(nome, endereco, funcionamento, horarioabre, horariofecha, id_bairro) VALUES(" +
                    "'ECOPONTO A3', 'RUA D Lara de Oliveira', 1, '08:00', '17:00', 4)");
            sqLiteDatabase.execSQL("INSERT INTO ECOPONTO(nome, endereco, funcionamento, horarioabre, horariofecha, id_bairro) VALUES(" +
                    "'ECOPONTO A4', 'RUA E das Nações', 1, '08:00', '17:00', 5)");
            sqLiteDatabase.execSQL("INSERT INTO ECOPONTO(nome, endereco, funcionamento, horarioabre, horariofecha, id_bairro) VALUES(" +
                    "'ECOPONTO B', 'RUA B da Costa Fulano', 1, '09:00', '18:00', 1)");
            sqLiteDatabase.execSQL("INSERT INTO ECOPONTO(nome, endereco, funcionamento, horarioabre, horariofecha, id_bairro) VALUES(" +
                    "'ECOPONTO C', 'RUA C da Benjamin Constant', 1, '07:00', '16:00', 1)");
            sqLiteDatabase.execSQL("INSERT INTO ECOPONTO(nome, endereco, funcionamento, horarioabre, horariofecha, id_bairro) VALUES(" +
                    "'ECOPONTO D', 'RUA D das Oliveiras Silva', 1, '07:00', '16:00', 1)");
        } catch (SQLException ex) {
            Log.e("Error", ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
