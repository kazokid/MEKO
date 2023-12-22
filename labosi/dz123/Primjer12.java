package labosi.dz123;

import labosi.dz123.domains.Domain;
import labosi.dz123.domains.DomainElement;
import labosi.dz123.domains.IDomain;
import labosi.dz123.sets.CalculatedFuzzySet;
import labosi.dz123.sets.IFuzzySet;
import labosi.dz123.sets.MutableFuzzySet;
import labosi.dz123.sets.StandardFuzzySets;
import labosi.dz123.utils.Debug;

public class Primjer12 {
    public static void main(String[] args) {
        IDomain d = Domain.intRange(0, 11); // {0,1,...,10}
        IFuzzySet set1 = new MutableFuzzySet(d)
                .set(DomainElement.of(0), 1.0)
                .set(DomainElement.of(1), 0.8)
                .set(DomainElement.of(2), 0.6)
                .set(DomainElement.of(3), 0.4)
                .set(DomainElement.of(4), 0.2);
        Debug.print(set1, "Set1:");
        IDomain d2 = Domain.intRange(-5, 6); // {-5,-4,...,4,5}
        IFuzzySet set2 = new CalculatedFuzzySet(
                d2,
                StandardFuzzySets.lambdaFunction(
                        d2.indexOfElement(DomainElement.of(-4)),
                        d2.indexOfElement(DomainElement.of( 0)),
                        d2.indexOfElement(DomainElement.of( 4))
                )
        );
        Debug.print(set2, "Set2:");
    }
}