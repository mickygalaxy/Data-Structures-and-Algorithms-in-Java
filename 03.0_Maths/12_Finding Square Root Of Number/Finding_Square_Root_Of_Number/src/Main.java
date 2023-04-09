
//                                                                       Square Root

/*
 - Given a positive number n and precision p, find the square root of number upto p decimal places using binary search.

    Examples:

Input : number = 50, precision = 3
Output : 7.071

Input : number = 10, precision = 4
Output : 3.1622

We have discussed how to compute the integral value of square root in Square Root using Binary Search
Approach :
1) As the square root of number lies in range 0 <= squareRoot <= number, therefore, initialize start and end as : start = 0, end = number.
2) Compare the square of the mid integer with the given number. If it is equal to the number,  the square root is found. Else look for the same in the left or right side depending upon the scenario.
3) Once we are done with finding an integral part, start computing the fractional part.
4) Initialize the increment variable by 0.1 and iteratively compute the fractional part up to P places. For each iteration, the increment changes to 1/10th of its previous value.
5) Finally return the answer computed.
Below is the implementation of above approach :

Time Complexity : The time required to compute the integral part is O(log(number)) and constant i.e, = precision for computing the fractional part. Therefore, overall time complexity is O(log(number) + precision) which is approximately equal to O(log(number)).

Auxiliary Space: O(1) since it is using constant space for variables

 */




import java.util.Scanner;
public class Main implements SqaureRoot{
static Scanner sc = new Scanner(System.in);

    @Override
    public float BruteForceApproach(int n,int p) {
        for(int i=2;i*i<=n;i++){
            if(i*i==n){
                return i;
            }
        }

        double ans = (float)0.0;
        double increment = (float)0.1;
        for (int i = 0; i < p; i++) {
            while (ans * ans <= n) {
                ans += increment;
            }

            // loop terminates when ans * ans > number
            ans = ans - increment;
            increment = increment / 10;
        }
        return (float)ans;
    }

    @Override
    public float BinarySearchApproach(int n,int p) {
       int left = 2;
       int right = n;
        // for computing integral part
        // of square root of number
       while(left<=right){
           int mid = (left+right)/2;

           if(mid*mid==n){
               return mid;
           }
           if(mid*mid>n){
               right--;
           }
           else {
               left++;
           }
       }
        // variable to store the answer
        double ans = (float)0.0;
        double increment = (float)0.1;
        for (int i = 0; i < p; i++) {
            while (ans * ans <= n) {
                ans += increment;
            }

            // loop terminates when ans * ans > number
            ans = ans - increment;
            increment = increment / 10;
        }
        return (float)ans;
    }

    @Override
    public float Newton_Raphson_Method(int n, float l) {

        // Assuming the sqrt of n as n only
        float x = n;

        // The closed guess will be stored in the root
        float root;

        // To count the number of iterations
        int count = 0;

        while (true)
        {
            count++;

            // Calculate more closed x
            root = (float)0.5 * (x + (n / x));

            // Check for closeness
            if (Math.abs(root - x) < l)
                break;

            // Update root
            x = root;
        }

        return root;
    }

    // Driver code
    public static void main(String[] args) {
        System.out.print("Enter the number :- ");
        int n = sc.nextInt();
        System.out.print("\n Enter the precision time :- ");
        int p = sc.nextInt(); // precision time
        System.out.print("\n Tolerance limit :- ");
        float l = sc.nextFloat(); // eg :- 0.002,0.003
        SqaureRoot Obj = new Main();
        System.out.println("\n By Using First Method Brute Force Approach (Linear Search)  :- ");   // Time complexity 0(n)
       System.out.println(Obj.BruteForceApproach(n,p) +" ");
        System.out.println("\n By Using Second Method Binary Search Approach  :- ");  // Time complexity 0(log(n))
        System.out.println(Obj.BinarySearchApproach(n,p) +" ");
        System.out.println("\n By Using Third Method Newton's Raphson Method  :- ");  // Time complexity 0(log(n))
        System.out.println(Obj.Newton_Raphson_Method(n,l) +" ");

    }
}