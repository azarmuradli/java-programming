package linear;

import linear.algebra.GaussianElimination;

public class EquationSolver {
    public static void main(String[] args) {
        if(args.length==0) {
            System.out.println("You should provide values of equation");
        }
        else {
            int rows = args.length;
            int cols = args[0].split(",").length;
            double[][] matrix = stringToDoubles(args,rows,cols);
            GaussianElimination ge = new GaussianElimination(rows, cols, matrix);
            ge.print();
            System.out.println("");
            ge.rowEchelonForm();
            System.out.println("");
            ge.print();
            ge.backSubstitution();
            System.out.println("");
            ge.print();
        }
      
    }

    public static double[][] stringToDoubles(String[] args,int rows,int cols) {
        double[][] matrix = new double[rows][cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                matrix[i][j] = Double.parseDouble(args[i].split(",")[j]);
                
            }
        }
        return matrix;
    }


}
