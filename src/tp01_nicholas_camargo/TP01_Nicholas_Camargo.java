package tp01_nicholas_camargo;

import java.util.Scanner;

/**
 *
 * @author Nicholas
 */
public class TP01_Nicholas_Camargo {

    public static void main(String[] args) {
        String[] nomes = new String[100];
        float[] notasAv1 = new float[100];
        float[] notasAv2 = new float[100];
        int n = 0;
        int i = 0;
        String holder;
        try (Scanner sc = new Scanner(System.in)) {
            while(n != 4){
                System.out.println("Insira a opção:(1-registrar aluno, 2-boletim aluno, 3-notas turma, 4-sair)\t");
                try{
                    holder = sc.nextLine();
                    n = Integer.parseInt(holder);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                switch (n) {
                    case 1:
                        if(i >= 100){
                            System.out.println("Já tem o máximo de alunos inseridos.\t");
                        }else{
                            try{
                                System.out.println("Insira o nome do aluno.\t");
                                nomes[i] = sc.nextLine();
                                System.out.println("Insira a nota da primeira aval.\t");
                                holder = sc.nextLine();
                                notasAv1[i] = Float.parseFloat(holder);
                                System.out.println("Insira a nota da segunda aval.\t");
                                holder = sc.nextLine();
                                notasAv2[i] = Float.parseFloat(holder);
                                i++;
                                System.out.println("Aluno cadastrado com sucesso.");
                            }catch(Exception e){
                                System.out.println("Error: " + e.getMessage());
                            }
                        }   break;
                    case 2:
                        if(i == 0){
                            System.out.println("Nenhum aluno cadastrado.");
                        }else{
                            try{
                                System.out.println("Insira o codigo do aluno desejado.");
                                holder = sc.nextLine();
                                int num = Integer.parseInt(holder);
                                if(num >= i){
                                    System.out.println("Esse codigo de aluno não possui nada inserido.");
                                }else{
                                    float media = (notasAv1[num] + notasAv2[num]) / 2;
                                    String situacao;
                                    if(media < 4){
                                        situacao = "Reprovado";
                                    }else if(media < 7){
                                        situacao = "Prova Final";
                                    }else{
                                        situacao = "Aprovado";
                                    }
                                    System.out.printf("Nome do aluno: %s\nNota da AV1: %.2f"
                                            + "\nNota da AV2: %.2f\nMédia final: %.2f"
                                            + "\nSituação: %s\n"
                                            , nomes[num],notasAv1[num], notasAv2[num], media, situacao);
                                }
                            }catch(Exception e){
                                System.out.println("Exception found: " + e.getMessage());
                            }
                        }   break;
                    case 3:
                        if(i == 0){
                            System.out.println("Nenhum aluno cadastrado.");
                        }else{
                            for(int j = 0; j < i; j++){
                                float media = (notasAv1[j] + notasAv2[j]) / 2;
                                String situacao;
                                if(media < 4){
                                    situacao = "Reprovado";
                                }else if(media < 7){
                                    situacao = "Prova Final";
                                }else{
                                    situacao = "Aprovado";
                                }
                                System.out.printf("Nome do aluno: %s\nNota da AV1: %.2f"
                                        + "\nNota da AV2: %.2f\nMédia final: %.2f"
                                        + "\nSituação: %s\n"
                                        , nomes[j],notasAv1[j], notasAv2[j], media, situacao);
                            }
                        }   break;
                    case 4:
                        System.out.println("Saindo do programa.");
                        break;
                    default:
                        System.out.println("Numero digitado não reconhecido, favor digitar novamente.");
                        break;
                }
            }
        }
    }
    
}
