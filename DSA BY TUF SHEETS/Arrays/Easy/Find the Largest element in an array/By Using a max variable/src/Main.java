
// Time Complexity :- O(n)
// Space Complexity :- O(1)


public class Main {
    public static int largest(int arr[], int n)
    {
        int max = arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]>=max){
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[]array = {5,7,2,3,6,1,9,0,10,55,22,11,1,0,9,7,6};
        System.out.println(largest(array,array.length));
    }
}