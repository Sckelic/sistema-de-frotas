import java.util.ArrayList;
import java.util.List;

public class ServiceVeiculo {
    private List<Veiculo> frota = new ArrayList<>();

    public void save(Veiculo veiculo) throws Exception { 
        if(veiculo.getAno() <= 0){
            throw new Exception("Nao e possivel adicionar um veiculo com ano nulo ou menor que 0");
        }
        if (veiculo instanceof Carro){
            int numeroPortas = ((Carro) veiculo).getNumeroPortas();
            if (numeroPortas <= 0){
                throw new Exception("Nao e possivel adicionar um carro com 0 portas ou menos");
            }
        }
        for (Veiculo veiculoFrota : frota){
            if (veiculoFrota.getPlaca().equalsIgnoreCase(veiculo.getPlaca()))
                throw new Exception("Nao e possivel cadastrar uma placa mais de uma vez");
        }
        if (veiculo.getMarca() == null || veiculo.getMarca().isEmpty()){
            throw new Exception("Nao e possivel deixar esse campo vazio");
        }
        if (veiculo.getModelo() == null || veiculo.getModelo().isEmpty()){
            throw new Exception("Nao e possivel deixar esse campo vazio");
        }
    }

    public List<Veiculo> findAll() {
        return frota;
    }

    public Veiculo findByPlaca(String placa) throws Exception {
        Veiculo veiculoRet = null;
        for (Veiculo veiculo : frota) {
            if (veiculo.getPlaca().equals(placa)) {
                veiculoRet = veiculo;
                break;
            }
        }
        if (veiculoRet == null)
            throw new Exception("Veículo não encontrado com a placa informada");
        return veiculoRet;
    }
}