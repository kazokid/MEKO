import java.util.ArrayList;
import java.util.Iterator;

public class CompositeDomain extends Domain {

    private final ArrayList<IDomain> domainComponents = new ArrayList<>();

    public CompositeDomain(IDomain first, IDomain second) {
        domainComponents.add(first);
        domainComponents.add(second);
    }

    public int getCardinality() {
        int cardinality = 1;
        for (IDomain domain : domainComponents) {
            cardinality *= domain.getCardinality();
        }
        return cardinality;
    }
    @Override
    public IDomain getComponent(int index) {
        return domainComponents.get(index);
    }

    @Override
    public int getNumberOfComponents() {
        return domainComponents.size();
    }

//    we want to be able to iterate through all elements of the composite domain
//    we need to implement the iterator method

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
                    IDomain component = getComponent(i);
                    int componentCardinality = component.getCardinality();
                    values[i] = currentElementIndexCopy % componentCardinality;
                    currentElementIndexCopy /= componentCardinality;
                }
                currentElementIndex++;
                return DomainElement.of(values);
            }

        };
    }
}
