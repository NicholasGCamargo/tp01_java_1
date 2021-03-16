/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp01_nicholas_camargo.custom_exceptions;

/**
 *
 * @author Nicholas
 */
public class NomeVazioException extends Exception {
    public NomeVazioException(String msg){
        super(msg);
    }
    
    public NomeVazioException(){
        super("Nome vazio, não criando Pessoa.");
    }
}
