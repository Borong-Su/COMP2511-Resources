package unsw.business;

import java.util.Map;

public class OrRule implements BusinessRule {
    private BusinessRule left;
    private BusinessRule right;

    public OrRule(BusinessRule left, BusinessRule right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean evaluate(Map<String, Object> values) {

        return left.evaluate(values)
                ||
               right.evaluate(values);
    }
}
