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
public class Aluno extends Pessoa{
    
    private float nota1 = -1;
    private float nota2 = -1;
    
    public float getNota1(){
        return nota1;
    }

    /**
     *
     * @param value
     */
    public void setNota1(float value){
        nota1 = value;
    }
    
    
    public float getNota2(){
        return nota2;
    }

    /**
     *
     * @param value
     */
    public void setNota2(float value){
        nota2 = value;
    }
    
    public Aluno(String nome) {
        super(nome);
    }
    public Aluno(String nome, float nota1, float nota2){
        super(nome);
        this.nota1 = nota1;
        this.nota2 = nota2;
    }
    
    @Override
    public String consultarSituacao(){
        if(nota1 == -1 || nota2 == -1){
            return "Desculpe, as notas do(a) aluno(a) " + nome + "não foram adicionadas.";
        }
        return String.format("Nome: %s\nNota1: %.2f\nNota2: %.2f\nMedia: %.2f", nome + " " + sobrenome + " " + ultimoNome, nota1, nota2, (nota1 + nota2) / 2);
    }
    
}
