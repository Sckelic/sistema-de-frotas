public class Carro extends Veiculo{
    private int numeroPortas;

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    @Override
    public String toString() {
        return "Carro - " + super.toString() + ", Número de Portas: " + getMarca();
    }
    
}