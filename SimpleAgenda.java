import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;


public class SimpleAgenda {
    public static String[] contactos = new String[10];
    public static File Agenda = new File("contactos.txt");


    public static void main(String[] args) {

    generarArchivo();
    mostrarContacto();
    mostrarContactos();

    }

    public static void generarArchivo(){
        try {
            File f = new File("contactos.txt");
            f.createNewFile();
        } catch (IOException e) {
            System.out.println("Ocurrio un error...");;
        }

        try {
            FileWriter f = new FileWriter(Agenda);
            f.write("contacto,telefono\n" +

                    "Adan,8098551212\n" +

                    "Enmanuel,8294118787\n" +

                    "Raider,8097410032\n" +

                    "Roger,8095554141\n" );
            f.close();

        } catch (IOException e) {
            System.out.println("Ocurrio un error...");;
        }



    }

    public static void agregarContacto() {
        String nombre;
        boolean existe = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un contacto a agregar.");
        nombre = sc.nextLine();

        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].equals(nombre)) {
                existe = true;
                break;
            }
        }
        if (existe) {
            System.out.println("Ya se ha agregado anteriormente");
        } else {
            // Aplicar la lógica de añadir el elemento a la posición actual del arreglo
            for (int i = 0; i < contactos.length; i++) {
                if (contactos[i] == null) {
                    contactos[i] = nombre;
                    System.out.println("Agregado satisfactoriamente");
                    break;
                }
            }
        }


    }

    public static void removerContacto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el contacto a remover:");
        String contactoRemover = scanner.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].equals(contactoRemover)) {
                contactos[i] = null;
                encontrado = true;
                System.out.println("El contacto " + contactoRemover + " fue removido exitosamente!");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No existe tal contacto");
        }
    }

    public static String actualizarContacto(int na) {
        return "N/A";
    }

    public static void mostrarContacto() {
        String contacto;
        boolean existe = false;
        try {
            Scanner scArchivo = new Scanner(Agenda);
            Scanner sc = new Scanner(System.in);

            System.out.println("Ingrese nombre a consultar");
            contacto = sc.nextLine();

            while (scArchivo.hasNextLine()){
                String linea = scArchivo.nextLine();
                if (linea.startsWith(contacto)){
                    existe = true;
                    break;
                }
            }
            if (existe){
                System.out.println("El contacto " + contacto + " existe");
            }
            else System.out.println("No existen registros de este contacto");
        } catch (IOException e){
            System.out.println("Ocurrio un error...");
        }


    }

    public static void mostrarContactos(){
        System.out.println("Mostrando contactos...");
        try {
            Scanner sc = new Scanner(Agenda);
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                if (!linea.startsWith("contacto")){
                    System.out.println(linea    );
                }
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error…");
        }

    }
}
