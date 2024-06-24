import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static String format(int kq[]) {
        String result = Arrays.stream(kq)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
        return "["+result+"]";
    }
        public static void rotate(int[] nums, int k) {
            int n = nums.length;
            int kq[]= new int [n];
            int x =0;
            if(k%n==0){
                System.out.println(format(nums));
            }else{
                if(k>n){
                    k = k%n;
                }
                for(int i =n-k;i<n;i++){
                    kq[x++] = nums[i];
                }
                for(int i =0;i<n-k;i++){
                    kq[x++] = nums[i];
                }
                System.out.println(format(kq));
            }
        }
    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7}, 10);
    }
}