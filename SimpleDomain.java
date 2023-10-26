public class SimpleDomain extends Domain {

    private final int first;
    private final int last;

    // domain is declared as a range [first, last> (last not included)
    public SimpleDomain(int first, int last) {
        this.first = first;
        this.last = last;
    }

    public int getCardinality() {
        return last - first + 1;
    }

}
