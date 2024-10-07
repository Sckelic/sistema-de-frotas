import java.util.ArrayList;
import java.util.List;

public class ServiceVeiculo {
    private List<Veiculo> frota = new ArrayList<>();

    public void salvar(Veiculo veiculo) throws Exception { 

        if(veiculo.getAno() <= 0){
            throw new Exception("NÃO FOI POSSÍVEL CADASTRAR O VEÍCULO. \nO ano deve ser maior que 0.");
        }

        if(veiculo.getPlaca() == null || veiculo.getPlaca().isEmpty()){
            throw new Exception("NÃO FOI POSSÍVEL CADASTRAR O VEÍCULO. \nA placa não pode estar vazia.");
        }

        if (veiculo instanceof Carro){
            int numeroPortas = ((Carro) veiculo).getNumeroPortas();
            if (numeroPortas <= 0){
                throw new Exception("NÃO FOI POSSÍVEL CADASTRAR O VEÍCULO. \nO número de portas deve ser maior que 0.");
            }
        }

        if (veiculo.getMarca() == null || veiculo.getMarca().isEmpty()){
            throw new Exception("NÃO FOI POSSÍVEL CADASTRAR O VEÍCULO. \nA marca não pode estar vazia.");
        }
        if (veiculo.getModelo() == null || veiculo.getModelo().isEmpty()){
            throw new Exception("NÃO FOI POSSÍVEL CADASTRAR O VEÍCULO. \nO modelo não pode estar vazio.");
        }

        for (Veiculo veiculoFrota : frota){
            if (veiculoFrota.getPlaca().equalsIgnoreCase(veiculo.getPlaca()))
                throw new Exception("NÃO FOI POSSÍVEL CADASTRAR O VEÍCULO. \nO veículo com essa placa já existe.");
        }

        frota.add(veiculo);
    }

    public List<Veiculo> buscaFrota() {
        return frota;
    }

    public Veiculo buscaPorPlaca(String placa) throws Exception {
        Veiculo veiculoEncontrado = null;
        for (Veiculo veiculo : frota) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                veiculoEncontrado = veiculo;
            }
        }

        if (veiculoEncontrado == null)
            throw new Exception("Veículo não encontrado com a placa informada.");

        return veiculoEncontrado;
    }

    public void removePorPlaca(String placa) throws Exception{
        boolean veiculoRemovido = false;
        for(var veiculo : frota){
            if (veiculo.getPlaca().equalsIgnoreCase(placa)){
                frota.remove(veiculo);
                veiculoRemovido = true;
                break;
            }
        }

        if(!veiculoRemovido)
            throw new Exception("Veículo não encontrado com a placa informada.");
    }
} 