package model.entities;


public class Funcionario implements Comparable<Funcionario> {

    private String nome;

    private Cargo cargo;

    public Funcionario() {
    }

    public Funcionario(String name, Cargo cargo) {
        this.nome = name;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return nome + ", Cargo: " + cargo.getDescricao() + ", Limite: " + String.format("%.2f", cargo.getLimite());
    }

    @Override
    public int compareTo(Funcionario employee) {
        return this.getCargo().getCargoAutoridade().compareTo(employee.getCargo().getCargoAutoridade());
    }

}
