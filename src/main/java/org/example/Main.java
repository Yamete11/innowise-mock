package org.example;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("test3.jpg");
        if (inputStream == null) {
            System.out.println("Файл не найден!");
        } else {
            // работа с inputStream, например, чтение изображения
            System.out.println("Файл найден!");
        }
    }
}
