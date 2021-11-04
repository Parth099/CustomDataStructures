package Map;

public class RandomHashMethods {
    public int STRhashCode(String c){
        int hash = 0;
        for(int i = 0; i < c.length();i++){
            hash += ((int)c.charAt(i) * Math.pow(31, c.length() - 1 - i));
        }
        return hash;
    }
}
