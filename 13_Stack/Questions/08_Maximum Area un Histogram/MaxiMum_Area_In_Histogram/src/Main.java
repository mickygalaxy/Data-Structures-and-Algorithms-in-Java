
//                                         Max Area inn Histogram


//Time Complexity :- O(n)

import java.util.Scanner;
import java.util.Stack;

public class Main {
static  Scanner sc = new Scanner(System.in);


    public static void maxArea(int[] a,int size){
       int maxArea = 0;
       int NextSmallerLeft[]  =  new int[size];
       int NextSmallerRight[] = new int[size];

       //Next Smaller Right -Time Complexity :- O(n)
        Stack<Integer> s = new Stack<>();

        for(int i=a.length-1; i>=0; i--){
            while(!s.isEmpty() && a[s.peek()] >= a[i]){
                s.pop();
            }
            if(s.isEmpty()){
                NextSmallerRight[i]= a.length;
            }else {
                NextSmallerRight[i]= s.peek();
            }
            s.push(i);
        }

        // Next Smaller left   -Time Complexity :- O(n)
        s = new Stack<>();
        for(int i=0;i<size;i++){
            while(!s.isEmpty() && a[s.peek()] >= a[i]){
                s.pop();
            }
            if(s.isEmpty()){
                NextSmallerRight[i]= a.length;
            }else {
                NextSmallerRight[i]= s.peek();
            }
            s.push(i);
        }
        //-Time Complexity :- O(n)
        for(int i =0;i<size;i++){
            int height = a[i];
            int width = NextSmallerRight[i]-NextSmallerLeft[i]-1;
            int currArea = height*width;
            maxArea = Math.max(currArea,maxArea);
        }
        System.out.println("max area in histogram=" +maxArea);

        }


    public static void main(String[] args) {
    System.out.println("Enter the Size Of histogram :-");
    int size = sc.nextInt();
    int[] heights = new int[size];
    for(int i=0;i<size;i++){
        heights[i] = sc.nextInt();
    }
    maxArea(heights,size);
    }
}