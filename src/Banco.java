import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<ContaBancaria> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void cadastrarConta(ContaBancaria conta) {
        contas.add(conta);
        System.out.println("Conta cadastrada com sucesso!");
    }

    public ContaBancaria buscarConta(String nome) {
        for (ContaBancaria conta : contas) {
            if (conta.getCliente().getNome().equalsIgnoreCase(nome)) {
                return conta;
            }
        }
        return null;
    }

    public void alterarDadosCadastrais(String nome, String novoEndereco, String novoTelefone) {
        ContaBancaria conta = buscarConta(nome);
        if (conta != null) {
            conta.getCliente().setEndereco(novoEndereco);
            conta.getCliente().setTelefone(novoTelefone);
            System.out.println("Dados cadastrais atualizados com sucesso!");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
}
