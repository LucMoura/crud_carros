package com.spring.crud_carros.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class ProdutoDTO {
    @NotEmpty(message = "O modelo é obrigatório")
    private String modelo;

    @NotEmpty(message = "A marca é obrigatória")
    private String marca;

    @NotEmpty(message = "O ano é obrigatório")
    private String ano;

    @NotNull(message = "O preço é obrigatório")
    @Min(value = 0, message = "O preço deve ser positivo")
    private double preco;

    @Size(min = 30, message = "A descrição deve ter no minimo 30 caracteres")
    @Size(max = 2000, message = "A descrição deve ter no máximo 2000 caracteres")
    private String descricao;

    @NotEmpty(message = "O motor é obrigatório")
    private String motor;

    @NotNull(message = "A quantidade é obrigatória")
    @Min(value = 1, message = "A quantidade deve ser maior que 0")
    private int quantidade;

    public @NotEmpty(message = "O ano é obrigatório") String getAno() {
        return ano;
    }

    public void setAno(@NotEmpty(message = "O ano é obrigatório") String ano) {
        this.ano = ano;
    }

    public @Size(min = 30, message = "A descrição deve ter no minimo 30 caracteres") @Size(max = 2000, message = "A descrição deve ter no máximo 2000 caracteres") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@Size(min = 30, message = "A descrição deve ter no minimo 30 caracteres") @Size(max = 2000, message = "A descrição deve ter no máximo 2000 caracteres") String descricao) {
        this.descricao = descricao;
    }

    public @NotEmpty(message = "A marca é obrigatória") String getMarca() {
        return marca;
    }

    public void setMarca(@NotEmpty(message = "A marca é obrigatória") String marca) {
        this.marca = marca;
    }

    public @NotEmpty(message = "O modelo é obrigatório") String getModelo() {
        return modelo;
    }

    public void setModelo(@NotEmpty(message = "O modelo é obrigatório") String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public @NotEmpty(message = "O motor é obrigatório") String getMotor() {
        return motor;
    }

    public void setMotor(@NotEmpty(message = "O motor é obrigatório") String motor) {
        this.motor = motor;
    }
}
