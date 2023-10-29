package utils;

import domains.DomainElement;
import domains.IDomain;
import sets.IFuzzySet;

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
        // TODO popravi printanje double, da se ne printa 0.9999999999999999 i da printa na odreden broj decimala
        if (headerText != null) {
            System.out.println(headerText);
        }

        for (DomainElement e : set.getDomain()) {
            System.out.println("d(" + e + ")=" + set.getValueAt(e));
        }

        System.out.println();
    }
}
