public interface Computing_Power {

    public void naiveSolution(int x,int n);

    /*     Efficient Solution

    power(x,n) = { if n%2 == 0
                     power(x,n/2) * power(x,n/2)
                   else
                     power(x,n-1) * x

     */

    public int power(int x,int n);

}
