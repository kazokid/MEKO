package labosi.dz123.utils;

import labosi.dz123.domains.DomainElement;
import labosi.dz123.domains.IDomain;
import labosi.dz123.sets.IFuzzySet;

public class Debug {
    public static void print(IDomain domain, String headerText) {
        if (headerText != null) {
            System.out.println(headerText);
        }

        for (DomainElement e : domain) {
            System.out.println("Element domene: " + e);
        }

        System.out.println("Kardinalitet domene je: " + domain.getCardinality());
        System.out.println();
    }

    public static void print (IFuzzySet set, String headerText) {
        if (headerText != null) {
            System.out.println(headerText);
        }

        for (DomainElement e : set.getDomain()) {
            System.out.printf("d%s = %1.6f\n",e, set.getValueAt(e));
        }

        System.out.println();
    }
}
