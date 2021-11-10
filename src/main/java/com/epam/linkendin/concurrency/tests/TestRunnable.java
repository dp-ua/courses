package com.epam.linkendin.concurrency.tests;

import java.io.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TestRunnable {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            int count = 0;
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
            return;
        };

        Executor executor = Executors.newFixedThreadPool(2);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
    }
}
