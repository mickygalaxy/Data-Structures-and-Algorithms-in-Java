
// Time Complexity :- O(n)
// Space Complexity :- O(1)

public class Main {
    public static int largest(int[] arr)
    {
        int ans = arr[0];
        int i = 0;
        int j = arr.length-1;
        while(i!=j){
            if(arr[i]>=arr[j]){
                ans = arr[i];
                j--;
            }
            else{
                ans= arr[j];
                i++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[]array = {5,7,2,3,6,1,9,0,10,55,22,11,1,0,9,7,6};
        System.out.println(largest(array));
    }
}