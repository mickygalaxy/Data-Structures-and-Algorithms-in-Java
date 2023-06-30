

//                                              Job sequencing Problem ( Solve By Greedy )

/*
Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline.
It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1. Maximize the total profit if only one job can be scheduled at a time.

Examples:

Input: Four Jobs with following deadlines and profits

 JobID       Deadline  Profit
  a            4          20
  b            1          10
  c            1          40
  d            1          30

Output: Following is maximum profit sequence of jobs: c, a

Input:  Five Jobs with following deadlines and profits

    JobID      Deadline      Profit

     a            2          100
     b            1          19
     c            2          27
     d            1          25
     e            3          15

Output: Following is maximum profit sequence of jobs: c, a, e

 */
/*
                            :~ Greedy approach for job sequencing problem ~:

Greedily choose the jobs with maximum profit first, by sorting the jobs in decreasing order of their profit.
This would help to maximize the total profit as choosing the job with maximum profit for every time slot will eventually maximize the total profit

Follow the given steps to solve the problem:
~ Sort all jobs in decreasing order of profit.
~ Iterate on jobs in decreasing order of profit.For each job , do the following :
~ Find a time slot i, such that slot is empty and i < deadline and i is greatest.Put the job in
~ this slot and mark this slot filled.
~ If no such i exists, then ignore the job.
 */
/*
Time complexity: O(totalJobs * log(totalJobs))  or O( n * log(n) )
Space complexity: O(totalJobs)                  or O( n )
 */


import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static class Job{
        int deadline;
        int profit;
        char Job;

        public Job(char Job , int deadline , int profit){

            this.Job = Job;
            this.deadline = deadline;
            this.profit = profit;

        }
    }

    /**
     * This method finds the optimal solution for the job scheduling problem.
     *
     * @param jobs The array of jobs.
     * @param totalJobs The total number of jobs.
     */
    public static void OptimalSolution(Job[] jobs,int totalJobs){
        // Sort the jobs array in descending order based on profit
        Arrays.sort(jobs, new Comparator<Job>() {
            public int compare(Job o1, Job o2) {
                return Integer.compare(o2.profit, o1.profit);
            }
        });
        // Initialize the total profit and time.
        int totalProfit = 0;
        int time = 0;
        // Create a list to store the jobs that are scheduled.
        List<Character> ans = new ArrayList<>();
        // Iterate over the sorted jobs array
        for(int i=0;i<totalJobs;i++){
            // If the deadline of the current job is greater than the current time,
            // then schedule the job and update the total profit and time.
            if(jobs[i].deadline > time){
                // Add the job to the selected jobs list
                ans.add(jobs[i].Job);
                totalProfit+=jobs[i].profit;
                time++;
            }
        }
        // Print the total profit
        System.out.println(totalProfit);
        // Print the selected jobs
        for (char i : ans){
            System.out.print(i);
        }
    }
    public static void main(String[] args) {
        int totalJobs = sc.nextInt();
        // Create an array to store the jobs.
        Job[] jobs = new Job[totalJobs];
        // Read job details from input
        for(int i=0;i<totalJobs;i++){
            char Job = sc.next().charAt(0);
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(Job,deadline,profit);
        }
        // Call the OptimalSolution method
        OptimalSolution(jobs,totalJobs);
    }
}