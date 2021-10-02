package Classes;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

public class Gerador {

    public void gerarImagemPPMColorida(String URL, int linha, int coluna, int bits) throws FileNotFoundException {
        PrintStream gravarArq = new PrintStream(URL);

        gravarArq.print("P3\n" + coluna + " " + linha + "\n" + "255\n");

        Pixel[][] matriz = new Pixel[linha][coluna];


        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {

                Pixel pixel = new Pixel();

                pixel.setRed((int) geraValorAleatorio(bits));
                pixel.setBlue((int) geraValorAleatorio(bits));
                pixel.setGrean((int) geraValorAleatorio(bits));
                matriz[i][j] = pixel;

                gravarArq.print(matriz[i][j].getRed() + "   " + matriz[i][j].getBlue() + "   " + matriz[i][j].getGrean() + "   ");
                if (j == (coluna - 1)) {
                    gravarArq.print("\n");
                }
            }
        }
    }

    private double geraValorAleatorio(int bits) {
        Random random = new Random();
        return (255 / bits) * (random.nextInt(bits) + 1);
    }

    public void gerarImagemPPMMonoCromatica(String URL, int linha, int coluna, int bits) throws FileNotFoundException {
        PrintStream gravarArq = new PrintStream(URL);

        gravarArq.print("P2\n" + coluna + " " + linha + "\n" + "255\n");

        int[][] matriz = new int[linha][coluna];

        Random gerador = new Random();

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                double valor = geraValorAleatorio(bits);
                matriz[i][j] = (int) valor;
                gravarArq.print(matriz[i][j] + "   ");
                if (j == (coluna - 1)) {
                    gravarArq.print("\n");
                }
            }
        }
    }
}
