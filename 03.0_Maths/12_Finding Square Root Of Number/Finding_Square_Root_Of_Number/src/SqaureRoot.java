public interface SqaureRoot {
    public float BruteForceApproach(int n,int p);
    public float BinarySearchApproach(int n,int p);

   // Find Square root of a number using Newton’s method
    public float Newton_Raphson_Method(int n,float l);

    /*

                                                           :Newton’s Method:
Let N be any number then the square root of N can be given by the formula:

 - root = 0.5 * (X + (N / X)) where X is any guess which can be assumed to be N or 1.

 In the above formula, X is any assumed square root of N and root is the correct square root of N.
 Tolerance limit is the maximum difference between X and root allowed.
 Approach: The following steps can be followed to compute the answer:


- Assign X to the N itself -
 Now, start a loop and keep calculating the root which will surely move towards the correct square root of N.
 Check for the difference between the assumed X and calculated root, if not yet inside tolerance then update root and continue.
 If the calculated root comes inside the tolerance allowed then break out of the loop.
 Print the root.
     */

}
