public interface IDomain {
    int getCardinality();
    IDomain getComponent();
    int getNumberOfComponents();
    int indexOfElement();
    IDomain elementForIndex();
}
