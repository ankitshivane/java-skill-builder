package skillbuilder.coding.strings_programs;

public class ReverseStr {
    /**
     * Ques: reverse a string in java
     *
     */
    public static void main(String[] args) {
       String input="java concept";
       reverseStr1(input);
       reverseStr2(input);
    }

    private static void reverseStr1(String input) {
        StringBuilder sb=new StringBuilder(input);
        System.out.println(sb.reverse().toString());// OUTPUT: tpecnoc avaj
    }
    private static void reverseStr2(String input) {
        input=input.replaceAll("\\s+","").toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(int i=input.length()-1;i>=0;i--){
//            System.out.println("input.charAt(i)="+input.charAt(i)+",i="+i);
            sb.append(input.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
