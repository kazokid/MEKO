import domains.DomainElement;
import domains.IDomain;

public interface IFuzzySet {
    IDomain getDomain();
    double getValueAt(DomainElement element);
}
