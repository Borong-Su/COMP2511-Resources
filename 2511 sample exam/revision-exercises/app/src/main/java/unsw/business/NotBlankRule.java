package unsw.business;

import java.util.Map;

public class NotBlankRule implements BusinessRule {
    private ValueProvider value;

    public NotBlankRule(ValueProvider value) {
        this.value = value;
    }

    @Override
    public boolean evaluate(Map<String, Object> values) {

        Object result = value.getValue(values);

        if (result == null) {
            return false;
        }

        if (result instanceof String) {
            String stringValue = (String) result;

            return !stringValue.isBlank();
        }

        return true;
    }
}
