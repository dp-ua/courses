package com.epam.linkendin.concurrency.runnables;

import java.io.*;

public class AppThread extends Thread {

    @Override
    public void run() {
        int count=0;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Pavlo_Reshetylo\\Coding\\Files From Linkendin\\Ex_Files_Java_EE_Concurrency\\Exercise Files\\Chapter2\\02_03\\begin\\sample.txt")))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + " [" + count++ + "]:" + line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
