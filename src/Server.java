import java.util.ArrayList;
import java.util.Scanner;


public class Server implements Iserver{
    static Scanner scanner = new Scanner(System.in);
    ArrayList<User>dataBase=new ArrayList<>();
    private String loggedUser="default";
    private String loggedStatus="default";
    private static boolean exit = false;

    public String getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }

    public String getLoggedStatus() {
        return loggedStatus;
    }

    public void setLoggedStatus(String loggedStatus) {
        this.loggedStatus = loggedStatus;
    }

    public static boolean isExit() {
        return exit;
    }

    public static void setExit(boolean exit) {
        Server.exit = exit;
    }


    @Override
    public void menu(String loggedStatus){
        if(loggedStatus.equals("User")){
            System.out.println("Menu:\n1 - Send email\n2 - Users list\n3 - LogOut");
            switch (scanner.nextLine()){
                case"1"-> System.out.println("You send an email");
                case "2"-> System.out.println("List method"); // do user list method
                case "3"->logOut();
                default -> System.out.println("incorrect input");
            }
        }
        else if(loggedStatus.equals("Admin")){
            System.out.println("Menu:\n1 - Send email\n2 - Users list\n3 - LogOut");
            switch (scanner.nextLine()) {
                case "1" -> System.out.println("You send an email");
                case "2" -> System.out.println("Super List method"); // do user list method
                case "3" -> logOut();
                default -> System.out.println("incorrect input");
            }
        }
        else {
            System.out.println("Menu:\n1 - LogIn\n2 - Registration\n3 - Exit");
            switch (scanner.nextLine()) {
                case "1" -> this.logIn(dataBase); //do LogIn method
                case "2" -> this.registration(dataBase); // do registration method
                case "3" -> shutDownServer();
                default -> System.out.println("incorrect input");
            }
        }
    }
    @Override
    public void registration(ArrayList<User> dataBase) {
        System.out.println("Input username to registration");
        String userName=scanner.nextLine();
        int userIndex = ListTools.findUser(dataBase,userName);
        if(userIndex==-1){
            String password = Utils.passwd();
            System.out.println("enter your email");
            String email = scanner.nextLine();
            System.out.println("enter your Role");
            String role = scanner.nextLine();
            User user = new User(userName,password,role,email);
            dataBase.add(user);
        }
        else{
            System.out.println("that Username is already exist");
        }
    }
    @Override
    public void logIn(ArrayList<User> dataBase) {
        System.out.println("enter your userName");
        String userName = scanner.nextLine();
        int userIndex = ListTools.findUser(dataBase,userName);
        if(userIndex!=-1){
            System.out.println("enter your password");
            String password = scanner.nextLine();
            if(dataBase.get(userIndex).getPassword().equals(password)){
                System.out.println("welcome "+dataBase.get(userIndex).getName());
                this.setLoggedStatus(dataBase.get(userIndex).getRole());
                this.setLoggedUser(dataBase.get(userIndex).getName());
            }
            else {
                System.out.println("incorrect password");
            }
        }
        else{
            System.out.println("user is not found");
        }
    }
    @Override
    public void logOut(){
        System.out.println("User "+this.getLoggedUser()+" was logged out");
        this.setLoggedStatus("LoggedOut");
        this.setLoggedUser("Non");
    }
    @Override
    public void shutDownServer(){
        System.out.println("Server is shutting down, good by :)");
        setExit(true);
    }







}
