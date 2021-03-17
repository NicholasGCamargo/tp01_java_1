package tp01_nicholas_camargo;

import java.util.Scanner;
import tp01_nicholas_camargo.classes.*;
import tp01_nicholas_camargo.custom_exceptions.NomeVazioException;

/**
 *
 * @author Nicholas
 */
public class TP01_Nicholas_Camargo {
    
    private static final Pessoa[] pessoas = new Pessoa[100];
    private static int i = 0;
    
    public static void main(String[] args) {
        try{ 
            Scanner sc;
            sc = new Scanner(System.in);
            String holder;
            int value;
            
            while(true){
                if(i >= 100){
                    System.out.println("Vetor de pessoas cheio, unicas opções possiveis são a 3 e 4;");
                }
                System.out.println("Qual opção você deseja? (1 - Cadastro de professor, 2- Cadastro de aluno, 3 - Situação de docente, 4 - Sair)");

                holder = sc.nextLine();
                value = Integer.parseInt(holder);
                switch (value) {
                    case 1:
                        try{
                            cadastrarProfessor(sc);
                            break;
                        }catch(NomeVazioException e){
                            System.out.println(e.getMessage());
                            break;
                        }
                    case 2:
                        try{
                            cadastrarAluno(sc);
                            break;
                        }catch(NomeVazioException e){
                            System.out.println(e.getMessage());
                            break;
                        }
                    case 3:
                        situacaoDocente(sc);
                                break;
                    case 4:
                        return;
                    default:
                        System.out.println("Nenhum dos numeros digitados, favor digitar novamente");
                        break;
                }
            }
            
        }catch(NumberFormatException e){
            System.out.println("Erro, nenhum numero inserido. Terminando a execução.");
            return;
        }
       
        
    }

    private static void cadastrarProfessor(Scanner sc) throws NomeVazioException{
        if(i >= 100){
            System.out.println("O numero máximo de Pessoas já foi atingido, tente outra opção");
            return;
        }
        
        System.out.println("Digite o nome completo do professor");
        String nome = sc.nextLine();
        if(nome.equals("")){
            throw new NomeVazioException("Nome vazio, não criando professor.");
        }
        System.out.println("Se você desejar dar uma discplina, digite agora, se não, apenas aperte enter");
        String disciplina = sc.nextLine();
        
        if(disciplina.equals("")){
            pessoas[i] = new Professor(nome);
            i++;
        }else{
            pessoas[i] = new Professor(nome, disciplina);
            i++;
            System.out.println("Professor inserido na posição: " + i);
        }
    }

    private static void cadastrarAluno(Scanner sc) throws NomeVazioException {
        if(i >= 100){
            System.out.println("O numero máximo de Pessoas já foi atingido, tente outra opção");
            return;
        }
        
        System.out.println("Digite o nome completo do Aluno");
        String nome = sc.nextLine();
        if(nome.equals("")){
            throw new NomeVazioException("Nome vazio, não criando aluno.");
        }
        System.out.println("Se você desejar dar as notas, digite agora, se não, apenas aperte enter duas vezes");
        String nota1 = sc.nextLine();
        String nota2 = sc.nextLine();
        
        if(nota1.equals("") || nota2.equals("")){
            pessoas[i] = new Aluno(nome);
            i++;
        }else{
            try{
                int valNota1 = Integer.parseInt(nota1);
                int valNota2 = Integer.parseInt(nota2);
                pessoas[i] = new Aluno(nome, valNota1, valNota2);
                i++;
                System.out.println("Aluno inserido na posição: " + i);
            }catch(NumberFormatException e){
                System.out.println("Erro ao criar aluno com notas.");
                System.out.println(e.getMessage());
            }finally{
                System.out.println("Saindo sem criar aluno.");
                return;
            }
        }
    }

    private static void situacaoDocente(Scanner sc) {
        System.out.println("Digite o numero da posição da pessoa desejada.");
        try{
            String holder = sc.nextLine();
            int num = Integer.parseInt(holder);
            System.out.println(pessoas[num - 1].consultarSituacao());
        }catch(Exception e){
            System.out.println("Insira o numero corretamente, numeros acima de 100, abaixo de 1 ou caracteres não são aceitos.");
        }
    }
    
}
