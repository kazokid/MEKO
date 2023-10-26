public class Domain implements IDomain {

    public Domain() {
    }

    public static IDomain intRange(int start, int end) {
        return new SimpleDomain(start, end);
    }

    @Override
    public int getCardinality() {
        return 0;
    }

    @Override
    public IDomain getComponent() {
        return null;
    }

    @Override
    public int getNumberOfComponents() {
        return 0;
    }

    @Override
    public int indexOfElement() {
        return 0;
    }

    @Override
    public IDomain elementForIndex() {
        return null;
    }
}
