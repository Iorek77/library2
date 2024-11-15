package library2;

import static library2.Library2.input;
import static library2.Library2.userlist;

public class User {

    String nickname, username, email, phone, id;

    public User(String username, String email, String phone, String id) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static User registro() {
        String username, email, phone, id;
        System.out.println("Registro de usuario.");
        System.out.println("Ingrese nombre y apellido.");
        username = input.nextLine();
        System.out.println("Ingrese E-Mail.");
        email = input.nextLine();
        System.out.println("Ingrese numero de telefono.");
        phone = input.nextLine();
        System.out.println("Ingrese cedula.");
        id = input.nextLine();
        return new User(username, email, phone, id);
    }

    public static User showuser(User s) {
        System.out.println("Datos de usuario: ");
        System.out.println("Nombre");
        System.out.println(s.getUsername());
        System.out.println("E-Mail");
        System.out.println(s.getEmail());
        System.out.println("Telefono");
        System.out.println(s.getPhone());
        System.out.println("Cedula");
        System.out.println(s.getId());
        return s;
    }

    public static void edituser() {
        int useredit, parametrouser, counter = 0;
        boolean userdelete = false;
        if (!userlist.isEmpty()) {
            System.out.println("Elija usuario a modificar.");
            for (User b : userlist) {
                System.out.println(counter + " " + b.getUsername() + " " + b.getId());
                counter++;
            }
            useredit = input.nextInt();
            input.nextLine();
            do {
                System.out.println("Que parametro modificar?\n1. Nombre\n2. E-Mail\n3. Telefono\n4. Cedula\n5. Borrar\n6. Salir");
                parametrouser = input.nextInt();
                input.nextLine();
                switch (parametrouser) {
                    case 1:
                        String newname;
                        System.out.println("Nombre actual: " + userlist.get(useredit).getUsername());
                        System.out.println("Ingrese nombre nuevo: ");
                        newname = input.nextLine();
                        userlist.get(useredit).setUsername(newname);
                        break;
                    case 2:
                        String newemail;
                        System.out.println("E-Mail actual: " + userlist.get(useredit).getEmail());
                        System.out.println("Ingrese E-Mail nuevo: ");
                        newemail = input.nextLine();
                        userlist.get(useredit).setEmail(newemail);
                        break;
                    case 3:
                        String newphone;
                        System.out.println("Telefono actual: " + userlist.get(useredit).getPhone());
                        System.out.println("Ingrese telefono nuevo: ");
                        newphone = input.nextLine();
                        userlist.get(useredit).setPhone(newphone);
                        break;
                    case 4:
                        String newid;
                        System.out.println("Cedula actual: " + userlist.get(useredit).getId());
                        System.out.println("Ingrese cedula nueva: ");
                        newid = input.nextLine();
                        userlist.get(useredit).setId(newid);
                        break;
                    case 5:
                        System.out.println("Desea borrar el usuario: " + userlist.get(useredit).getUsername() + userlist.get(useredit).getId() + "?");
                        System.out.println("1. Si\n2. No");
                        int confirmation;
                        confirmation = input.nextInt();
                        input.nextLine();
                        switch (confirmation) {
                            case 1:
                                System.out.println(userlist.get(useredit).getUsername() + userlist.get(useredit).getId() + " es historia.");
                                userlist.remove(useredit);
                                userdelete = true;
                                break;
                            case 2:
                                System.out.println("Cancelar.");
                                break;
                        }
                }
            } while (parametrouser != 6 && userdelete == false);
        } else {
            System.out.println("No hay usuarios registrados.");
        }
    }
}
