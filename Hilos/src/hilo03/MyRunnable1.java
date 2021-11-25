package hilo03;

import java.util.ArrayList;

public class MyRunnable1 implements Runnable {

    private String rName;
    public MyRunnable1(String rName, ArrayList<Runnable> listR,  ArrayList<String> listS) {
        this.rName = rName;
        listR.add(this);
        listS.add(rName);
    }
    
    @Override
    public void run() {
        System.out.printf("Mi nombre es: %s\n", rName);
    }
}
