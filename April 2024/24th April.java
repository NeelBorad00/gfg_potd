//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    static final int MOD = 1000000007;

    public static int ways(int x, int y) {
        // Create a 2D array to store the number of ways to reach each point
        int[][] dp = new int[x + 1][y + 1];

        // Base case initialization
        dp[0][0] = 1; // Starting point

        // Fill the dp table
        for (int i = 0; i <= x; ++i) {
            for (int j = 0; j <= y; ++j) {
                if (i == 0 && j == 0) continue; // Skip the starting point
                // The number of ways to reach dp[i][j] is from dp[i-1][j] (left) + dp[i][j-1] (down)
                dp[i][j] = (i > 0 ? dp[i - 1][j] : 0) + (j > 0 ? dp[i][j - 1] : 0);
                dp[i][j] %= MOD; // Take modulo to prevent overflow
            }
        }

        return dp[x][y]; // Return the number of ways to reach (x, y)
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    int x=Integer.parseInt(elements[0]);
		    int y=Integer.parseInt(elements[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.ways(x,y));
		}
	}
}
// } Driver Code Ends
