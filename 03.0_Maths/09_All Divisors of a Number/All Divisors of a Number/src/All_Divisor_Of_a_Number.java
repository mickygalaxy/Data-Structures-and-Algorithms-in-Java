public interface All_Divisor_Of_a_Number {

    public void Naive_Approach(int n);

    /*   Efficient Solution

    1) Divisors always appear in pairs
       30 : (1,30),(2,15),(3,10),(5,6)
    2) One of the divisors in every pair is smaller than or equal to n^1/2
           For a pair (x,y)
              X * Y = n
           Let X be the smaller, i.e.
              X * X <= n
              x <= n^1/2
     */

    public void Optimize_Approach(int n);


}
