package br.univille.dados.estrutura;

public class Main {

    public static void main(String[] args) {
        Alpha alpha = new Alpha();
        Beta beta = new Beta();
        Pacote pacote1 = new Pacote("000000000100");
        Pacote pacote2 = new Pacote("001011110110");
        Pacote pacote3 = new Pacote("011100001000");
        Pacote pacote4 = new Pacote("101010110111");
        Pacote pacote5 = new Pacote("111010000111");
        Pacote pacote6 = new Pacote("111111111111");
        beta.sendPacote(pacote1,alpha);
        beta.sendPacote(pacote2,alpha);
        beta.sendPacote(pacote3,alpha);
        beta.sendPacote(pacote4,alpha);
        beta.sendPacote(pacote5,alpha);
        beta.sendPacote(pacote6,alpha);
        if (beta.getSucesso()){
            System.out.println("Todos os pacotes foram entregues");
        } else {
            System.out.println("Ocorreu um erro na entregas dos pacotes");
        }
    }
}
