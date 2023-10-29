import utils.Debug;

public class Domene {
     public static void main(String[] args) {
          domains.IDomain d1 = domains.Domain.intRange(3, 5); // {3,4}
          Debug.print(d1, "Elementi domene d1:");

          domains.IDomain d2 = domains.Domain.intRange(0, 3); // {0,1,2}
          Debug.print(d2, "Elementi domene d2:");

          domains.IDomain d3 = domains.Domain.combine(d1, d2);
          Debug.print(d3, "Elementi domene d3:");

          domains.IDomain d4 = domains.Domain.combine(d1, d3);
            Debug.print(d4, "Elementi domene d4:");

          System.out.println(d2.elementForIndex(0));
          System.out.println(d3.elementForIndex(5));
          System.out.println(d3.elementForIndex(14));
          System.out.println(d3.indexOfElement(domains.DomainElement.of(4, 1)));

//          IDomain d = Domain.intRange(2, 11);
//
//          sets.IFuzzySet set1 = new sets.MutableFuzzySet(d)
//                  .set(DomainElement.of(0), 1.0)
//                  .set(DomainElement.of(1), 0.8)
//                  .set(DomainElement.of(2), 0.6)
//                  .set(DomainElement.of(3), 0.4)
//                  .set(DomainElement.of(4), 0.2);
//
//          utils.Debug.print(set1, "Set1:");
//
//          IDomain d2 = Domain.intRange(-5, 6); // {-5,-4,...,4,5}
//          sets.IFuzzySet set2 = new sets.CalculatedFuzzySet(d2, sets.StandardFuzzySets.lambdaFunction(
//                  d2.indexOfElement(DomainElement.of(-4)),
//                  d2.indexOfElement(DomainElement.of( 0)),
//                  d2.indexOfElement(DomainElement.of( 4)
//                  )
//          ));
//
//          utils.Debug.print(set2, "Set2:");
     }
}

