package com.db.desafiosicredi.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvNumber;


public class ContaDTO {

    @CsvBindByName
    private String agencia;

    @CsvBindByName
    private String conta;

    @CsvBindByName
    @CsvNumber(value = ",", writeFormatEqualsReadFormat = false)
    private double saldo;

    @CsvBindByName
    private String status;

    @CsvBindByName
    private boolean resultado;

    public String getAgencia() {
        return agencia;
    }

    public String getConta() {
        return conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getStatus() {
        return status;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "ContaModel{" +
                "agencia='" + agencia + '\'' +
                ", conta='" + conta + '\'' +
                ", saldo=" + saldo +
                ", status='" + status + '\'' +
                ", resultado=" + resultado +
                '}';
    }
}
