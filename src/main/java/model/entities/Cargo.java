
package model.entities;


public class Cargo {
    private String descricao;
    private Double limite;
    private final Integer cargoAutoridade;

    public Cargo (Integer cargoAutoridade, String descricao, Double limite) {
        this.cargoAutoridade=cargoAutoridade;
        this.descricao = descricao;
        this.limite = limite;
    }

    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Double getLimite() {
        return limite;
    }


    public void setLimite(Double limite) {
        this.limite = limite;
    }


    public Integer getCargoAutoridade() {
        return cargoAutoridade;
    }
    
    
}
