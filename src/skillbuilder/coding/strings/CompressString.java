package skillbuilder.coding.strings;

public class CompressString {
    public static void main(String[] args) {
        String s="aaabbaa";

        int l=0;
        int r=0;
        int n=s.length();
        System.out.println(n);
        int count=0;
        StringBuilder sb=new StringBuilder();

        while(r<n){
            if(s.charAt(l)==s.charAt(r)){
                count++;
                r++;
            }else{
                sb.append(s.charAt(l)+"").append(String.valueOf(count));
                l=r;
                r++;
                count=1;
            }
        }
        sb.append(s.charAt(l)+"").append(String.valueOf(count));
        System.out.println(sb.toString());
    }

}
