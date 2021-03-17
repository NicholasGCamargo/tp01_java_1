/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp01_nicholas_camargo.classes;

/**
 *
 * @author Nicholas
 */
public class Professor extends Pessoa{
    private String disciplina;
    
    public void setDisciplina(String value){
        disciplina = value;
    }
    
    public String getDisciplina(){
        return disciplina;
    }
    
    public Professor(String nome) {
        super(nome);
        disciplina = "Sem mestrar aulas atualmente";
    }
    public Professor(String nome, String disciplina){
        super(nome);
        this.disciplina = disciplina;
    }
    
    @Override
    public String consultarSituacao(){
        return String.format("Nome: %s\nDiscplina Atual: %s", nome + " " + sobrenome + " " + ultimoNome, disciplina);
    }
}
