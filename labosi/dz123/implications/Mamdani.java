package labosi.dz123.implications;

import labosi.dz123.operations.IBinaryFunction;
import labosi.dz123.operations.Operations;

public class Mamdani implements IImplication{
    private boolean min;
    private IBinaryFunction function;

    public Mamdani(boolean min) {
        this.min = min;
        function = min ? Operations.zadehAnd() : Operations.product();
    }

    public double apply(double a, double b) {
        return function.valueAt(a, b);
    }

    public boolean hasLocalSemantics() {
        return true;
    }

    public boolean isMin() {
        return min;
    }
}
