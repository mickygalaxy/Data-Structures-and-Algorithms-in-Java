
//                                                         Chocola Problem
/*

we are given a bar of chocolate compound of mxn square pieces. One should break the chocolate into single square.
each break of a part of the chocolate is changed a cost expressrd by a positive integer. this cost does not depend on the size of the part that is being
broken but only depends on the line the break goes along. let as denote the costs of breaking along consecutive vertical line with x1,x2,x3,----xm-1 and along
horizontal line with y1,y2,y3,--------yn-1 . compute the minimum cost of breaking the whole choclate into single square.
 */

/*
Time Complexity :- O(n log(n))
Space Complexity :- O(1)
 */


import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the total number of row :- ");
        int n = sc.nextInt();
        System.out.print("Enter the total number of column :- ");
        int m = sc.nextInt();
        Integer[] costHorizontal =  new Integer[n-1];
        Integer[] costVertical   =  new Integer[m-1];
        setData(costHorizontal,n-1);
        setData(costVertical,m-1);
       System.out.println("Total Minimum Cost :- "+ optimalSolution(costHorizontal,costVertical));
    }

    private static int optimalSolution(Integer[] costHorizontal, Integer[] costVertical) {
        int cost = 0;
        Arrays.sort(costVertical, Comparator.reverseOrder());
        Arrays.sort(costHorizontal, Comparator.reverseOrder());
        int h = 0, v = 0;
        int hp = 1, vp = 1;

        while(h<costHorizontal.length && v<costVertical.length){
            if(costVertical[v]<=costHorizontal[h]){
                cost+= (costHorizontal[h]*vp);
                hp++;
                h++;
            }else{
                cost+= (costVertical[v]*hp);
                vp++;
                v++;
            }
        }

        while(h<costHorizontal.length){
            cost+= (costHorizontal[h]*vp);
            hp++;
            h++;
        }
        while(v<costVertical.length){
            cost+= (costVertical[v]*hp);
            vp++;
            v++;
        }
        return cost;
    }

    private static void setData(Integer[] cost,int size){
        for(int i=0;i<size;i++){
            cost[i] = sc.nextInt();
        }
    }
}