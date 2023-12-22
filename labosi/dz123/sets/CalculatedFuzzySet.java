package labosi.dz123.sets;

import labosi.dz123.domains.DomainElement;
import labosi.dz123.domains.IDomain;
import labosi.dz123.operations.IIntUnaryFunction;

public class CalculatedFuzzySet implements IFuzzySet{

    private final IIntUnaryFunction function;
    private final IDomain domain;

    public CalculatedFuzzySet(IDomain domain, IIntUnaryFunction function) {
        this.domain = domain;
        this.function = function;
    }

    @Override
    public IDomain getDomain() {
        return domain;
    }

    @Override
    public double getValueAt(DomainElement element) {
        return function.valueAt(domain.indexOfElement(element));
    }
}
