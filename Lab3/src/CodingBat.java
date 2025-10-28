public class CodingBat {
    public static void main(String[] args) {
        CodingBat cb = new CodingBat();
        System.out.println(cb.countEvens(new int[] {1,2,3,4,5,6,7,8,9,10}));
        System.out.println(cb.lastDigit(17, 777));
        System.out.println(cb.or35(33));
        System.out.println(cb.firstHalf("HelloThere"));

    }
    //generate test JUnit4, assertEquals
    public boolean lastDigit(int a, int b) {
        return a % 10 == b % 10;
    }

    public boolean or35(int n) {
        return n % 3 == 0 | n % 5 ==0;
    }
    public int countEvens(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 ==0){
                counter++;
            }
        }
        return counter;
    }

    public String firstHalf(String str) {
        String half_str = "";
        for (int i = 0; i < (str.length() / 2); i++) {
            half_str = half_str + str.charAt(i);
        }
        return half_str;
    }

}
