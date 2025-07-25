package skillbuilder.coding.normal;

public class ReverseANumber {
    public static void main(String[] args) {
        int num=34352;
        reverseNumApproach1(num); // 25343
    }
    private static void reverseNumApproach1(int num){
        int sum=0;
        while (num!=0){
            int r=num%10;
            sum=(sum*10)+r;
            num=num/10;
        }
        System.out.println(sum);
    }
}
