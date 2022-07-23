package com.edu.pe.modelo;

public class APIResponse {
    String resultado;
    int res;

    @Override
    public String toString() {
        return "APIResponse{" +
                "resultado='" + resultado + '\'' +
                ", res=" + res +
                '}';
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
