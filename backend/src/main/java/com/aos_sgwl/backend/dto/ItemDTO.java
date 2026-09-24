package com.aos_sgwl.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

//@Schema documenta dentro da interface swagger
@Schema(description = "Item data transfer object")
public class ItemDTO {

    // READ_ONLY fala para o swagger que o cliente nao envia o ID, apenas recebe
    @Schema(description = "Unique identifier of the Item", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    
    // @NotBlank impede que o campo seja vazio ou tenha so espacos
    // @Size limita os tamanhos minimo e maximo do campo
    @NotBlank(message = "Description is required")
    @Size(min = 2, max = 150, message = "Name must be 150 chacacters")
    @Schema(description = "Short description of the Item", example = "hot-wheels")
    private String name;

    // @Positive faz com que o valor seja maior que 0
    @Positive
    @NotBlank(message = "Description is required")
    @Schema(description = "Price of the product", example = "999.99")
    private double preco;

    @Schema(description = "Prioridade do item", example = "média")
    private String prioridade;

    // Construtor é usado pelo ProductMapper para montar o DTO a partir da entidade
    public ItemDTO(Long id, String name, double preco, String prioridade){
        this.id = id;
        this.name = name;
        this.preco = preco;
        this.prioridade = prioridade;
    }

    public Long getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public double getPreco() {
        return preco;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setId(Long id) {
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


}