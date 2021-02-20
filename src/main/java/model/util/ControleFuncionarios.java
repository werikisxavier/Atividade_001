
package model.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.entities.Funcionario;


public class ControleFuncionarios {
    
    private final List<Funcionario> funcionariosAtivos;
    
    public ControleFuncionarios(){
        this.funcionariosAtivos = new ArrayList<>();
    };

    public List<Funcionario> getList() {
        return funcionariosAtivos;
    }
   
    public void addFuncionario(Funcionario funcionario){
        funcionariosAtivos.add(funcionario);
    }
    
    public void removeFuncionario(Funcionario funcionario){
       funcionariosAtivos.remove(funcionario);
    }
    
    public void ordenarLista(List<Funcionario> funcionariosAtivos){
        Collections.sort(funcionariosAtivos);
    }
              
    
}
