import java.text.DecimalFormat;
import java.util.*;

class Matrix{
    private int row;//行
    private int col;//列
    //private double value;
    double [][]Data;

    public Matrix(int row, int col,double [][]Data) {
        this.row = row;
        this.col = col;
    //    this.value = value;
        this.Data = Data;
    }

    public void setMatrix(int row , int col, double value) {
        this.Data[row - 1][col - 1] = value;         //下标从0开始因此要-1
    }

    public double getMatrix(int row, int col) {
        return Data[row - 1][col - 1] ;
    }

    public int width() {
        return row;
    }

    public int height() {
        return col;
    }

    public Matrix add(Matrix b) {
        if(this.width() != b.width() && this.height() != b.height()) {    //行列不相等
            return null;
        }

        double add[][] = new double[this.row][this.col];
        for(int i = 0;i<col;i++) {
            for(int j = 0;j<row;j++) {
                add[i][j] = this.Data[i][j] + b.Data[i][j];
            }
        }

        Matrix another = new Matrix(this.col, this.row, add);    
        System.out.println("after add:");
        return another;
    }

    public Matrix multiply(Matrix b) {
        if(this.col != b.row) {
            return null;
        }

        double mul[][] = new double[this.row][b.col];
        double temp = 0;
        for(int i = 0;i<this.row;i++) {
            for(int k = 0;k<b.col;k++) {
                for(int j = 0;j<this.col;j++)
                    {
                        temp += this.Data[i][j] * b.Data[j][k];
                    }
                mul[i][k] = temp;
                temp = 0;
            }
        }

        Matrix another = new Matrix(this.row, b.col, mul);
        System.out.println("after multiply:");
        return another;

    }

    public Matrix transpose() {
        double tran[][] = new double[this.row][this.col];
        for(int i = 0;i<this.row;i++) {
            for(int j = 0;j<this.col;j++) {
                tran[j][i] = this.Data[i][j];
            }
        }

        Matrix another = new Matrix(this.col,this.row,tran);
        System.out.println("after transpose:");
        return another;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0");
        String result = "";

        //result += df.format(Data[0][0]);
        
        for(int i = 0; i<this.row; i++) {
            result += df.format(Data[i][0]);
            for(int j = 1; j<this.col; j++) {
                result += " " + df.format(Data[i][j]);
            }
            result +=  "\n";
        }
        return result;
    }
}

public class matrixClass {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请分别输入矩阵的行列，以回车结束");
        int row = scan.nextInt();
        int col = scan.nextInt();
        System.out.println("row:" + row +" column:" + col);
        //set value

        double data[][] = new double[row][col];
        for(int i = 0; i<row; i++) {
            for(int j = 0;j<col;j++) {
                System.out.printf("请输入矩阵元素:");
                double d = scan.nextDouble();
                data[i][j] = d;
            }
        }

        Matrix matrix = new Matrix(row,col,data);
        System.out.println("请输入要重置的元素的行列:");
        int srow = scan.nextInt();
        int scol = scan.nextInt();
        double sv = scan.nextDouble();
        System.out.println("after set value:");
        matrix.setMatrix(srow, scol, sv);      //行列分别减一，再赋值
        System.out.print(matrix);
        
        //get value
        DecimalFormat df = new DecimalFormat("0");
        System.out.println("\n请输入十进制下的行列:");
        int vrow = scan.nextInt();
        int vcol = scan.nextInt();
        System.out.print("value on (" + vrow + "," + vcol +"):");
        System.out.println(df.format(matrix.getMatrix(vrow, vcol)));

        //add
        int addrow = scan.nextInt();
        int addcol = scan.nextInt();
        double addMatrix[][] = new double[addrow][addcol];
        

        for(int i = 0; i<addrow; i++) {
            for(int j = 0; j<addcol; j++) {
                double ad = scan.nextDouble();
                addMatrix[i][j] = ad;
            }
        }

        Matrix add = new Matrix(addrow, addcol, addMatrix);
        System.out.print(matrix.add(add));

//        //mul
        int mulrow = scan.nextInt();
        int mulcol = scan.nextInt();
        double mulMatrix[][] = new double[mulrow][mulcol];    
        for(int i = 0; i<mulrow; i++) {
            for(int j = 0; j<mulcol; j++) {
                double mu = scan.nextDouble();
                mulMatrix[i][j] = mu;
            }
        }
        scan.close();

        Matrix mul = new Matrix(mulrow,mulcol,mulMatrix);
        //System.out.print(matrix.add(add));
        System.out.print(matrix.multiply(mul));
        //transpose
        System.out.print(matrix.transpose());
    }
}
