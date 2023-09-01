import java.util.ArrayList;


public class ListTools {
    public static int findUser(ArrayList<User> dataBase, String userName){
        for (int i = 0; i < dataBase.size(); i++) {
            if(dataBase.get(i).getName().equals(userName)){
                return i;
            }
        }
        return -1;
    }


}
