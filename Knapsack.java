// Solution to the 0-1 Knapsack problem
// Runtime: O(nW), n = numItems, W = capacity of Knapsack
// Author: Matthew Voss
public class Knapsack{

  public static int[][] Knapsack(int [] w, int [] v, int capacity){
    int numItems = w.length;

    // One extra row on top for base case (so when the first
    // loop reverts to previous solution, there is one), and
    // an extra col so we have the zero col and max col = capacity
    int [][]m = new int[numItems+1][capacity+1];

    // Initialize our base case so the first loop iteration
    // can fall back to this.
    for (int j = 0; j <= capacity; j++){
      m[0][j] = 0;
    }

    // For all of our items
    for (int i = 1; i <= numItems; i++){
      for (int j = 0; j <= capacity; j++){
        // If the knapsack is big enough for item i
        if (w[i-1] <= j){
          m[i][j] = Math.max(m[i-1][j],m[i-1][j-w[i-1]]+v[i-1]);
        } 
        // Otherwise, just keep previous solution
        else{
          m[i][j] = m[i-1][j];
        }
      }
    }

  return m;
  }

  // Helper method to print a 2D array
  static void printArray(int[][]array){

    System.out.print("    ");
    for (int j = 0; j < array[0].length; j++){
      System.out.printf("[%2d]",j);
    }
    System.out.println();
    for (int i = 0; i < array.length; i++){
      System.out.printf("[%2d]",i);
      for (int j = 0; j < array[0].length; j++){
        System.out.printf("%4d",array[i][j]);
        
      }
      System.out.println();
    }
  }

  // Helper method to summarize input and print output
  static void printResults(int table[][], int [] weights, int [] values, int capacity){

    System.out.println("--------------------------------------------");
    System.out.println("Knapsack Problem Parameters");
    
    System.out.print("Weights: " );    
    for (int i = 0; i < weights.length; i++){
      System.out.print(weights[i] + " ");
    }
    System.out.println();

    System.out.print("Values: ");
    for (int i = 0; i < values.length; i++){
      System.out.print(values[i] + " ");
    }
    System.out.println();

    System.out.println("Knapsack capacity: " + capacity);
    System.out.println("Weights along top border, items on left border");
    System.out.println("--------------------------------------------");
    printArray(table);

  }


  // Driver main function
  public static void main(String [] args){

    // Input
    int [] weights = {2,3,4,5};
    int [] values  = {3,7,2,9};
    int capacity = 5;

    int [][] table = Knapsack(weights, values, capacity);

    printResults(table,weights,values, capacity);
  }

}
