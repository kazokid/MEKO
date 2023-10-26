public class CalculatedFuzzySet implements IFuzzySet{

    private IIntUnaryFunction function;
    private IDomain domain;

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
