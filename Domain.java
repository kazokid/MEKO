import java.util.Iterator;

public class Domain implements IDomain {

    public Domain() {
    }

    public static IDomain intRange(int start, int end) {
        return new SimpleDomain(start, end);
    }

    public static Domain combine(IDomain first, IDomain second) {
        return new CompositeDomain(first, second);
    }

    @Override
    public int getCardinality() {
        return 0;
    }

    @Override
    public IDomain getComponent(int index) {
        return null;
    }

    @Override
    public int getNumberOfComponents() {
        return 0;
    }

    @Override
    public int indexOfElement(DomainElement element) {
        int counter = 0;
        for (DomainElement e : this) {
            if (element.equals(e)) {
                return counter;
            }
            counter++;
        }
        return -1;
    }

    @Override
    public DomainElement elementForIndex(int index) {
        for (DomainElement element : this) {
            if (this.indexOfElement(element) == index) {
                return element;
            }
        }
        return null;
    }

    @Override
    public Iterator<DomainElement> iterator() {
        return null;
    }
}
