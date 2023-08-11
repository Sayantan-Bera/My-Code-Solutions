//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        long[][] dp=new long[N][sum+1];
        for(long[] k:dp)
        Arrays.fill(k,-1);
        f(coins,N-1,sum,dp);
        return dp[N-1][sum];
    }
    long f(int coins[], int ind, int sum,long[][] dp){
        if(ind<0 || sum<0)return 0;
        if(sum==0)return 1;
        if(dp[ind][sum]!=-1)return dp[ind][sum];
        long notpick=f(coins,ind-1,sum,dp);
        long pick=0;
        if(sum>=coins[ind]){
            pick=f(coins,ind,sum-coins[ind],dp);
        }
        return dp[ind][sum]=pick+notpick;
    }
}