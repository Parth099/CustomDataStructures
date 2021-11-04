package Map.IndexBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class IndexBuilder {
    public static final Pattern pattern = Pattern.compile("[\\w\\d]+");
    HashMap<String, List<Integer>> index = new HashMap<String, List<Integer>>();


    public void indexBuilder(Scanner Scan){
        int lineNum = 0;
        String token;
        List<Integer> indexLoc;
        while(Scan.hasNext()){
            lineNum++;
            while((token = Scan.findInLine(pattern)) != null){
                token = token.toLowerCase();
                indexLoc = index.getOrDefault(token, new LinkedList<>());
                indexLoc.add(lineNum);
                index.put(token, indexLoc);
            }
            Scan.nextLine();
        }
    }

    public static void main(String[] args) {
        IndexBuilder IB = new IndexBuilder();
        try {
            Scanner s = new Scanner(new File("src/Map/IndexBuilder/words.txt"));
            IB.indexBuilder(s);
            System.out.println(IB.index);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
