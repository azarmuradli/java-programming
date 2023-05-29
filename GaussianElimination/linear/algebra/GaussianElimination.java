package linear.algebra;

import java.util.Arrays;


public class GaussianElimination {

    private int rows;
    private int cols;
    private double[][] matrix;

    public GaussianElimination(int rows, int cols, double[][] matrix) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new double[rows][cols];
        setMatrix(matrix);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    
    public void setMatrix(double[][] newMatrix) {
        if (newMatrix.length != rows || Arrays.stream(newMatrix).anyMatch(row -> row.length != cols)) {
            throw new IllegalArgumentException("Matrix dimensions do not match provided rows and columns.");
        }
        this.matrix = newMatrix;
    }

    public void rowEchelonForm() {
        int h = 0;
        int k = 0;
        while(h<rows && k<cols) {
            int i_max = argMax(h,k);
            if(matrix[i_max][k]==0) {
                k+=1;
            }
            else {
                swapRows(h,i_max);
                for(int i=h+1;i<rows;i++) {
                    multiplyAndAddRow(i,h,k);
                }
                multiplyRow(h,k);
                h+=1;
                k+=1;
            }
        }
    }

    private int argMax(int h,int k) {
        int i_max = h;
        for(int i = h+1;i<rows;i++) {
            if(Math.abs(matrix[i][k])>Math.abs(matrix[i_max][k])) {
                i_max = i;
            }
        }
        return i_max;

    }

    private void swapRows(int h1,int h2) {
        double[] temp = matrix[h1];
        matrix[h1] = matrix[h2];
        matrix[h2] = temp;
    }

    private void multiplyAndAddRow(int addRowIndex, int mulRowIndex, int colIndex) {
        double ratio = matrix[addRowIndex][colIndex] /matrix[mulRowIndex][colIndex];
        matrix[addRowIndex][colIndex] = 0;
        for(int j=colIndex+1;j<cols;j++) {
            matrix[addRowIndex][j]-= matrix[mulRowIndex][j]*ratio;
        }
    }

    private void multiplyRow(int rowIndex, int colIndex) {
        double value = matrix[rowIndex][colIndex];
        for (int j = colIndex; j < cols; j++) {
            matrix[rowIndex][j] /= value;
        }
    }

    public void backSubstitution() {
        for(int i=rows-1;i>=0;i--) {
            if (matrix[i][i] == 0) {

                throw new IllegalArgumentException("The system of equations does not have a unique solution.");

            }
            for(int j=i-1;j>=0;j--) {
                multiplyAndAddRow(j,i,i);
            }
        }
    }

    private void checkMatrixDimensions(double[][] matrix) {

    }

    public void print() {
        String[] alphabet = {"x", "y", "z", "a", "b", "c"};
        for (int i = 0; i < rows; i++) {
            String equation = new String();
            for (int j = 0; j < cols; j++) {
                if(j == cols-1) {
                    equation+= "=" + Double.toString(matrix[i][j]) + " ";
                }
                else {
                    
                    if(j==0) {
                        if(matrix[i][j]>=0) {
                            equation+= "+" + Double.toString(matrix[i][j]) + alphabet[j];
                        }
                        else {
                            equation+= Double.toString(matrix[i][j]) + alphabet[j];
                        }
                        
                    }
                    else {
                        String sign = "+";
                        if(matrix[i][j]<0) {
                            sign = "-";
                        }
                        equation+= sign + Double.toString(Math.abs(matrix[i][j])) + alphabet[j];
                    }
                }
            }
            System.out.println(equation.toString());
        }
    }
    
}