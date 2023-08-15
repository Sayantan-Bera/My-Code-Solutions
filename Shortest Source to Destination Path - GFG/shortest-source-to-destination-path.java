//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        int[] dRow={1,0,-1,0};
        int[] dCol={0,1,0,-1};
        boolean[][] visited=new boolean[N][M];
        Queue<Pair> q=new LinkedList<Pair>();
        if(A[0][0]==0 || A[X][Y]==0)return -1;
        visited[0][0]=true;
        int min=Integer.MAX_VALUE;
        q.add(new Pair(0,0,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.x;
            int c=p.y;
            int t=p.t;
            if(r==X && c==Y){
                        min=Math.min(min,t);
                    }
            for(int i=0;i<4;i++){
                int nr=r+dRow[i];
                int nc=c+dCol[i];
                if(nr>=0 && nr<N && nc>=0 && nc<M && A[nr][nc]==1 && visited[nr][nc]==false){
                    
                        visited[nr][nc]=true;
                        q.add(new Pair(nr,nc,t+1));
                    
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
};

class Pair{
    int x,y,t;
    Pair(int r,int c,int ti){
        x=r;
        y=c;
        t=ti;
    }
}