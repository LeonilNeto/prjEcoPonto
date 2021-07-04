package com.course.leonil.prjecoponto.dominio.entidade;

/**
 * Created by Leonil on 08/05/2018.
 */

public class Ecopontos {

    private int id;
    private String nome;
    private String endereco;
    private int funcionamento;
    private String abre;
    private String fecha;
    private int bairro;

    private String diasFuncionamento[] = {"Segunda à Sexta.", "Segunda à Sábado."};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getFuncionamento() {
        return funcionamento;
    }

    public void setFuncionamento(int funcionamento) {
        this.funcionamento = funcionamento;
    }

    public String getAbre() {
        return abre;
    }

    public void setAbre(String abre) {
        this.abre = abre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getBairro() {
        return bairro;
    }

    public void setBairro(int bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "\n"+getNome()+"\nEndereço: "+getEndereco()+"."+"\nFuncionamento: "
                +diasFuncionamento[getFuncionamento()]+
                "\nHorários: "+getAbre()+" às "+getFecha()+".\n";
    }
}
