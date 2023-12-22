package labosi.dz123.sets;

import labosi.dz123.operations.IIntUnaryFunction;

public abstract class StandardFuzzySets {

    public static IIntUnaryFunction lFunction(int alpha, int beta) {
        return new IIntUnaryFunction() {
            @Override
            public double valueAt(int x) {
                if (x < alpha) return 1;
                else if (x >= beta) return 0;
                else return (double)(beta - x) / (beta - alpha);
            }
        };
    }

    public static IIntUnaryFunction gammaFunction(int alpha, int beta) {
        return new IIntUnaryFunction() {
            @Override
            public double valueAt(int x) {
                if (x < alpha) return 0;
                else if (x >= beta) return 1;
                else return (double)(x - alpha) / (beta - alpha);
            }
        };
    }

    public static IIntUnaryFunction lambdaFunction(int alpha, int beta, int gamma) {
        return new IIntUnaryFunction() {
            @Override
            public double valueAt(int x) {
                if (x < alpha) return 0;
                else if (x < beta) return (double)(x - alpha) / (beta - alpha);
                else if (x < gamma) return (double)(gamma - x) / (gamma - beta);
                else return 0;
            }
        };
    }
}
