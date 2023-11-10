package implications;

public interface IImplication {

        double apply(double a, double b);

        boolean hasLocalSemantics();
}
