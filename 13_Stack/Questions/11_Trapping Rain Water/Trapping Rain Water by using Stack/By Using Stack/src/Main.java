import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static public void setData(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
    }


    static public int maxWater(int[] height){
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            while((!stack.isEmpty()) && (height[stack.peek()]< height[i])){
                int pop_height = height[stack.peek()];
                stack.pop();
                if(stack.isEmpty()) break;
                int distance = i-stack.peek()-1;
                int min_height = Math.min(height[stack.peek()],height[i]) - pop_height;
                ans+= distance*min_height;
            }
            stack.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int size = sc.nextInt();
        int[] array = new int[size];
        setData(array);
        System.out.println(maxWater(array));

    }
}