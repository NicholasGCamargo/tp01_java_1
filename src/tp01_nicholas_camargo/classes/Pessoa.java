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
public class Pessoa {
    protected String nome;
    protected String sobrenome;
    protected String ultimoNome;
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String value){
        nome = value;
    }
        
    public String getSobrenome(){
        return sobrenome;
    }
    
    public void setSobrenome(String value){
        sobrenome = value;
    }
        
    public String getUltimoNome(){
        return ultimoNome;
    }
    
    public void setUltimoNome(String value){
        ultimoNome = value;
    }
    
    public Pessoa(String nomeCompleto){
        try{
            
        String[] holder = nomeCompleto.split(" ");
        nome = holder[0];
        sobrenome = holder[1];
        ultimoNome = holder[2];
        /*
        Mesma funcionalidade do split utilizando indexOf e substring
        
        int primeiroI = nomeCompleto.indexOf(" ");
        nome = nomeCompleto.substring(0, primeiroI);
        
        int segundoI = nomeCompleto.indexOf(" ", primeiroI + 1);
        sobrenome = nomeCompleto.substring(primeiroI, segundoI);
        
        ultimoNome = nomeCompleto.substring(segundoI);
        */        
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Pessoa não criada, erro:");
            System.out.println(e.getMessage());
            System.out.println("Dando nome genérico a esta pessoa");
            nome = "João";
            sobrenome = "da";
            ultimoNome = "Silva";
        }
    }
    
    public String consultarSituacao(){
        return "Nome: " + nome;
    } 
}
