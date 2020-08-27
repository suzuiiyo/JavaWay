#include<stdio.h>
    int main() {
        const int N=100;
        int c[N][N];

        void multi(int a[][N], int b[][N], int n) //nÊÇ¾ØÕó´óĞ¡, n<N
        {
            meset(c, 0, sizeof c);
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; i++){
                    for(int k=1; k<=n; k++)
                        c[i][j] += a[i][k]*b[k][j];
                }
            }
        }
    }