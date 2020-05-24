    #include<iostream>
    #include<math.h>
    #include<stdio.h>
    #include<string.h>
    #include<stdlib.h>
    #include<algorithm>
    #define maxn 30
    using namespace std;
    struct Matrax{
        int  m[maxn][maxn];
    };
    Matrax a,per;
    int M=10000,n=2;
    void init(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                per.m[i][j]=(i==j);   //单位矩阵，任何矩阵乘以单位矩阵其值不变
            }
        }
    }
    Matrax multi(Matrax a,Matrax b){ //矩阵相乘：
        Matrax c;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                c.m[i][j]=0;
                for(int k=0;k<n;k++){
                    c.m[i][j]+=a.m[i][k]*b.m[k][j];
                }
                c.m[i][j]%=M;
            }
        }
        return c;
    }
    //矩阵快速幂 思想等同于 整数快速幂
    Matrax power(int k){
        Matrax c,p,ans=per;
        p=a;
        while(k){
            if(k&1){
                ans=multi(ans,p);
                k--;
            }else{
                k/=2;
                p=multi(p,p);
            }
        }
        return ans;
    }

    int main()
    {
        long long k;
        Matrax s,res;
        while(cin>>k){
                if(k==-1) break;
                if(k==0) {cout<<0<<endl;continue;}
            a.m[0][0]=1;a.m[0][1]=1;
            a.m[1][0]=1;a.m[1][1]=0;
            init();
            s=power(k);

            cout<<s.m[0][1]%M<<endl;

        }
        return 0;
    }