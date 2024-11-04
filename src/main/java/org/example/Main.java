package org.example;

import org.example.entidade.Livro;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro("My book 01");
        Livro livro2 = new Livro("My book 02");
        Livro livro3 = new Livro("My book 03");
        Livro livro4 = new Livro("My book 04");
        Livro livro5 = new Livro("My book 05");
        Livro livro6 = new Livro("My book 06");
        Livro livro7 = new Livro("My book 07");
        Livro livro8 = new Livro("My book 08");
        Livro livro9 = new Livro("My book 09");
        Livro livro10 = new Livro("My book 10");

        Livro[] listaLivros = new Livro[10];

        listaLivros[0] = livro1;
        listaLivros[1] = livro2;
        listaLivros[2] = livro3;
        listaLivros[3] = livro4;
        listaLivros[4] = livro5;
        listaLivros[5] = livro6;
        listaLivros[6] = livro7;
        listaLivros[7] = livro8;
        listaLivros[8] = livro9;
        listaLivros[9] = livro10;

        // igual em comparação é ==
        //diferente em comparação é !=

        for(int i = 0; i < listaLivros.length; i++ ){
            if(i % 2 != 0) {
                System.out.println( i+" - "+ listaLivros[i].getTitulo());
            }
        }

        for(int i = listaLivros.length -1; i >= 0; i-- ){
            if(i % 2 == 0) {
                System.out.println( i+" - "+ listaLivros[i].getTitulo());
            }
        }

    }
}