package com.aos_sgwl.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

//Demonstra ao JPA que essa classe representa uma tabela no banco de dados
@Entity
//Define o nome que sera usado no banco
@Table(name = "item")


public class Item {
    //Define como ID(chave-primaria), que e gerado automaticamente ao se criar uma nova entidade
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //Define uma coluna como nao nula e com maximo de 150 caracteres, para nome.
    @Column(nullable = false,length = 150)
    private String name;
    //Define coluna como nao nula, obrigatoriamente positiva e que sera o preco(tipo double)
    @Positive
    @Column(nullable = false)
    private double preco;
    //Define uma coluna de prioridade, em que sera uma string de tamanho maximo 20
    @Column(length = 20)
    private String prioridade;
    //Define em valor booleano, se o item foi comprado ou nao, nao podendo ser nulo e iniciando como false
    @Column(nullable = false)
    private boolean comprado = false;

    public Item(){}

    public Item(String name, double preco, String prioridade){
        this.name = name;
        this.preco = preco;
        this.prioridade = prioridade;
    }

    //Getters e Setters
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPreco() {
        return preco;
    }
    public String getPrioridade() {
        return prioridade;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString(){
        return "[ id: " + id + " | name: " + name + " | preco: " + preco + " | prioridade: " + prioridade + " ]";
    }
}
