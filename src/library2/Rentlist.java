package library2;

import static library2.Library2.catalogo;
import static library2.Library2.input;
import static library2.Library2.userlist;
import static library2.Library2.rentlist;

public class Rentlist {

    String id, book, returndate;

    public Rentlist(String id, String book, String returndate) {
        this.id = id;
        this.book = book;
        this.returndate = returndate;
    }

    public String getId() {
        return id;
    }

    public void setUser(String user) {
        this.id = user;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    public static Rentlist booklease() {
        int menu, currentquantity, booklease = 0, userlease = 0, bookcounter = 0, usercounter = 0;
        String leasedate = "default";
        System.out.println("Bienvenido a la renta de libros.\n1. Rentar libro\n2. Ver lista de rentas\n3. Volver");
        menu = input.nextInt();
        input.nextLine();
        switch (menu) {
            case 1:
                System.out.println("Actualmente, el catalogo es: ");
                for (Book b : catalogo) {
                    System.out.println(bookcounter + " " + b.getNombre() + " copias disponibles: " + b.getQuantity());
                    bookcounter++;
                }
                System.out.println("Que libro desea rentar?");
                booklease = input.nextInt();
                input.nextLine();
                System.out.println("A continuacion ingrese quien lo va a rentar.");
                for (User b : userlist) {
                    System.out.println(usercounter + " " + b.getUsername() + " " + b.getId());
                    usercounter++;
                }
                userlease = input.nextInt();
                input.nextLine();
                System.out.println("Que fecha es hoy?");
                leasedate = input.nextLine();
                currentquantity = catalogo.get(booklease).getQuantity();
                catalogo.get(booklease).setQuantity(currentquantity - 1);
                break;
            case 2:
                if (!rentlist.isEmpty()) {
                    for (Rentlist b : rentlist) {
                        System.out.println(b.getBook() + " rentado por " + b.getId() + " en la fecha " + b.getReturndate());
                    }
                } else {
                    System.out.println("Aun no hay libros rentados.");
                }
                break;
            case 3:
                break;
        }
        return new Rentlist(userlist.get(userlease).getId(), catalogo.get(booklease).getNombre(), leasedate);
    }
}
