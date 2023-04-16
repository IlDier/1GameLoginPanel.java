package DataManager.IndexChecker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class IndexChecker {
    public static int Index ;
    private static File file = new File("D:/JavaProjects/ApProjectSpring2023/src/DataManager/IndexChecker/Index.txt");

    public static int  getIndex(){
        int index = -1;
        try {
            Scanner reader = new Scanner(file);
            String line = reader.nextLine();
           index  = Integer.parseInt(line);
            reader.close();
        } catch (Exception o) {}
        return index;
    }
    public static void setIndex(int index){
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Integer.toString(index));
            bw.close();
            fw.close();
        } catch (Exception o ){}
    }

}
