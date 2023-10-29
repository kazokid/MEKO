package domains;

public abstract class Domain implements IDomain {

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
    public SimpleDomain getComponent(int index) {
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
        throw new IllegalArgumentException("Element not in domain");
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
    public boolean equals(Object object) {

        if (!(object instanceof IDomain other)) {
            return false;
        }

        if (this.getNumberOfComponents() != other.getNumberOfComponents()) {
            return false;
        }

        for (int i = 0; i < this.getNumberOfComponents(); i++) {
            IDomain otherComponent = other.getComponent(i);
            IDomain thisComponent = this.getComponent(i);

            if (otherComponent.getCardinality() != thisComponent.getCardinality()) {
                return false;
            }

            for (int j = 0; j < thisComponent.getCardinality(); j++) {
                if (!thisComponent.elementForIndex(j).equals(otherComponent.elementForIndex(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
