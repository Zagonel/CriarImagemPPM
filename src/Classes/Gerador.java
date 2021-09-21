package Classes;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

public class Gerador {

    public void gerarImagemPPMColorida(String URL, int linha, int coluna, int bits) throws FileNotFoundException {
        PrintStream gravarArq = new PrintStream(URL);

        gravarArq.print("P3\n" + coluna + " " + linha + "\n" + "255\n");

        int matriz[][] = new int[linha][coluna];

        Random gerador = new Random();

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                double valor = (255 / bits) * (gerador.nextInt(bits) + 1);
                matriz[i][j] = (int) valor;
                gravarArq.print(matriz[i][j] +"   ");
                if(j == (coluna-1)){
                    gravarArq.print("\n");
                }
            }
        }
    }
    public void gerarImagemPPMMonoCromatica(String URL, int linha, int coluna, int bits) throws FileNotFoundException {
        PrintStream gravarArq = new PrintStream(URL);

        gravarArq.print("P3\n" + coluna + " " + linha + "\n" + "255\n");

        int matriz[][] = new int[linha][coluna];

        Random gerador = new Random();

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                double valor = (255 / bits) * (gerador.nextInt(bits) + 1);
                matriz[i][j] = (int) valor;
                gravarArq.print("0   " + matriz[i][j]+"   0   ");
                if(j == (coluna-1)){
                    gravarArq.print("\n");
                }
            }
        }
    }
}
