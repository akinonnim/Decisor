package com.mycompany.decisor.model;

public class Tarefa {
    private int idTarefa;
    private String anotacao;
    private int nivelPrioridade;

    public Tarefa(String anotacao, int nivelPrioridade) {
        this.anotacao = anotacao;
        this.nivelPrioridade = nivelPrioridade;
    }

    public Tarefa(int idTarefa, String anotacao, int nivelPrioridade) {
        this.idTarefa = idTarefa;
        this.anotacao = anotacao;
        this.nivelPrioridade = nivelPrioridade;
    }

    public int getIdTarefa() {
        return idTarefa;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public int getNivelPrioridade() {
        return nivelPrioridade;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    public void setNivelPrioridade(int nivelPrioridade) {
        this.nivelPrioridade = nivelPrioridade;
    }
}
