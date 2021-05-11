//TOLGA GUMUSCU
package com.company;
import java.util.Scanner;

public class Knapsack {

    static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    static int knapsack(int weight, int weight_arr[], int value_arr[], int n) {
        //defining our variables
        int i = 0, j = 0;
        int knap[][] = new int[n + 1][weight + 1];
        //knap is a temp array for us to create value table in bottom-up manner

        while(i<=n) {
            //implementing the table
            for (j = 0; j <= weight; j++) {
                if (i == 0 || j == 0)
                    //if any of them is zero, place zero to index
                    knap[i][j] = 0;
                else if (weight_arr[i - 1] <= j)
                    knap[i][j] = max(knap[i - 1][j],
                            value_arr[i - 1] + knap[i - 1][j - weight_arr[i - 1]]);
                    //we have two options in this line, we can select the previous item
                    //or we can add the next item
                else
                    knap[i][j] = knap[i - 1][j];
            }
            i++;
        }

        return knap[n][weight];
    }


    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int [] val = new int[3];
        int [] weight = new int[3];
        System.out.println("Please enter Values");
        for(int i=0; i<3; i++ ) {
            val[i] = s.nextInt();
        }
        System.out.println("Please enter Weights");
        for(int i=0; i<3; i++ ) {
            weight[i] = s.nextInt();
        }
        int w = 50, n = val.length;
        System.out.println("Answer: "+knapsack(w,weight,val,n));
    }
}
