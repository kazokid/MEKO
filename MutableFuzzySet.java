import domains.DomainElement;
import domains.IDomain;

public class MutableFuzzySet implements IFuzzySet{
    private double[] memberships;

    private IDomain domain;

    public MutableFuzzySet(IDomain domain) {
        this.domain = domain;
        this.memberships = new double[domain.getCardinality()];
    }

    public IDomain getDomain() {
        return domain;
    }

    public double getValueAt(DomainElement element) {
        return memberships[domain.indexOfElement(element)];
    }

    public MutableFuzzySet set(DomainElement element, double value) {
        memberships[domain.indexOfElement(element)] = value;
        return this;
    }



}
