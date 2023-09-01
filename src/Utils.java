import java.util.Scanner;

public class Utils {
    public static String passwd(){
        Scanner scanner =new Scanner(System.in);
        System.out.println("enter your passwod");
        String pas1 = scanner.nextLine();
        System.out.println("repeat password");
        String pas2 = scanner.nextLine();
        if(pas1.equals(pas2)){
            return pas1;
        }
        System.out.println("passwords is not match");
        return passwd();
    }
}
