package labosi.dz123.operations;

import labosi.dz123.domains.IDomain;
import labosi.dz123.sets.CalculatedFuzzySet;
import labosi.dz123.sets.IFuzzySet;

public abstract class Operations {

    public static IFuzzySet unaryOperation(IFuzzySet set, IUnaryFunction function) {
        return new CalculatedFuzzySet(set.getDomain(), x -> function.valueAt(set.getValueAt(set.getDomain().elementForIndex(x))));
    }

    public static IFuzzySet binaryOperation(IFuzzySet set1, IFuzzySet set2, IBinaryFunction function) {
        if (!set1.getDomain().equals(set2.getDomain())) {
            throw new IllegalArgumentException("Domains must be equal!");
        }

        IDomain domain = set1.getDomain();
        return new CalculatedFuzzySet(domain, x -> function.valueAt(set1.getValueAt(domain.elementForIndex(x)), set2.getValueAt(domain.elementForIndex(x))));
    }

    public static IUnaryFunction zadehNot() {
        return x -> 1 - x;
    }

    public static IBinaryFunction zadehAnd() {
        return Math::min;
    }

    public static IBinaryFunction zadehOr() {
        return Math::max;
    }

    public static IBinaryFunction hamacherTNorm(double v) {
        return (x, y) -> (x * y) / (v + (1 - v) * (x + y - x * y));
    }

    public static IBinaryFunction hamacherSNorm(double v) {
        return (x, y) -> (x + y - (2 - v) * x * y) / (1 - (1 - v) * x * y);
    }

    public static IBinaryFunction product() {
        return (x, y) -> x * y;
    }



}
