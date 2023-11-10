package rules;

import domains.DomainElement;
import implications.Mamdani;
import operations.IBinaryFunction;
import sets.IFuzzySet;
import implications.IImplication;


public class Rule {
private final IFuzzySet[] antecedent;
    private final IFuzzySet consequence;
    private final String description;

    public Rule(IFuzzySet[] antecedent, IFuzzySet consequence, String description) {
        this.antecedent = antecedent;
        this.consequence = consequence;
        this.description = description;
    }

    public IFuzzySet apply(double[] values, IImplication implication, IBinaryFunction tNorm) {
//        TODO - implement Rule.apply
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        return description;
    }

}
