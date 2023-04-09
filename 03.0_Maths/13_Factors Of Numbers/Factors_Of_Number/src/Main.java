import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements Factors{
    static Scanner sc = new Scanner(System.in);
    @Override
    public void BruteForceApproach(int n) {   // Time Complexity :- 0(n),Space Complexity :- 0(1)
        for(int i=1;i<=n;i++){
            if(n%i==0){
                System.out.print(i+" ");
            }
        }
    }

    @Override
    public void Optimize_BruteForceApproach(int n) { // Time Complexity :- 0(sqrt(n)),Space Complexity :- 0(1)
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(n/i == i){
                    System.out.print(i+ " ");
                }else{
                System.out.print(i+ " " +n/i+ " ");
            }
            }
        }
    }

    @Override
    public void Optimize_BruteForceApproach_ProperOrder(int n) { // Time Complexity :- 0(sqrt(n)),Space Complexity :- 0(sqrt(n))
        List<Integer> l = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(n/i == i){
                    System.out.print(i+ " ");
                }else{
                    System.out.print(i+ " ");
                    l.add(n/i);
                }
            }
        }
        for(int i=l.size()-1;i>=0;i--){
            System.out.print(l.get(i)+ " ");
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        Main Obj = new Main();
        Obj.BruteForceApproach(n);
        System.out.println("\n-------------------------------------");
        Obj.Optimize_BruteForceApproach(n); // this is not give me proper sequence order
        System.out.println("\n-------------------------------------");
        Obj.Optimize_BruteForceApproach_ProperOrder(n); // this is a proper sequence order
    }
}