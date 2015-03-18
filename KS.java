public class KS{

  public static int[][] Knapsack(int [] w, int [] v, int capacity){

    int [][]m = new int[w.length+1][capacity+1];

    // Initialize our base case so the first loop iteration
    // can fall back to this.
    for (int j = 0; j <= capacity; j++){
      m[0][j] = 0;
    }

    // Dynamic Programming loop
    for (int i = 1; i <= w.length; i++){
      for (int j = 0; j <= capacity; j++){

        if (w[i-1] <= j){
          m[i][j] = Math.max(m[i-1][j],m[i-1][j-w[i-1]]+v[i-1]);
        } else{
          m[i][j] = m[i-1][j];
        }
      }
    }

  return m;
  }

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

  static void printResults(int table[][], int [] weights, int [] values){

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

    printArray(table);

  }

  public static void main(String [] args){

    int [] weights = {2,3,4,5};
    int [] values  = {3,7,2,9};
    int capacity = 5;

    int [][] table = KS.Knapsack(weights, values, capacity);

    printResults(table,weights,values);
  }

}
