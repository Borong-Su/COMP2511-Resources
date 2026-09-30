package unsw.business;

import java.util.Map;

public class ConstantRule implements ValueProvider {

    private Object value;


    public ConstantRule(Object value) {
        this.value = value;
    }


    @Override
    public Object getValue(Map<String,Object> values) {
        return value;
    }
}
