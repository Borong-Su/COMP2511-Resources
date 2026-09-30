package unsw.business;

import java.util.Map;

public class AndRule implements BusinessRule {
    private BusinessRule left;
    private BusinessRule right;

    public AndRule(BusinessRule left, BusinessRule right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean evaluate(Map<String, Object> values) {

        return left.evaluate(values)
                &&
               right.evaluate(values);
    }
}