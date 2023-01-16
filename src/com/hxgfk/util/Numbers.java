package com.hxgfk.util;

public class Numbers {
    public static double sum(double[] x){
        double t = 0;
        for (double n : x){
            t += n;
        }
        return t;
    }

    public static double[][] matmul(double[][] x, double[][] y){
        double[][] z = new double[x.length][y[0].length];
        for(int i=0;i<x.length;i++) {
            for(int j=0;j<y[0].length;j++) {
                z[i][j] = 0;
                for(int k=0;k<x[0].length;k++){
                    z[i][j] = z[i][j] + x[i][k] * y[k][j];
                }
            }
        }
        return z;
    }

    public static int random(int max, int min){
        return (int) (Math.random()*max)-min;
    }

    public static int dot(int[] a, int[] b) throws Exception {
        if (a.length != b.length){
            throw new Exception();
        }else {
            int t = 0;
            for (int i=0;i<a.length;i++){
                t = a[i] * b[i];
            }
            return t;
        }
    }
}
