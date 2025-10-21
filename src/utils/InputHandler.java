package utils;

import java.util.Scanner;

/**
 * Singleton class for handling all user input
 * Manages Scanner lifecycle and provides input validation
 */
public class InputHandler {
    private static InputHandler instance;
    private final Scanner scanner;
    
    private InputHandler() {
        this.scanner = new Scanner(System.in);
    }
    
    public static InputHandler getInstance() {
        if (instance == null) {
            instance = new InputHandler();
        }
        return instance;
    }
    
    public String readLine() {
        return scanner.nextLine();
    }
    
    public int readInt() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Geçersiz değer, lütfen bir sayı giriniz: ");
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }
    
    public int readIntInRange(int min, int max) {
        int value;
        do {
            value = readInt();
            if (value < min || value > max) {
                System.out.print("Geçersiz değer (" + min + "-" + max + " arası), tekrar giriniz: ");
            }
        } while (value < min || value > max);
        return value;
    }
    
    public String readLineUpperCase() {
        return readLine().toUpperCase();
    }
    
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}

