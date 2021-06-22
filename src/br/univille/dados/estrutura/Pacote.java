package br.univille.dados.estrutura;


public class Pacote {

    private String identify;
    private String buffer;
    private String fullPacote;

    public Pacote(String fullPacote) {
        this.fullPacote = fullPacote;
    }

    public String intParaBinario(Integer numero){
        return Integer.toBinaryString(numero);
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getBuffer() {
        return buffer;
    }

    public void setBuffer(String buffer) {
        this.buffer = buffer;
    }

    public String getFullPacote() {
        return fullPacote;
    }

    public void setFullPacote(String fullPacote) {
        this.fullPacote = fullPacote;
    }
}
