package examen1p1lab_josueham;

import java.util.Scanner;
import java.util.Random;

public class Examen1P1Lab_JosueHam {

    static Scanner leer = new Scanner (System.in);
    static Random aleatorio = new Random ();
    
    public static void main(String[] args) {
       
       int opcion;
       do{
           System.out.println("");
           System.out.println("----- Bienvenido al menu del programa -----");
           System.out.println("1 -> Ejercicio 1 (Divisores Primos)");
           System.out.println("2 -> Ejercicio 2 (Contorno de Figura)");
           System.out.println("3 -> Ejercicio 3 (Vecinos)");
           System.out.println("4 -> Salir del programa");
           System.out.println("Ingrese la opcion que desea: ");
           opcion = leer.nextInt();
           
           
           switch (opcion){
               case 1: {
                   System.out.println("Ingrese su numero: ");
                   int num = leer.nextInt();
                   
                   if (num >= 1){
                   primos(num);
                   System.out.println("Los numeros divisores primos de " + num + " son:  " + primos(num));
                   }
                   else{
                       System.out.println("El numero ingresado debe ser mayor o igual a 1");
                   }//Fin else
               }//Fin case 1
               break;
               
               case 2: {
                   System.out.println("Ingrese el tamaño de la figura: ");
                   int tam = leer.nextInt();
                   
                   if (tam % 2!=0){
                       contorno(tam);
                   }//Fin if validacion 
                   else {
                       System.out.println("Solo se permiten numeros impares");
                   }
               }//Fin case 2
               break;
               
               case 3:{
                   System.out.println("Ingrese su cadena: ");
                   leer.nextLine();
                   String cadena = leer.next().toLowerCase();
                   vecinos (cadena);
                   System.out.println(vecinos(cadena));
               }//Fin case 3
               break;
               
               default:
                   System.out.println("Saliendo del programa...");
           }//Fin del switch
       }while (opcion!=4);
    }//Fin del main
    
    
    public static String primos (int num){
        
       String no_primos ="";
       String primos = "";
        for (int i = 1; i < num; i++) {
            if (num % i != 0) {
                no_primos+= (Integer.toString(i)+ " ");
            }//Fin if 
            else if (num % i == 0){
                primos+= (Integer.toString(i)+ " ");
            }//Fin else if
        }//Fin for i
        
        System.out.println("Los divisores no primos de " + num + " son: " + no_primos);
        return primos;
    }//Fin metodo ejercicio 1
    
    public static void contorno(int tam){
        
        int mitad = tam/2;
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (((j == mitad+i || j == mitad-i) && i < mitad) || i == mitad-1 && j != 0 && j != tam-1){
                    System.out.print("+");
                }
                else if (j > mitad-i && j < mitad+i && i != mitad){
                    System.out.print(" ");
                }//Fin else if 
                else {
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
        
    }//Fin metodo ejercicio 2
    
    public static String vecinos (String cadena){
        
        String res = "";
        
        int num = aleatorio.nextInt(2);
        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);
            if (((int) letra >= 97 && (int) letra <= 122) || ((int)letra >= 48 && (int)letra <=57)) {
                if(num == 1){
                   letra++;
                   res+= (char)letra;
            }//Fin if
                else if (num == 0){
                    letra--;
                    res+= (char)letra;
                }
            } else {
                System.out.println("Solo se permiten cadenas de numeros y letras");
            }//Fin else
        }//Fin for i
        System.out.println("El numero generado es: " + num);
        return res;
    }//Fin metodo ejercicio 3
}//Fin de la clase
