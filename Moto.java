public class Moto extends Veiculo{
    private boolean partidaEletrica;

    public boolean getPartidaEletrica() {
        return partidaEletrica;
    }

    public void setPartidaEletrica(boolean partidaEletrica) {
        this.partidaEletrica = partidaEletrica;
    }
    
    @Override
    public String toString(){
        return "Tipo: Moto - " + super.toString() + "Part. Elétrica: " + (getPartidaEletrica() ? "Sim" : "Não");
    }
}