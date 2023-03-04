
package colegio;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PAVILION
 */
public class Colegio {
    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("-----------------------------");
            System.out.println("Menu:");
            System.out.println("1. Ingresar un nuevo alumno");
            System.out.println("2. Ver todos los alumnos registrados");
            System.out.println("3. Salir");
            System.out.println("-----------------------------");
            System.out.print("Ingrese una opcion por favor (: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del alumno: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el carnet del alumno: ");
                    String carnet = scanner.nextLine();

                    // Validación para que el carnet y el nombre no se repitan invocada desde clase alumno
                    if (!Alumno.existeAlumno(alumnos, carnet, nombre)) {
                        System.out.print("Ingrese la edad: ");
                        int edad = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Ingrese el genero del alumno (M/F): ");
                        char genero = scanner.nextLine().charAt(0);
                        alumnos.add(new Alumno(nombre, carnet, edad, genero));
                        System.out.println("El alumno ha sido ingresado exitosamente");
                    }
                    break;
                case 2:
                    //listado de alumnos mayor a 0
                    if (alumnos.size() > 0) {
                        System.out.println("Listado de alumnos:");
                        for (Alumno alumno : alumnos) {
                            System.out.println(alumno);
                        }
                    } else {
                        System.out.println("No hay alumnos ingresados");
                    }
                    break;
                case 3:
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }
}//clase alumno solicitada donde estan declaras las variables y una validacion para saber si el alumno ya fue ingresado 
class Alumno {
    private String nombre;
    private String carnet;
    private int edad;
    private char genero;

    public Alumno(String nombre, String carnet, int edad, char genero) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.edad = edad;
        this.genero = genero;
    }
//validacion con el array para el nombre y carnet
    public static boolean existeAlumno(ArrayList<Alumno> alumnos, String carnet, String nombre) {
        for (Alumno alumno : alumnos) {
            if (alumno.getCarnet().equalsIgnoreCase(carnet) || alumno.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("El carnet o el nombre del alumno ya existe ");
                return true;
            }
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public String toString() {
        
        return "Nombre: " + nombre + " Carnet: " + carnet + " Edad: " + edad + " Género: " + genero;
        
    }
}