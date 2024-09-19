import java.util.Scanner;

public class AplicacaoBancaria {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu de Opções:");
            System.out.println("1. Cadastrar");
            System.out.println("2. Sacar");
            System.out.println("3. Depositar");
            System.out.println("4. Extrato");
            System.out.println("5. Alterar Informações Cadastrais");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Endereço do cliente: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Telefone do cliente: ");
                    String telefone = scanner.nextLine();
                    Cliente cliente = new Cliente(nome, endereco, telefone);
                    ContaBancaria conta = new ContaBancaria(cliente);
                    banco.cadastrarConta(conta);
                    break;

                case 2:
                    System.out.print("Nome do cliente para saque: ");
                    nome = scanner.nextLine();
                    conta = banco.buscarConta(nome);
                    if (conta != null) {
                        System.out.print("Valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        conta.sacar(valorSaque);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Nome do cliente para depósito: ");
                    nome = scanner.nextLine();
                    conta = banco.buscarConta(nome);
                    if (conta != null) {
                        System.out.print("Valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Nome do cliente para extrato: ");
                    nome = scanner.nextLine();
                    conta = banco.buscarConta(nome);
                    if (conta != null) {
                        conta.exibirExtrato();
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 5:
                    System.out.print("Nome do cliente para alterar dados: ");
                    nome = scanner.nextLine();
                    System.out.print("Novo endereço: ");
                    String novoEndereco = scanner.nextLine();
                    System.out.print("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    banco.alterarDadosCadastrais(nome, novoEndereco, novoTelefone);
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}
