
package application;

import java.util.List;
import java.util.Locale;
import model.exception.ValorExcedenteException;
import model.entities.Cargo;
import model.entities.Funcionario;
import model.service.ValidacaoService;
import model.util.ControleFuncionarios;


public class Main {
    
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        
        try {
            //Instanciando Cargos
            Cargo GerenteImediato = new Cargo(1, "Gerente Imediato", 500.00);
            Cargo GerenteGeral = new Cargo(2, "Gerente Geral", 1500.00);
            Cargo DiretorFinanceiro = new Cargo(3, "Diretor Financeiro", 5000.00);
            Cargo DiretorGeral = new Cargo(4, "Diretor Geral", 15000.00);

            //Instanciando funcionarios
            Funcionario func1 = new Funcionario("Devair", GerenteImediato);
            Funcionario func2 = new Funcionario("Devin", GerenteGeral);
            Funcionario func3 = new Funcionario("Igor", DiretorFinanceiro);
            Funcionario func4 = new Funcionario("Werikis", DiretorGeral);
            Funcionario func5 = new Funcionario("Marcio", GerenteImediato);

            //Criando e inserindo Funcionario a uma lista de Funcionarios
            ControleFuncionarios controleFuncionarios = new ControleFuncionarios();
            controleFuncionarios.addFuncionario(func1);
            controleFuncionarios.addFuncionario(func3);
            controleFuncionarios.addFuncionario(func2);
            controleFuncionarios.addFuncionario(func4);
            controleFuncionarios.addFuncionario(func5);

            //list de funionarios ativos
            List<Funcionario> list = controleFuncionarios.getList();

            //Ordenando a list de acordo com sua Autoridade dentro da empresa
            controleFuncionarios.ordenarLista(list);

            //imprimindo list de funcionarios Ordenanda :
            System.out.println("List Funcionarios Ordenanda: ");
            list.forEach(funcionario -> {
                System.out.println(funcionario);
            });
            System.out.println();
                        
            
            //Valor que passará por aprovação 
            Double valorPagamento = 140.00;
            System.out.println("Valor Pagamento: " + String.format("%.2f", valorPagamento));
            System.out.println();

            //Verificando se o Func5(Marcio) poderá aprovar o pagamento
            if (ValidacaoService.verificarAutoridade(func5, valorPagamento) == true) {
                System.out.println(ValidacaoService.pagamentoAprovado(func5));                
            } else {
                System.out.println(ValidacaoService.pagamentoIncompleto(func5));
                System.out.println();
                System.out.println(ValidacaoService.procurarProximoSuperior(list, valorPagamento));
            }
            
        } catch (ValorExcedenteException ex) {
            System.out.println("Valor excedente: " + ex.getMessage());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
    }
    
}
