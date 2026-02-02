package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) {

        //Crear la pila
        IStack<Integer> stack = new VectorStack<>();

        //Crear la calculadora usando el ADT
        PostfixCalculator calculator = new PostfixCalculatorImpl(stack);

        //Leer el archivo con las expresiones
        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int result = calculator.evaluate(line);
                    System.out.println("Expresion: " + line);
                    System.out.println("Resultado: " + result);
                    System.out.println();
                } catch (Exception e) {
                    System.out.println("Error en la expresion: " + line);
                    System.out.println(e.getMessage());
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo datos.txt");
            System.out.println(e.getMessage());
        }
    }
}
