import DataManager.IndexChecker.IndexChecker;

import org.json.*;

class JsonEncodeDemo {

    public static void main(String[] args) {
        JSONObject obj = new JSONObject();

        obj.put("name", "foo");
        obj.put("num", 100);
        obj.put("balance", 1000.21);
        obj.put("is_vip", true);

        System.out.print(obj);
    }
}
public class Main {
    public static void main(String[] args) {

        
    }
}
