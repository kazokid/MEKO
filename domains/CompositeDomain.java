package domains;

import java.util.ArrayList;
import java.util.Iterator;

public class CompositeDomain extends Domain {

    private final ArrayList<SimpleDomain> domainComponents = new ArrayList<>();

    public CompositeDomain(IDomain... domains) {
        for (IDomain domain : domains) {
            for (int i = 0; i < domain.getNumberOfComponents(); i++) {
                domainComponents.add(domain.getComponent(i));
            }
        }
    }

    public int getCardinality() {
        int cardinality = 1;
        for (IDomain domain : domainComponents) {
            cardinality *= domain.getCardinality();
        }
        return cardinality;
    }
    @Override
    public SimpleDomain getComponent(int index) {
        return domainComponents.get(index);
    }

    @Override
    public int getNumberOfComponents() {
        return domainComponents.size();
    }

    @Override
    public Iterator<DomainElement> iterator() {
        return new Iterator<DomainElement>() {
            private final int cardinality = getCardinality();
            private int currentElementIndex = 0;
            private int numberOfComponents = getNumberOfComponents();


            @Override
            public boolean hasNext() {
                return currentElementIndex < cardinality;
            }
            @Override
            public DomainElement next() {
                int[] values = new int[numberOfComponents];
                int currentElementIndexCopy = currentElementIndex;
                for (int i = numberOfComponents - 1; i >= 0; i--) {
                    SimpleDomain component = getComponent(i);
                    int componentCardinality = component.getCardinality();
                    values[i] = currentElementIndexCopy % componentCardinality + component.getFirst();
                    currentElementIndexCopy /= componentCardinality;
                }
                currentElementIndex++;
                return DomainElement.of(values);
            }

        };
    }
}
