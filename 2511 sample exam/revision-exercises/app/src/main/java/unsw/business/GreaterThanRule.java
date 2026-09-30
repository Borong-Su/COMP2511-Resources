package unsw.business;

import java.util.Map;

public class GreaterThanRule implements BusinessRule {

    private ValueProvider left;
    private ValueProvider right;


    public GreaterThanRule(ValueProvider left, ValueProvider right) {
        this.left = left;
        this.right = right;
    }


    @Override
    public boolean evaluate(Map<String, Object> values) {

        Object leftValue = left.getValue(values);
        Object rightValue = right.getValue(values);


        if (!(leftValue instanceof Number)
                || !(rightValue instanceof Number)) {

            throw new BusinessRuleException(
                    "Both arguments have to be numeric"
            );
        }


        double leftNumber = ((Number) leftValue).doubleValue();
        double rightNumber = ((Number) rightValue).doubleValue();


        return leftNumber > rightNumber;
    }
}
