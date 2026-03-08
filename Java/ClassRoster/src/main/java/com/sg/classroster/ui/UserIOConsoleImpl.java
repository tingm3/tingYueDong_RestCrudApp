package com.sg.classroster.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    Scanner console = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {
        this.print(prompt);
        String userInput = console.nextLine();
        return Double.parseDouble(userInput);
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        this.print(prompt);
        String userInput = console.nextLine();
        double num = Double.parseDouble(userInput);
        while (num < min || num > max) {
            userInput = console.nextLine();
            num = Double.parseDouble(userInput);
        }
        return num;
    }

    @Override
    public float readFloat(String prompt) {
        this.print(prompt);
        String userInput = console.nextLine();
        return Float.parseFloat(userInput);
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        this.print(prompt);
        String userInput = console.nextLine();
        float num = Float.parseFloat(userInput);
        while (num < min || num > max) {
            userInput = console.nextLine();
            num = Float.parseFloat(userInput);
        }
        return num;
    }

    @Override
    public int readInt(String prompt) {
        this.print(prompt);
        String userInput = console.nextLine();
        return Integer.parseInt(userInput);
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        this.print(prompt);
        String userInput = console.nextLine();
        int num = Integer.parseInt(userInput);
        while (num < min || num > max) {
            userInput = console.nextLine();
            num = Integer.parseInt(userInput);
        }
        return num;
    }

    @Override
    public long readLong(String prompt) {
        this.print(prompt);
        String userInput = console.nextLine();
        return Long.parseLong(userInput);
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        this.print(prompt);
        String userInput = console.nextLine();
        long num = Long.parseLong(userInput);
        while (num < min || num > max) {
            userInput = console.nextLine();
            num = Long.parseLong(userInput);
        }
        return num;
    }

    @Override
    public String readString(String prompt) {
        this.print(prompt);
        return console.nextLine();
    }
}