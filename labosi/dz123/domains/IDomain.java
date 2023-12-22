package labosi.dz123.domains;

public interface IDomain extends Iterable<DomainElement> {
    int getCardinality();
    SimpleDomain getComponent(int index);
    int getNumberOfComponents();
    int indexOfElement(DomainElement element);
    DomainElement elementForIndex(int index);
}
