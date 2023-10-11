import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Calculadora
 *
 * Argumentos
 * arg[0] = operacion
 * arg[1] = operando1
 * arg[2] = operando2
 * arg[3] = ruta de salida
 *
 * Autor: Rodrigo Roldán
 */

public class Calculadora {
    public static void main(String[] args) {

        // Verificar la operación que se va a hacer, si el símbolo es correcto
        ArrayList<String> operaciones = new ArrayList<String>();
        operaciones.add("+");
        operaciones.add("-");
        operaciones.add("x");
        operaciones.add("/");


        // Controlar argumentos que recibe
        if(args.length != 4) {
            System.out.println("Error: argumentos inválidos");
            System.out.println("Uso: java Calculadora <operacion> <operando1> <operando2> <ruta de salida>");
            System.exit(1);
        }

        // Verificar que los operandos sean números
        if(args[1].matches("[0-9]+") == false || args[2].matches("[0-9]+") == false) {
            System.out.println("Error: operandos inválidos");
            System.out.println("Uso: java Calculadora <operacion> <operando1> <operando2> <ruta de salida>");
            System.exit(1);
        }



        if(!operaciones.contains(args[0])) {
            System.out.println("Error: operación inválida");
            System.out.println("Uso: java Calculadora <operacion>: + - x /");
            System.exit(1);
        }

        // Convierto operandos a Double

        Double resultado = 0.0;
        Double operando1 = Double.parseDouble(args[1]);
        Double operando2 = Double.parseDouble(args[2]);

        // Realizar la operación
        switch(args[0]) {
            case "+":
                resultado = operando1 + operando2;
                break;
            case "-":
                resultado = operando1 - operando2;
                break;
            case "x":
                resultado = operando1 * operando2;
                break;
            case "/":
                if(operando2 == 0) {
                    System.out.println("Error: división por cero");
                    System.exit(1);
                }
                resultado = operando1 / operando2;
                break;
        }


        // Imprimirla en pantalla
        System.out.println("El resultado de la operación es: " + resultado);

        // Guardarla en un archivo
        String ruta = args[3];
        try {
            FileWriter archivo = new FileWriter(ruta);
            archivo.write("El resultado de la operación es: " + resultado);
            archivo.close();
        } catch (Exception e) {
            System.out.println("Error: no se pudo guardar el archivo");
            System.exit(1);
        }


    }
}