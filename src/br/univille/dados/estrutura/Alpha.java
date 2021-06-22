package br.univille.dados.estrutura;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class Alpha {

    private ListaDupla lista = new ListaDupla();
    private Beta beta;
    private boolean listable = true;
    private int qtdPacote;

    public void addPacote(Pacote pacote, Beta beta){
        this.beta = beta;
        if(listable) {
            if (lista.isEmpty() | isPacoteBegin(pacote)) {
                lista.addFirst(pacote);
            } else {
                lista.addLast(pacote);
            }
            if (isPacoteEnd(pacote)) {

                //responsavel por dividir o pacote completo
                int contador = 0;
                for (int i = 0; i < lista.size(); i++){
                    contador += 1;
                    Pacote share = (Pacote) lista.get(i);
                    share.setIdentify(share.getFullPacote().substring(0,4));
                    share.setBuffer(share.getFullPacote().substring(4));
                    System.out.println(contador+". Pacote Completo: " +share.getFullPacote());
                    System.out.println(contador+". Divisão do Identify: " +share.getIdentify());
                    System.out.println(contador+". Divisão do Buffer: " +share.getBuffer());
                }

                //SelectSort organiza a lista
                SelectorSort sort = new SelectorSort();
                OrganizaIdentify comparador = new OrganizaIdentify();
                sort.sort(lista, comparador);


                //confere se todos os pacotes foram recebidos removendo o pacote begin e end
                if (lista.size() - 2 == qtdPacote){
                    beta.setSucesso(true);
                } else {
                    beta.setSucesso(false);
                }
                System.out.println("Quantidade de pacote enviados: " +qtdPacote);

                if(beta.getSucesso()){
                    String cadeiaString = concatBuffer();
                    Double valor = cadeiaToDecimal(cadeiaString);
                }
            }
        }
    }

    private Double cadeiaToDecimal(String cadeiaString) {
        long valorInteiro = Long.parseLong(cadeiaString.substring(4), 2);
        int casasDecimais = Integer.parseInt(cadeiaString.substring(1 ,4), 2);
        String pattern = casasDecimais == 0 ? "0" : "0".repeat(casasDecimais);
        NumberFormat format = new DecimalFormat("#0," + pattern);
        String temp = format.format(valorInteiro);
        Double valor = Double.parseDouble(temp);
        if (cadeiaString.startsWith("1")){
            valor *= -1;
        }

        System.out.println("Valor Decimal: "+valor);
        return valor;

    }

    //concatena todos os buffer em uma so string
    private String concatBuffer() {
        String cadeiaString = "";
        for (int i = 1; i < lista.size() - 1; i++){
            Pacote pacote = (Pacote) lista.get(i);
            cadeiaString = cadeiaString.concat(pacote.getBuffer());
        }
        System.out.println("Buffers concatenados: "+cadeiaString);
        return cadeiaString;
    }

    private boolean isPacoteEnd(Pacote pacote) {
        if (pacote.getFullPacote().equals("111111111111")){
            listable = false;
            return true;

        } else {
            return false;
        }
    }

    private boolean isPacoteBegin(Pacote pacote) {
        if (pacote.getFullPacote().startsWith("0000")){
            qtdPacote = Integer.parseInt(pacote.getFullPacote().substring(4), 2 );
            return true;

        } else {
            return false;
        }
    }
}
