
import java.util.Scanner;

public class ViewCadVeiculo {

    private static ServiceVeiculo service = new ServiceVeiculo();
    static Scanner input = new Scanner(System.in);

    public static void limparTela() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void aguardarEnter() {
        System.out.print("Pressione Enter para continuar...");
        input.nextLine();
    }

    public static void registrarVeiculo() {
        limparTela();
        Veiculo novoVeiculo = null;
        System.out.println("======ADICIONANDO UM NOVO VEÍCULO======");
        int typevehicle;
        do {
            typevehicle = inputNumerico("Qual é o tipo do veículo: (1) Carro - (2) - Moto  ");
            if (typevehicle == 1) {
                novoVeiculo = new Carro();
            } else if (typevehicle == 2) {
                novoVeiculo = new Moto();
            } else {
                System.out.println("Opção Inválida!");
            }
        } while (novoVeiculo == null);

        System.out.print("Informe a marca: ");
        String marca = input.nextLine();
        novoVeiculo.setMarca(marca);

        System.out.print("Informe o modelo: ");
        String modelo = input.nextLine();
        novoVeiculo.setModelo(modelo);

        System.out.print("Informe a placa: ");
        String placa = input.nextLine();
        novoVeiculo.setPlaca(placa);

        System.out.print("Informe o ano do veiculo: ");
        int ano = input.nextInt();
        novoVeiculo.setAno(ano);

        if (typevehicle == 1) {
            int numeroPortas = inputNumerico("Informe o número de portas: ");
            novoVeiculo.setNumeroPortas(numeroPortas);
        } else if (typevehicle == 2) {
            int partidaEletrica = inputNumerico("A moto tem partida elétrica? (1) Sim - (2) Não");
            if (partidaEletrica == 1) {
                novoVeiculo.setPartidaEletrica(true);
            } else if (partidaEletrica == 2) {
                novoVeiculo.setPartidaEletrica(false);
            } else {
                System.out.println("Opção inválida. Por favor, informe 1 ou 2.");
            }
        }
        
        try {
            service.save(novoVeiculo);
            System.out.println("Veiculo adicionado com Sucesso!");
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        aguardarEnter();
    }

    /*public void listar() {
        if (Veiculo.isEmpty()) {
            System.out.println("A frota está vazia.");
        } else {
            System.out.println("Veículos da frota:");
            for (Veiculo veiculo : Veiculo) {
                System.out.println(veiculo.toString());
            }
        }
    }*/

    public static void pesquisarPorPlaca(){
        limparTela();
        System.out.print("Digite a placa");
        String placaPesquisada = input.nextLine();
    }

    private static int inputNumerico(String mensagem) {
        int valor = 0;
        boolean entradaValida = false;
        System.out.print(mensagem);
        do {
            String valorStr = input.nextLine();
            try {
                valor = Integer.parseInt(valorStr);
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("ERRO. Valor informado deve ser um número Inteiro");
            }
        } while (!entradaValida);
        return valor;
    }

    public static void main(String[] args) {
        String menu = """
                SISTEMA DE GERENCIAMENTO DE FROTAS
                Menu de Opções:
                1 - Cadastrar novo Veículo;
                2 - Listar todos Veículos cadastrados;
                3 - Pesquisar Veículo pela placa;
                4 - Remover Veículo;
                0 - Sair;
                Digite a opção desejada:""" + " ";
        int opcao;
        do {
            limparTela();
            opcao = inputNumerico(menu);
            switch (opcao) {
                case 0:
                    limparTela();
                    System.out.println("VOLTE SEMPRE!!!");
                    break;
                case 1:
                    limparTela();
                    registrarVeiculo();
                    break;
                case 2:
                    limparTela();

                    break;
                case 3:
                    limparTela();

                    break;
                case 4:
                    limparTela();

                    break;
                default:
                    limparTela();
                    System.out.println("Opção Inválida!!!");
                    aguardarEnter();
                    break;
            }
        } while (opcao != 0);
    }
}
