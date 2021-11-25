package hilo03;

import java.util.ArrayList;

import hilo03.MyRunnable1;

public class Prog1 {
    public static void main(String[] args) {
        ArrayList<Runnable> listaR = new ArrayList<>();
        ArrayList<String> listaS = new ArrayList<>();
        new MyRunnable1("i", listaR, listaS);
        new MyRunnable1("h", listaR, listaS);
        new MyRunnable1("g", listaR, listaS);
        new MyRunnable1("a", listaR, listaS);
        for (Runnable r : listaR) {
            startRunnable(r);
        }
    }

    public static void startRunnable(Runnable r) {
        new Thread(r).start();
    }
}
