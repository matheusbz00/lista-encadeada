package br.univille.dados.estrutura;

public class Beta {

    private boolean sucesso;

    public void sendPacote(Pacote pacote, Alpha alpha) { alpha.addPacote(pacote, this);}

    public boolean getSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }
}
