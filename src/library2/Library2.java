package library2;

import java.util.ArrayList;
import java.util.Scanner;

public class Library2 {
//Asignar variables a las que se pueden acceder desde metodos.
    
    static Scanner input = new Scanner(System.in);
    private static Book LOTR = new Book("Lord of the Rings", "Tolkien", "Fantasy", 3);
    private static Book DQ = new Book("Don Quixote", "Miguel de Cervantes", "Novel", 4);
    private static Book Shogun = new Book("Shogun", "James Clavell", "Historical Fiction", 6);
    private static User admin = new User("Admin", "admin@gmail.com", "01010101", "10101010");
    static ArrayList<Book> catalogo = new ArrayList<>();
    static ArrayList<User> userlist = new ArrayList<>();

    public static void main(String[] args) {
        catalogo.add(LOTR);
        catalogo.add(DQ);
        catalogo.add(Shogun);
        userlist.add(admin);
        System.out.println("Ingrese la clave de acceso.");
        String key = input.next();
        if (key.equals("covfefe")) { // Al crear el menu dentro de una estructura de control con un boolean, puedo asignar una llave al software para permitir o no el acceso al mismo.
            Boolean menu = true;
            do { // Menu dentro de do-while para evitar que se corte el programa a menos que se elija especificamente la opcion de salir.
                System.out.println("Menu principal.");
                System.out.println("1. Crear libro.\n2. Modificar libro.\n3. Rentar libro.\n4. Registrar usuario.\n5. Modificar usuario.\n6. Catalogo. \n7. Salir.");
                int selection = input.nextInt();
                input.nextLine();
                switch (selection) { // El menu se controla a traves de switch.
                    case 1: // Crear libro
                        int loopbook = 1;
                        do {
                            Book test = Book.bookinfo(); // El metodo bookinfo(); retorna una instancia de Book con datos proporcionados por Scanner.
                            System.out.println("Crear otro libro?");
                            System.out.println("1. Si \\ 2. No");
                            loopbook = input.nextInt();
                            catalogo.add(test);
                        } while (loopbook == 1);
                        break;
                    case 2: // Editar libro
                        Book.editbook();
                        break;
                    case 3: // Rentar libro
                        break;
                    case 4: // Registrar usuario
                        int loopuser = 1;
                        do {
                            User user01 = User.registro(); // El metodo registro(); retorna una instancia de User con datos proporcionados por Scanner.
                            userlist.add(user01);
                            User.showuser(user01); // El metodo showuser(); retorna todos los datos del usuario recien registrado.
                            System.out.println("Crear otro usuario?");
                            System.out.println("1. Si \\ 2. No");
                            loopuser = input.nextInt();
                        } while (loopuser == 1);
                        break;
                    case 5: // Editar usuario
                        User.edituser(); // El metodo edituser(); permite editar todos los datos de un usuario por Scanner.
                        break;
                    case 6: // Ver catalogo
                        Book.catalogo();
                        break;
                    case 7: // Cerrar programa
                        menu = false;
                        break;
                }
            } while (menu == true);
        } else {
            System.out.println("Clave incorrecta");
        }
    }
}
