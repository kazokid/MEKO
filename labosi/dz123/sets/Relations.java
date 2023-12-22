package labosi.dz123.sets;

import labosi.dz123.domains.Domain;
import labosi.dz123.domains.DomainElement;
import labosi.dz123.domains.IDomain;

public class Relations {

    public static boolean isUtimesURelation(IFuzzySet relation) {
        IDomain domain = relation.getDomain();
        if (domain.getNumberOfComponents() != 2) {
            return false;
        }
        return domain.getComponent(0).equals(domain.getComponent(1));
    }

    public static boolean isSymmetric(IFuzzySet relation) {
        if (!isUtimesURelation(relation)) {
            throw new IllegalArgumentException("Relation is not defined on UxU");
        }

        IDomain domain = relation.getDomain();
        for (DomainElement element : domain) {
            if (relation.getValueAt(element) != relation.getValueAt(element.swap())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isReflexive(IFuzzySet relation) {
        if (!isUtimesURelation(relation)) {
            throw new IllegalArgumentException("Relation is not defined on UxU");
        }

        IDomain domain = relation.getDomain();
        for (DomainElement element : domain) {
            if (element.getComponentValue(0) == element.getComponentValue(1)) {
                if (relation.getValueAt(element) != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isMaxMinTransitive (IFuzzySet relation) {
        if (!isUtimesURelation(relation)) {
            throw new IllegalArgumentException("Relation is not defined on UxU");
        }

        IDomain domain = relation.getDomain();
        for (DomainElement element : domain) {
            for (DomainElement element2 : domain) {
                if (element.getComponentValue(1) == element2.getComponentValue(0)) {
                    double value = Math.min(relation.getValueAt(element), relation.getValueAt(element2));
                    DomainElement element3 = DomainElement.of(element.getComponentValue(0), element2.getComponentValue(1));
                    if (relation.getValueAt(element3) < value) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static IFuzzySet compositionOfBinaryRelations(IFuzzySet r1, IFuzzySet r2) {
        IDomain domain1 = r1.getDomain();
        IDomain domain2 = r2.getDomain();
        if (domain1.getNumberOfComponents() != 2 || domain2.getNumberOfComponents() != 2) {
            throw new IllegalArgumentException("sets.Relations are not defined on UxV");
        }
        if (!domain1.getComponent(1).equals(domain2.getComponent(0))) {
            throw new IllegalArgumentException("Incompatible domains of given relations");
        }

        IDomain domain = Domain.combine(domain1.getComponent(0), domain2.getComponent(1));
        MutableFuzzySet composition = new MutableFuzzySet(domain);

        for (DomainElement element : domain) {
            double value = 0;
            for (DomainElement element1 : domain1) {
                for (DomainElement element2 : domain2) {
                    if (element1.getComponentValue(1) == element2.getComponentValue(0)) {
                        if (element1.getComponentValue(0) == element.getComponentValue(0) && element2.getComponentValue(1) == element.getComponentValue(1)) {
                            value = Math.max(value, Math.min(r1.getValueAt(element1), r2.getValueAt(element2)));
                        }
                    }
                }
            }
            composition.set(element, value);
        }
        return composition;
    }

    public static boolean isFuzzyEquivalence(IFuzzySet relation) {
        return isReflexive(relation) && isSymmetric(relation) && isMaxMinTransitive(relation);
    }
}
