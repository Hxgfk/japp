package com.hxgfk.ai;

import java.util.Arrays;

public class ActivationFunction {
    public static double sum(double[] x){
        double total = 0;
        for (double n : x){
            total = total + n;
        }
        return total;
    }

    public static double tanh(double x){
        double eA = Math.E;
        double eB = Math.E;
        for (int i=0;i<x-1;i++){
            eA = eA * eA;
        }
        for (int i=0;i<-x;i++){
            eB = eB * eB;
        }
        return (eA-eB)/(eA+eB);
    }

    public static double sigmoid(double x){
        double e = Math.E;
        for (int i=0;i<-x;i++){
            e = e * e;
        }
        e = e + 1;
        return 1 / e;
    }

    public static double ReLU(double x){
        return Math.max(0, x);
    }

    public static double LeakyReLU(double x, double leak){
        return Math.max(0, x)+leak*Math.min(0, x);
    }

    public static double rrelu(double x, double a){
        return Math.max(a*x, x);
    }

    public static double RReLU(double x){
        return Math.max(0.25*x, x);
    }

    public static double PReLU(double x, double a){
        return Math.max(0, x)+a*Math.min(0, x);
    }

    public static double PReLU(double x){
        return Math.max(0, x)+0.25*Math.min(0, x);
    }

    public static double ELU(double x, double a){
        return Math.max(0, x)+Math.min(0, a*Math.exp(x)-1);
    }

    public static double ELU(double x){
        return Math.max(0, x)+Math.min(0, 0.25*Math.exp(x)-1);
    }

    public static double CELU(double x, double a){
        return Math.max(0, x)+Math.min(0, a*(Math.exp(x/a)-1));
    }

    public static double CELU(double x){
        return Math.max(0, x)+Math.min(0, 0.25*(Math.exp(x/0.25)-1));
    }

    public static double SELU(double x, double scale, double a){
        return scale* CELU(x, a);
    }

    public static double SELU(double x, double scale){
        return scale* CELU(x);
    }

    public static double GELU(double x){
        return 0.5 * x * (1 + tanh(Math.sqrt(2 / Math.PI) * (x + 0.044715 * Math.pow(x, 3))));
    }

    public static double ReLU6(double x){
        return Math.min(Math.max(0, x), 6);
    }

    public static double softsign(double x){
        return x/(1+Math.abs(x));
    }

    public static double softplus(double x){
        double e = Math.E;
        for (int i=0;i<x;i++){
            e = e * e;
        }
        return Math.log(1+e);
    }

    public static double[] softMax(double[] x){
        double total = Arrays.stream(x).max().getAsDouble();
        double[] output = new double[x.length];
        for (int i=0;i<x.length;i++){
            output[i] = Math.exp(x[i]) / total;
        }
        return output;
    }

    public static double[] softMin(double[] x){
        double total = Arrays.stream(x).max().getAsDouble();
        double[] output = new double[x.length];
        for (int i=0;i<x.length;i++){
            output[i] = Math.exp(-x[i]) / total;
        }
        return output;
    }

    public static double[] logSoftMax(double[] x){
        double total = Arrays.stream(x).max().getAsDouble();
        double[] output = new double[x.length];
        for (int i=0;i<x.length;i++){
            output[i] = Math.log(Math.exp(-x[i]) / total);
        }
        return output;
    }

    public static double hardTanh(double x){
        if (x > 1) {
            return 1;
        }
        if (x < -1){
            return -1;
        }else {
            return x;
        }
    }

    public static double tanhShrink(double x){
        return x-tanh(x);
    }

    public static double softShrink(double x, double v){
        if (x > v){
            return x-v;
        }
        if (x < -v){
            return x+v;
        }else {
            return 0;
        }
    }

    public static double hardShrink(double x, double v){
        if (x > v || x < -v){
            return x;
        }else {
            return 0;
        }
    }

    public static double logSigmoid(double x){
        return Math.log(1/(1+Math.exp(-x)));
    }
}
