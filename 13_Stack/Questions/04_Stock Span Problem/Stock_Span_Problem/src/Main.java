import java.util.Scanner;
import java.util.Stack;

public class Main {


    public static void ByUsingStack(Integer[]Day,Integer[]Span,int TotalDays){
        Stack<Integer> s = new Stack<>();
        int idx = 0;    // this is first day index
        Span[0] = 1;   // 1 Day Span is 1 by default
        s.push(idx);
        for(int i=1;i<TotalDays;i++){
            int currPrice = Day[i]; // current day
            while(!s.isEmpty()&& currPrice>Day[s.peek()]){ // cheking currentprice is greater than previous price
                s.pop(); // removing less price upto be not get the higher price
            }
            if(s.isEmpty()){ // checking stack is empty
                Span[i] = i+1;
            }else{
                int prevHigh = s.peek();  // it's holding the previous Price of Stock
                Span[i] = i - prevHigh; // it is formula to find Span
            }
            s.push(i); // pusing currDay
        }
        System.out.println("Span :- ");
        System.out.print("|");
        for(Integer i : Span){ // Display all Days Spans
            System.out.print("|"+i+"|");
        }
        System.out.print("|");

    }
    static  Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the Total Days :- ");
       int Total_Days = sc.nextInt();
       Integer[]Day = new Integer[Total_Days];
       Integer[]Span = new Integer[Total_Days];
       System.out.println("Enter The Stacks Price :- ");
       for(int i=0;i<Total_Days;i++){
           System.out.print("Day - "+ (i+1)+ " :- ");
           Day[i] = sc.nextInt();
           System.out.println();
       }
       ByUsingStack(Day,Span,Total_Days);
    }
}