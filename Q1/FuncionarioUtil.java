package Lista.Q1;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FuncionarioUtil {

    public static void main(String[] Args) {

        String nome = "";
        String sobrenome = "";
        double valorHora = 0;
        boolean radar = false;

        int opcao = 0;
        double salarioTotal = 0;
        double salarioMedioTotal = 0;
        int contador = 0;
        int cargaHoraria = 0;

        try (Scanner input = new Scanner(System.in)) {
            List<Funcionario> funcionarios = new LinkedList<Funcionario>();

            do {
                Iterator<Funcionario> It = funcionarios.iterator();

                System.out.println("**************************************************************************");
                System.out.println("* 1- Cadastrar novo funcionário.                                         *");
                System.out.println("* 2- Acrescentar horas trabalhadas a funcionário.                        *");
                System.out.println("* 3- Exibir salário líquido (até o momento) dos funcionários cadastrados.*");
                System.out.println("* 4- Exibir o salário liquido médio de todos os funcionários cadastrados.*");
                System.out.println("* 5- Remover um funcionário.                                             *");
                System.out.println("* 6- Encerrar programa.                                                  *");
                System.out.println("**************************************************************************");

                do {
                    try {
                        opcao = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("entrada inválida, por favor insira um número de 1 a 5!");
                        input.nextLine();
                        radar = true;

                    }
                    radar = false;
                } while (radar);

                switch (opcao) {
                    case 0:
                        break;

                    case 1:
                        System.out.println("Insira o nome:");
                        input.nextLine();
                        nome = input.nextLine().trim().toUpperCase();

                        System.out.println("Insira o sobrenome:");
                        sobrenome = input.nextLine().trim().toUpperCase();

                        do {
                            try {
                                System.out.println("Insira o valor por hora trabalhada:");

                                valorHora = input.nextDouble();
                            } catch (InputMismatchException e) {
                                radar = true;
                                System.out.println("Entrada inválida!");
                                input.nextLine();

                            } // catch
                            if (valorHora != 0)
                                radar = false;
                        } while (radar);

                        Funcionario func = new Funcionario(nome, sobrenome, valorHora);

                        funcionarios.add(func);

                        System.out.println(func);

                        System.out.println("*Funcionário cadastrado*");
                        opcao = 0;
                        break;

                    case 2:
                        if (funcionarios.isEmpty()){
                                System.out.println("Por favor, primeiramente cadastre um funcionário");
                            } else{
                        System.out.println("Insira o primeiro nome do funcionario desejado:");
                        input.nextLine();
                        String nomePesquisa = input.nextLine().trim().toUpperCase();
                        System.out.println("digite o sobrenome do funcionario desejado");
                        String sobrenomePesquisa = input.nextLine().trim().toUpperCase();

                        while (It.hasNext()) {
                            func = It.next();
                           
                            String nomeComparation = func.getNome().trim().toUpperCase();
                            String sobrenomeComparation = func.getSobrenome().trim().toUpperCase();

                            if (nomePesquisa.equals(nomeComparation)
                                    && sobrenomePesquisa.equals(sobrenomeComparation)) {

                                do {
                                    try {
                                        System.out.println("Insira a carga horária que deseja adicionar:");
                                        cargaHoraria = input.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Entrada inválida");
                                        input.nextLine();
                                        radar = true;
                                    }
                                    if (cargaHoraria != 0) {
                                        radar = false;
                                    }
                                } while (radar);
                                func.adicionarCargaHoraria(cargaHoraria);
                                contador++;
                                System.out.println("carga horária adicionada ao " + func);
                                System.out.println(func + " tem " + func.getHorasTrabalhadas() + " horas trabalhadas");
                            } 
                                } //else if
                            } //while
                            if (contador == 0) {
                                System.out.println("não há funcionários com esta combinação de nome e sobrenome!");
                            
                        } //else
                        contador = 0;
                        opcao = 0;

                        break;
                    case 3:
                    if (funcionarios.isEmpty()){
                        System.out.println("Por favor, primeiramente cadastre um funcionário");
                    }
                    else{
                        while (It.hasNext()) {
                            func = It.next();
                            double salarioLiquido = func.getSalarioLiquido();
                            if(salarioLiquido == 0){
                            System.out.println(func + "\n(sem registro de horas trabalhadas!)");
                            
                            }else if (salarioLiquido != 0){
                            System.out.println(func + "\nsalário líquido: " + salarioLiquido + " reais");
                            }
                        }
                    }
                        opcao = 0;
                        break;
                    case 4:
                    if (funcionarios.isEmpty()){
                        System.out.println("Por favor, primeiramente cadastre um funcionário");
                    } else{
                        while (It.hasNext()) {
                            func = It.next();
                            salarioTotal += func.getSalarioLiquido();
                            contador++;
                        }
                        salarioMedioTotal = (salarioTotal / contador);
                        if(salarioMedioTotal != 0){
                        System.out.println("O salário médio de todos funcionários é: " + salarioMedioTotal + " reais");
                       
                        } else {
                            System.out.println("sem registro de horas trabalhadas!");
                        }
                    }
                    salarioTotal = 0;
                    contador= 0;
                    opcao = 0;
                    break;

                    case 5:
                     if (funcionarios.isEmpty()){
                        System.out.println("Por favor, primeiramente cadastre um funcionário");
                        } else{
                            System.out.println("Insira o primeiro nome do funcionario desejado:");
                            input.nextLine();
                            String nomeRemover = input.nextLine().trim().toUpperCase();
                            System.out.println("digite o sobrenome do funcionario desejado");
                            String sobrenomeRemover = input.nextLine().trim().toUpperCase();

                            while (It.hasNext()){
                                func = It.next();

                                String nomeComparar = func.getNome().trim().toUpperCase();
                                String sobrenomeComparar = func.getSobrenome().trim().toUpperCase();

                                if(nomeRemover.equals(nomeComparar) && sobrenomeRemover.equals(sobrenomeComparar)){
                                    funcionarios.remove(func);
                                    contador ++;
                                    System.out.println("funcionário removido com sucesso!");


                                }  


                            } //while
                            
                            if (contador == 0){
                                    System.out.println("não há funcionários com esta combinação de nome e sobrenome!");
                                }

                            contador = 0;
                        }//else
                        opcao = 0;
                        break;
                    case 6:
                        break;

                    default:
                        System.out.println("Opção inválida, digite um número entre 1 e 6!");
                } // switch
            } while (opcao != 6);

            input.close();
        } // try

    } // main

} // class