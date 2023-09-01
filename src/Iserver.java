import java.util.ArrayList;

public interface Iserver {
    void menu(String loggedStatus);
    void registration(ArrayList<User>dataBase);
    void logIn(ArrayList<User>dataBase);
    void logOut();
    void shutDownServer();
}
