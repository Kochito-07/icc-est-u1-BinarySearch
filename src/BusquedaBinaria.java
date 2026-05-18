import java.util.Scanner;

class Persona {
    String nombre; 
    int edad;     

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}

public class BusquedaBinaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese cantidad de Personas del listado: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Persona[] personas = new Persona[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese Persona:");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            
            int edad = -1;
            while (edad < 0) {
                System.out.print("Edad: ");
                edad = scanner.nextInt();
                if (edad < 0) {
                    System.out.println("Error: La edad no puede ser negativa. Intente de nuevo.");
                }
            }
            scanner.nextLine(); 
            
            personas[i] = new Persona(nombre, edad);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (personas[j].edad > personas[j + 1].edad) {
                    Persona temp = personas[j];
                    personas[j] = personas[j + 1];
                    personas[j + 1] = temp;
                }
            }
        }

        System.out.print("\nEdad de la persona buscada: ");
        int valorBuscado = scanner.nextInt();


        int bajo = 0;
        int alto = n - 1;
        boolean encontrado = false;
        Persona personaEncontrada = null;

        while (bajo <= alto) {
            for (int i = bajo; i <= alto; i++) {
                System.out.print(personas[i].edad);
                if (i < alto) {
                    System.out.print(" | ");
                } else {
                    System.out.print(" |");
                }
            }
            System.out.println();

            int centro = (bajo + alto) / 2;
            int valorCentro = personas[centro].edad;

            System.out.print("bajo=" + bajo + "\talto=" + alto + "\tcentro=" + centro + "\tvalorCentro=" + valorCentro);

            if (valorCentro == valorBuscado) {
                System.out.println("\t--> ENCONTRADO\n");
                encontrado = true;
                personaEncontrada = personas[centro];
                break;
            } else if (valorBuscado < valorCentro) {
                System.out.println("\t--> IZQUIERDA\n");
                alto = centro - 1;
            } else {
                System.out.println("\t--> DERECHA\n");
                bajo = centro + 1;
            }
        }


        if (encontrado) {
            System.out.println("La persona con la edad " + valorBuscado + " es " + personaEncontrada.nombre);
        } else {
            System.out.println("La persona con la edad " + valorBuscado + " no fue encontrada.");
        }
        
        scanner.close();
    }
}