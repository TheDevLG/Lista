package Lista;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FuncionarioUtil{

    public static void main (String []Args) {

        int opcao = 0;
        int salarioTotal = 0;
        int salarioMedioTotal = 0;
        int contador = 0;

        try (Scanner input = new Scanner(System.in)) {
            List<Funcionario> funcionarios = new LinkedList<Funcionario>();
            

            do{
                Iterator<Funcionario> It = funcionarios.iterator();
            System.out.println("**************************************************************************");
            System.out.println("* 1- Cadastrar novo funcionário.                                         *");
            System.out.println("* 2- Acrescentar horas trabalhadas a funcionário.                        *");
            System.out.println("* 3- Exibir salário líquido (até o momento) dos funcionários cadastrados.*");
            System.out.println("* 4- Exibir o salário liquido médio de todos os funcionários cadastrados.*");
            System.out.println("* 5- Encerrar programa.                                                  *");
            System.out.println("**************************************************************************");
            opcao = input.nextInt();

            switch(opcao){
                
                case 1:
                   System.out.println("Insira o nome:");
                    String nome = input.next().trim().toUpperCase();
                    System.out.println("Insira o sobrenome:");
                    String sobrenome = input.next().trim().toUpperCase();
                    System.out.println("Insira o valor por hora trabalhada:");
                    double valorHora = input.nextDouble();

                 Funcionario func = new Funcionario(nome, sobrenome, valorHora);

                   funcionarios.add(func);

                   System.out.println(funcionarios);

                   System.out.println("*Funcionário cadastrado*");
                    break;

                case 2:
                    

                    System.out.println("Insira o primeiro nome do funcionario desejado:");
                    String nomePesquisa = input.next().trim().toUpperCase();
                    System.out.println("digite o sobrenome do funcionario desejado");
                    String sobrenomePesquisa = input.next().trim().toUpperCase();
                    
                    while(It.hasNext()){
                     func = It.next();
                     String nomeComparation = func.getNome();
                     String sobrenomeComparation = func.getSobrenome();

                     if(nomePesquisa.equalsIgnoreCase(nomeComparation) && sobrenomePesquisa.equals(sobrenomeComparation)){
                        System.out.println("Insira a carga horária que deseja adicionar:");
                        int cargaHoraria = input.nextInt();
                        func.adicionarCargaHoraria(cargaHoraria);
                        System.out.println("carga horária adicionada ao " +func);
                        System.out.println(func + " tem " +func.getHorasTrabalhadas() + " horas trabalhadas");
                     } else;
                     System.out.println("não há funcionários com este nome e sobrenome");
                     
                     }

                    break;
                case 3:
                     while(It.hasNext()){
                        func = It.next();
                        double salarioLiquido = func.getSalarioLiquido();
                        System.out.println(func + "\nsalário líquido: " + salarioLiquido +"\n");
                     }
                
                     break;
                case 4:
                     while(It.hasNext()){
                        func = It.next();
                        salarioTotal += func.getSalarioLiquido();
                        contador++;
                     }
                     salarioMedioTotal = (salarioTotal / contador);
                     System.out.println("O salário médio de todos funcionários é :" + salarioMedioTotal);
                }
        }while(opcao != 5);
        }

    }



}