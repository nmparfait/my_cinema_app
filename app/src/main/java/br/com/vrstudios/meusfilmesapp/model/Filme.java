package br.com.vrstudios.meusfilmesapp.model;

import java.io.Serializable;

public class Filme implements Serializable {

    private String titulo;
    private Float preco;
    private Boolean lifeTime;
    private String validade;

    public Filme() {
    }

    public Filme(java.lang.String titulo, Float preco, Boolean lifeTime) {
        this.titulo = titulo;
        this.preco = preco;
        this.lifeTime = lifeTime;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Float getPreco() {
        return preco;
    }
    public void setPreco(Float preco) {
        this.preco = preco;
    }
    public Boolean getLifeTime() {
        return lifeTime;
    }
    public void setLifeTime(Boolean lifeTime) {
        this.lifeTime = lifeTime;
    }
    public String getValidade() {
        if (lifeTime) {
            return "Você pode ver este vídeo sempre que quiser!";
        } else {
            return "Você tem 7 dias para ver este filme!";
        }
    }
    public void setValidade(String validade) {
        this.validade = validade;
    }
}