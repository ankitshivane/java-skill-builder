package skillbuilder.coding.strings;

public class NonRepeatedChar {
    /**
     * Ques: Find First non repeated character in string
     */
    public static void main(String[] args) {
        String in="software services";
        findFirstNonRepeatedChar1(in);
    }

    private static void findFirstNonRepeatedChar1(String in) {
        in=in.replaceAll("\\s","").toLowerCase().trim();
        char[] chars=in.toCharArray();
        Character nonRep=chars[0];
        for(int i=0;i<in.length();i++){
            for(int j=i+1;j<chars.length;j++){
                if(chars[j]==nonRep){
                    nonRep=in.charAt(i+1);
                    break;
                }
            }
        }
        System.out.println(nonRep);
    }
}
