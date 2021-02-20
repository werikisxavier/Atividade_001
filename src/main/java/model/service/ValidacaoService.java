package model.service;

import java.util.List;
import model.exception.ValorExcedenteException;
import model.entities.Funcionario;

public abstract class ValidacaoService {

    public static Boolean verificarAutoridade(Funcionario funcionario, Double valorPagamento) {
        return funcionario.getCargo().getLimite() >= valorPagamento;
    }

    public static String procurarProximoSuperior(List<Funcionario> funcionariosAtivos, Double valorPagamento) throws ValorExcedenteException {
        for (Funcionario funcionario : funcionariosAtivos) {
            if (verificarAutoridade(funcionario, valorPagamento) == true) {
                return pagamentoAprovadoPeloSuperior(funcionario);
            }
        }
        throw new ValorExcedenteException("Nenhum superior possui limite suficiente para aprovar esse pagamento!");
    }

    public static String pagamentoAprovado(Funcionario funcionario) {
        return "O pagamento poderá ser aprovado pelo Funcionário: " + funcionario.getNome();
    }

    public static String pagamentoAprovadoPeloSuperior(Funcionario funcionario) {
        return "O pagamento poderá ser aprovado pelo Superior: " + funcionario.getNome();
    }

    public static String pagamentoIncompleto(Funcionario funcionario) {
        return "O pagamento não poderá ser aprovado pelo Funcionário: " + funcionario.getNome();
    }


}
