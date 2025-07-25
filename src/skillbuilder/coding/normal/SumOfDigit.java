package skillbuilder.coding.normal;

public class SumOfDigit {
    public static void main(String[] args) {
        int num=654910;
        sumOfDigit1(num); // 25
    }

    private static void sumOfDigit1(int num) {
        int sum=0;
        while (num!=0){
            int remainder=num%10;
            num=num/10; // will make the number short every time by dividing 10
            sum+=remainder;
        }
        System.out.println(sum);
    }
}
