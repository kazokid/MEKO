package labosi.dz123.sets;

import labosi.dz123.domains.DomainElement;
import labosi.dz123.domains.IDomain;

public interface IFuzzySet {
    IDomain getDomain();
    double getValueAt(DomainElement element);
}
