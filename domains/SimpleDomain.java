package domains;

import java.util.Iterator;

public class SimpleDomain extends Domain {

    private final int first;
    private final int last;

    // domain is declared as a range [first, last> (last not included)
    public SimpleDomain(int first, int last) {
        this.first = first;
        this.last = last;
    }

    public int getCardinality() {
        return last - first;
    }

    public int getNumberOfComponents() {
        return 1;
    }

    public SimpleDomain getComponent(int index) {
        return this;
    }

    public int getFirst() {
        return first;
    }

    public int getLast() {
        return last;
    }

    public Iterator<DomainElement> iterator() {
        return new Iterator<DomainElement>() {
            private int currentElement = first;


            @Override
            public boolean hasNext() {
                return currentElement < last;
            }

            @Override
            public DomainElement next() {
                return DomainElement.of(currentElement++);
            }

        };
    }


}
