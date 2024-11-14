package library2;

import static library2.Library2.catalogo;
import static library2.Library2.input;

public class Book {

    String nombre, autor, genero;
    int id, quantity;

    public Book(String nombre, String autor, String genero, int quantity) {
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public static Book bookinfo() {
        String name, author, genre;
        int quantity;
        System.out.println("Nombre del libro: ");
        name = input.next();
        System.out.println("Genero: ");
        genre = input.next();
        System.out.println("Autor del libro: ");
        author = input.next();
        System.out.println("Cantidad disponible: ");
        quantity = input.nextInt();
        return new Book(name, author, genre, quantity);
    }

    public static void editbook() {
        int libroedit, parametrolibro;
        boolean bookdelete = false;
        System.out.println("Elija libro a modificar.");
        for (Book b : catalogo) {
            System.out.println(b.getNombre());
        }
        libroedit = input.nextInt();
        input.nextLine();
        do {
            System.out.println("Que parametro modificar?\n1. Nombre\n2. Genero\n3. Autor\n4. Copias disponibles\n5. Borrar libro\n6. Salir");
            parametrolibro = input.nextInt();
            input.nextLine();
            switch (parametrolibro) {
                case 1:
                    String newname;
                    System.out.println("Nombre actual: " + catalogo.get(libroedit).getNombre());
                    System.out.println("Ingrese nombre nuevo: ");
                    newname = input.nextLine();
                    catalogo.get(libroedit).setNombre(newname);
                    break;
                case 2:
                    String newgenre;
                    System.out.println("Genero actual: " + catalogo.get(libroedit).getGenero());
                    System.out.println("Ingrese genero nuevo: ");
                    newgenre = input.nextLine();
                    catalogo.get(libroedit).setGenero(newgenre);
                    break;
                case 3:
                    String newauthor;
                    System.out.println("Autor actual: " + catalogo.get(libroedit).getAutor());
                    System.out.println("Ingrese autor nuevo: ");
                    newauthor = input.nextLine();
                    catalogo.get(libroedit).setAutor(newauthor);
                    break;
                case 4:
                    int newquantity;
                    System.out.println("Cantidad de copias disponibles: " + catalogo.get(libroedit).getQuantity());
                    System.out.println("Ingrese nueva cantidad de copias disponibles: ");
                    newquantity = input.nextInt();
                    catalogo.get(libroedit).setQuantity(newquantity);
                    break;
                case 5:
                    System.out.println("Desea borrar el libro: " + catalogo.get(libroedit).getNombre() + "?");
                    System.out.println("1. Si\n2. No");
                    int confirmation;
                    confirmation = input.nextInt();
                    input.nextLine();
                    switch (confirmation) {
                        case 1:
                            System.out.println(catalogo.get(libroedit).getNombre() + " es historia.");
                            catalogo.remove(libroedit);
                            bookdelete = true;
                            break;
                        case 2:
                            System.out.println("Cancelar.");
                            break;
                    }
            }
        } while (parametrolibro != 6 && bookdelete == false);
    }

    public static void catalogo() {
        System.out.println("Bienvenido al catalogo. Los libros disponibles en este momento son:");
        for (Book b : catalogo) {
            System.out.println(b.getNombre());
        }
        int loop = 1;
        do {
            System.out.println("Elija un libro para ver mas informacion.");
            int selection;
            selection = input.nextInt();
            input.nextLine();
            System.out.println("Libro: " + catalogo.get(selection).getNombre() + "\nGenero: " + catalogo.get(selection).getGenero() + "\nAutor: " + catalogo.get(selection).getAutor() + "\nCopias disponibles: " + catalogo.get(selection).getQuantity());
            System.out.println("Ver otro libro?\n1. Si\n2. No");
            loop = input.nextInt();
        } while (loop == 1);
    }
}
