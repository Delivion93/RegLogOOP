public class Main {
    public static void main(String[] args) {
        Server server =new Server();
        while (!Server.isExit()){
            server.menu(server.getLoggedStatus());
        }
    }
}