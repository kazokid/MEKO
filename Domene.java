public class Domene {
     public static void main(String[] args) {
//          IDomain d1 = Domain.intRange(0, 5);
//          Debug.print(d1, "Elementi domene d1:");
//
//          IDomain d2 = Domain.intRange(0, 3); // {0,1,2}
//          Debug.print(d2, "Elementi domene d2:");
//
//          IDomain d3 = Domain.combine(d1, d2);
//          Debug.print(d3, "Elementi domene d3:");
//
//          System.out.println(d2.elementForIndex(0));
//          System.out.println(d3.elementForIndex(5));
//          System.out.println(d3.elementForIndex(14));
//          System.out.println(d3.indexOfElement(DomainElement.of(4, 1)));

          IDomain d = Domain.intRange(0, 11);

          IFuzzySet set1 = new MutableFuzzySet(d)
                  .set(DomainElement.of(0), 1.0)
                  .set(DomainElement.of(1), 0.8)
                  .set(DomainElement.of(2), 0.6)
                  .set(DomainElement.of(3), 0.4)
                  .set(DomainElement.of(4), 0.2);

          Debug.print(set1, "Set1:");

          IDomain d2 = Domain.intRange(-5, 6); // {-5,-4,...,4,5}
          IFuzzySet set2 = new CalculatedFuzzySet(d2, StandardFuzzySets.lambdaFunction(
                  d2.indexOfElement(DomainElement.of(-4)),
                  d2.indexOfElement(DomainElement.of( 0)),
                  d2.indexOfElement(DomainElement.of( 4)
                  )
          ));

          Debug.print(set2, "Set2:");
     }
}

