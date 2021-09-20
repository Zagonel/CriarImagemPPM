package Main;


import Classes.Gerador;

import java.io.FileNotFoundException;

public class Principal {
    public static void main(String[] args) throws FileNotFoundException {

        Gerador imagem = new Gerador();

        String URL = "src/Util/imagemPPM.txt";
        imagem.gerarImagemPPM(URL,192,192,8);
    }
}
