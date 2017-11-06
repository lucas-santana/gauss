import java.text.DecimalFormat;

public class Metodos {

    static DecimalFormat decimalFormat = new DecimalFormat();

    public Metodos() {
        decimalFormat.setMinimumFractionDigits(2);
    }

    public static double[] triangularInferior(int n, double mat[][], double b[]) {

        double x[] = new double[n];
        double soma = 0.0;
        x[0] = b[0] / mat[0][0];

        for (int i = 1; i < n; i++) {
            soma = 0.0;

            for (int j = 0; j < i; j++) {
                soma = soma + mat[i][j] * x[j];
            }

            x[i] = (b[i] - soma) / mat[i][i];
        }
        return x;
    }


    public static double[] triangularSuperior(int n, double mat[][], double b[]) {

        double x[] = new double[n];
        double soma = 0.0;
        x[n - 1] = b[n - 1] / mat[n - 1][n - 1];

        for (int i = n - 2; i >= 0; i--) {
            soma = 0.0;

            for (int j = n - 1; j >= 0; j--) {
                soma = soma + mat[i][j] * x[j];
            }

            x[i] = (b[i] - soma) / mat[i][i];
        }
        return x;

    }

    public static double[] gauss(int n, double mat[][], double b[]) {
        double m;
        double x[] = new double[n];

        for (int k = 0; k <= n - 1; k++) {
            for (int i = k + 1; i < n; i++) {
                m = mat[i][k] / mat[k][k];

                for (int j = k; j < n; j++) {
                    mat[i][j] = mat[i][j] - m * mat[k][j];
                }
                b[i] = b[i] - m * b[k];
            }

        }

        x = triangularSuperior(n, mat, b);
        return x;
    }

    public static void trocaLinhas(int k, int r, double mat[][]) {
        double aux;
        for (int i = 0; i < mat.length; i++) {
            aux = mat[k][i];
            mat[k][i] = mat[r][i];
            mat[r][i] = aux;
        }
        //System.out.println("--------------Troca de Linhas-----------------");
    }

    public static double[] gaussComPivotamentoParcial(int n, double mat[][], double b[]) {
        double m;

        //maior e posição do maior valor da coluna abaixo do pivo
        int r=0;
        double w;

        double x[] = new double[n];

        for (int k = 0; k <= n - 1; k++) {

            w = mat[k][k];

            //achar o maior elemento
            for (int j = k; j < n-1; j++) {
                if (mat[j][k] > w) {
                    w = mat[j][k];
                    r = j;
                }
            }
           // System.out.println("--------------Operação-----------------");
            //imprimirMatriz(mat);
            trocaLinhas(k,r,mat);

           // imprimirMatriz(mat);

            for (int i = k + 1; i < n; i++) {

                /*String valor = String.format("%.2f",(mat[i][k] / mat[k][k]));

                m = Double.parseDouble(valor.replace(",","."));*/

                m = mat[i][k] / mat[k][k];
                for (int j = k; j < n; j++) {
                    mat[i][j] =  mat[i][j] - m * mat[k][j];
                }
                b[i] = b[i] - m * b[k];
            }

        }

        x = triangularSuperior(n, mat, b);
        return x;

    }

    public static void imprimirVetor(double vetor[]) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

    public static void imprimirMatriz(double matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print("\t " + matriz[i][j]);
            }
            System.out.println();
        }
    }
}
