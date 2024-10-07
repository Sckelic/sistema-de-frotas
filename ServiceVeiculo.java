import java.util.ArrayList;
import java.util.List;

public class ServiceVeiculo {
    private List<Veiculo> frota = new ArrayList<>();

    public void save(Veiculo veiculo) throws Exception { 
        if(veiculo.getAno() <= 0){
            throw new Exception("NÃO FOI POSSÍVEL CADASTRAR O VEÍCULO.");
        }
        if (veiculo instanceof Carro){
            int numeroPortas = ((Carro) veiculo).getNumeroPortas();
            if (numeroPortas <= 0){
                throw new Exception("NÃO FOI POSSÍVEL CADASTRAR O VEÍCULO.");
            }
        }
        for (Veiculo veiculoFrota : frota){
            if (veiculoFrota.getPlaca().equalsIgnoreCase(veiculo.getPlaca()))
                throw new Exception("NÃO FOI POSSÍVEL CADASTRAR O VEÍCULO.");
        }
        if (veiculo.getMarca() == null || veiculo.getMarca().isEmpty()){
            throw new Exception("NÃO FOI POSSÍVEL CADASTRAR O VEÍCULO.");
        }
        if (veiculo.getModelo() == null || veiculo.getModelo().isEmpty()){
            throw new Exception("NÃO FOI POSSÍVEL CADASTRAR O VEÍCULO.");
        }
    }

    public List<Veiculo> findAll() {
        return frota;
    }

    public Veiculo findByPlaca(String placa) throws Exception {
        @SuppressWarnings("unused")
        List<Veiculo> veiculosEncontrados = new ArrayList<>();
        boolean veiculoExiste = false;
        Veiculo veiculoRet = null;
        for (Veiculo veiculo : frota) {
            if (veiculo.getPlaca().equals(placa)) {
                veiculoExiste = true;
                veiculoRet = veiculo;
                break;
            }
        }

        if (!veiculoExiste)
            throw new Exception("Veículo não encontrado com a placa informada");

        return veiculoRet;
    }

} 