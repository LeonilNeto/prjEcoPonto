package com.course.leonil.prjecoponto.dominio.entidade;

/**
 * Created by Leonil on 08/05/2018.
 */

public class Bairro {

    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
