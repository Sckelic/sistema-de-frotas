
import java.util.Scanner;

public class ViewCadVeiculo {

    private static ServiceVeiculo service = new ServiceVeiculo();
    static Scanner input = new Scanner(System.in);

    //#region Helpers
    public static void limparTela() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void aguardarEnter() {
        System.out.print("Pressione Enter para continuar...");
        input.nextLine();
    }

    private static int inputNumerico(String mensagem, String campo) {
        int valor = 0;
        boolean entradaValida = false;
        System.out.print(mensagem);
        do {
            String valorStr = input.nextLine();
            try {
                valor = Integer.parseInt(valorStr);
                entradaValida = true;
            } catch (Exception e) {
                System.out.printf("ERRO. Valor informado no campo %s deve ser um número inteiro: ", campo);
            }
        } while (!entradaValida);
        return valor;
    }
    //#endregion

    private static void registrarVeiculo() {
        limparTela();
        Veiculo novoVeiculo = null;
        System.out.println("======ADICIONANDO UM NOVO VEÍCULO======");
        int typevehicle;
        do {
            typevehicle = inputNumerico("Qual é o tipo do veículo (1) Carro - (2) - Moto:  ", "Tipo Veículo");

            while (typevehicle != 1 && typevehicle != 2) {
                typevehicle = inputNumerico("Opção Inválida! Digite apenas (1) ou (2): ", "Tipo Veículo");
            }

            if (typevehicle == 1) {
                novoVeiculo = new Carro();
            } else if (typevehicle == 2) {
                novoVeiculo = new Moto();
            }

        } while (novoVeiculo == null);

        limparTela();
        System.out.print("Informe a marca: ");
        String marca = input.nextLine();
        novoVeiculo.setMarca(marca);

        System.out.print("Informe o modelo: ");
        String modelo = input.nextLine();
        novoVeiculo.setModelo(modelo);

        System.out.print("Informe a placa: ");
        String placa = input.nextLine();
        novoVeiculo.setPlaca(placa);

        int ano = inputNumerico("Informe o ano do veiculo: ", "Ano");
        novoVeiculo.setAno(ano);

        if (novoVeiculo instanceof Carro) {
            int numeroPortas = inputNumerico("Informe o número de portas: ", "N. Portas");
            ((Carro) novoVeiculo).setNumeroPortas(numeroPortas);
        } else if (novoVeiculo instanceof Moto) {
            int partidaEletrica = inputNumerico("A moto tem partida elétrica? (1) Sim - (2) Não: ", "Part. Elétrica");
            while (partidaEletrica != 1 && partidaEletrica != 2) {
                partidaEletrica = inputNumerico("Opção inválida. Por favor, informe (1) ou (2): ", "Part. Elétrica");
            }
            
            ((Moto) novoVeiculo).setPartidaEletrica(partidaEletrica == 1 ? true : false);
        }
        
        try {
            service.salvar(novoVeiculo);
            System.out.println("Veiculo cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("\nERRO: " + e.getMessage());
        }
    }

    private static void listar() {
        var frota = service.buscaFrota();
        frota.toString();
        if (frota.isEmpty()) {
            System.out.println("A frota está vazia.");
        } else {
            System.out.println("LISTA DE VEÍCULOS CADASTRADOS");
            for (Veiculo veiculo : frota) {
                System.out.println("Veículo " + (frota.indexOf(veiculo) + 1) + " - " + veiculo.toString());
            }
        }
    }

    private static void listarPorPlaca(){
        System.out.print("Informe a placa do carro a ser buscado: ");
        String placa = input.nextLine();

        try{
            System.out.println(service.buscaPorPlaca(placa).toString());
        } catch(Exception e){
            System.out.println("\nERRO: " + e.getMessage());
        }
    }

    private static void removerPorPlaca(){
        if(!service.buscaFrota().isEmpty()){
            listar();
            System.out.print("Informe a placa do veículo que deseja REMOVER: ");
            String placa = input.nextLine();
    
            try{
                service.removePorPlaca(placa);
                System.out.println("Veículo removido com sucesso!");
            } catch(Exception e){
                System.out.println("\nERRO: " + e.getMessage());
            }
        } else{
            System.out.println("Não há veículos para remover.");
        }        
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
            opcao = inputNumerico(menu, "Opção");

            while (opcao < 0 || opcao > 4) {
                opcao = inputNumerico("Opção inválida! Digite uma nova opção: " , "Opção");
            }

            switch (opcao) {
                case 0:
                    limparTela();
                    System.out.println("VOLTE SEMPRE!!!");
                    break;
                case 1:
                    limparTela();
                    registrarVeiculo();
                    aguardarEnter();
                    break;
                case 2:
                    limparTela();
                    listar();
                    aguardarEnter();
                    break;
                case 3:
                    limparTela();
                    listarPorPlaca();
                    aguardarEnter();
                    break;
                case 4:
                    limparTela();
                    removerPorPlaca();
                    aguardarEnter();
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
