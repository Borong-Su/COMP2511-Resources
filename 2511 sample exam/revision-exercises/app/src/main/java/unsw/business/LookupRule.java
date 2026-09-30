package unsw.business;

import java.util.Map;

public class LookupRule implements ValueProvider {
    private String variableName;

    public LookupRule(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public Object getValue(Map<String, Object> values) {
        return values.get(variableName);
    }
}
