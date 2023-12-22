package labosi.dz123.rules;

import labosi.dz123.operations.IBinaryFunction;
import labosi.dz123.sets.IFuzzySet;
import labosi.dz123.implications.IImplication;


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
