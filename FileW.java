import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileW {
    public static boolean writeToFile(String S, File F) throws IOException {
        FileWriter writer = new FileWriter(F, true);
        try{
            writer.write(S);
            writer.close();
        }catch (IOException E){
            System.out.println("Failure to Write: "+S);
            return false;
        }
        return true;
    }

    public static String readFromFile(File F) throws FileNotFoundException {
        Scanner fS = new Scanner(F);
        StringBuilder sb = new StringBuilder();
        while(fS.hasNext()){
            sb.append(fS.nextLine());
        }
        return sb.toString();
    }
    public static void main(String[] args) throws FileNotFoundException {
        File F = new File("src/zeta.txt");
        try {
            writeToFile("Text3", F);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(readFromFile(F));

    }
}
