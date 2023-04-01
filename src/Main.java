import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el grado del arbol:");
        int t = sc.nextInt();
        ArbolB arbol = new ArbolB(t);
        while (true) {
            System.out.println("\nMenu:\n1. Insertar clave\n2. Eliminar clave\n3. Buscar clave\n4. Salir");
            int opcion = sc.nextInt();
            if (opcion == 1) {
                System.out.println("Ingrese la clave a insertar:");
                int clave = sc.nextInt();
                arbol.insertar(clave);
                System.out.println("Clave insertada.");
            } else if (opcion == 2) {
                System.out.println("Ingrese la clave a eliminar:");
                int clave = sc.nextInt();
                arbol.eliminar(clave);
                System.out.println("Clave eliminada.");
            } else if (opcion == 3) {
                System.out.println("Ingrese la clave a buscar:");
                int clave = sc.nextInt();
                Nodo resultado = arbol.buscar(clave);
                if (resultado != null)
                    System.out.println("Clave encontrada.");
                else
                    System.out.println("Clave no encontrada.");
            } else if (opcion == 4) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción inválida.");
            }
            System.out.println("Arbol actual:");
            arbol.imprimir();
        }
        sc.close();
    }
}
