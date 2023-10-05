package PooList04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        // Adicionar alguns funcionários à lista
        funcionarios.add(new Gerente(5650.0, "Maria Helena", "admin", "123456"));
        funcionarios.add(new Telefonista(2500.0, "Tauane Rafaela", "33456"));
        funcionarios.add(new Secretaria(3000.0, "Tiana Raquel", 101));
        funcionarios.add(new Estoquista(3000.0, "Claudemir", "Júnior", "123456"));

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar funcionário");
            System.out.println("2. Excluir funcionário");
            System.out.println("3. Editar funcionário");
            System.out.println("4. Mostrar lista de funcionários");
            System.out.println("5. Sair");

            int escolha = input.nextInt();
            
            input.nextLine(); // Usar a nova linha

            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome do novo funcionário: ");
                    String nome = input.nextLine();

                    System.out.print("Digite o Salário do novo Funcionário: ");
                    double salario = input.nextDouble();
                    
                    
                    input.nextLine(); // Consumir a nova linha
                    

                    // Adicionar novo Funcionário:
                    Funcionario novoFuncionario = new Gerente(salario, nome, "", "");
                    funcionarios.add(novoFuncionario);
                    break;
                case 2:
                    // Aqui o procedimento de remover o funcionário
                    System.out.println("Digite o índice do funcionário a ser removido: ");
                    int indiceRemover = input.nextInt();
                    
                    
                    input.nextLine(); // Consumir a nova linha
                    

                    if (indiceRemover >= 0 && indiceRemover < funcionarios.size()) {
                        funcionarios.remove(indiceRemover);
                    } else {
                        System.out.println("Índice inválido. Nenhum funcionário foi removido.");
                    }
                    break;
                case 3:
                    // Vamos receber aqui o índice para editarmos o funcionário
                    System.out.println("Digite o índice do funcionário a ser editado: ");
                    int indiceEditar = input.nextInt();
                    input.nextLine(); // Consumir a nova linha

                    if (indiceEditar >= 0 && indiceEditar < funcionarios.size()) {
                        // Pegamos as informações atualizadas do usuário.
                        System.out.print("Digite o novo nome: ");
                        String novoNome = input.nextLine();

                        System.out.print("Digite o novo salário: ");
                        double novoSalario = input.nextDouble();
                        input.nextLine(); // Consumir a nova linha

                        // Atualizar o funcionário na lista.
                        Funcionario funcionario = funcionarios.get(indiceEditar);
                        funcionario.setNome(novoNome);
                        funcionario.setSalario(novoSalario);
                    } else {
                        System.out.println("Índice inválido. Nenhum funcionário foi editado.");
                    }
                    break;
                case 4:
                    // Exiba os funcionários na lista
                    System.out.println("Lista de Funcionários:");
                    for (Funcionario funcionario : funcionarios) {
                        System.out.println("Nome: " + funcionario.getNome() + ", Salário: " + funcionario.getSalario());
                        if (funcionario instanceof Secretaria) {
                            Secretaria secretaria = (Secretaria) funcionario;
                            System.out.println("Ramal: " + secretaria.getNumeroRamal());
                        }
                        if (funcionario instanceof Gerente) {
                            Gerente gerente = (Gerente) funcionario;
                            System.out.println("Login: " + gerente.getLogin() + ", Senha: " + gerente.getSenha());
                        }
                        if (funcionario instanceof Telefonista) {
                            Telefonista telefonista = (Telefonista) funcionario;
                            System.out.println("Código de Estação: " + telefonista.getCodigoEstacao());
                        }
                        if (funcionario instanceof Estoquista) {
                            Estoquista estoquista = (Estoquista) funcionario;
                            System.out.println("Lgin: " + estoquista.getLogin() + ", Senha: " + estoquista.getSenha());
                        }
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

        

