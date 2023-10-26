import java.util.Arrays;

public class DomainElement {
    private final int[] values;

    public DomainElement(int[] values) {
        this.values = values;
    }

    public int getNumberOfComponents() {
        return values.length;
    }

    public int getComponentValue(int index) {
        return values[index];
    }

    public static DomainElement of(int... values) {
        return new DomainElement(values);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]);
            if (i != values.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DomainElement other)) {
            return false;
        }

        int numberOfComponents = getNumberOfComponents();
        int otherNumberOfComponents = other.getNumberOfComponents();

        if (numberOfComponents != otherNumberOfComponents) {
            return false;
        }

        for (int i = 0; i < numberOfComponents; i++) {
            if (getComponentValue(i) != other.getComponentValue(i)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }
}
