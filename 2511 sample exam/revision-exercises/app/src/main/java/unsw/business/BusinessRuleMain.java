package unsw.business;

import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BusinessRuleMain {

    /**
     * Loads a resource file given a certain path that is relative to resources/
     * for example `/dungeons/maze.json`. Will add a `/` prefix to path if it's not
     * specified.
     *
     * @precondition path exists as a file
     * @param path Relative to resources/ will add an implicit `/` prefix if not
     *             given.
     * @return The textual content of the given file.
     * @throws IOException If some other IO exception.
     */
    public static String loadResourceFile(String path) throws IOException {
        if (!path.startsWith("/"))
            path = "/" + path;
        return new String(BusinessRuleMain.class.getResourceAsStream(path).readAllBytes());
    }


    public static BusinessRule generateRule(String inputBusinessRule) {

        JsonObject json =
                JsonParser.parseString(inputBusinessRule)
                        .getAsJsonObject();

        return parseRule(json);
    }


    private static BusinessRule parseRule(JsonObject json) {
        String operator =
                json.get("Operator").getAsString();

        switch (operator) {
            case "AND":
                JsonArray andArgs =
                        json.getAsJsonArray("Args");

                BusinessRule leftAnd =
                        parseRule(
                                andArgs.get(0)
                                        .getAsJsonObject()
                        );

                BusinessRule rightAnd =
                        parseRule(
                                andArgs.get(1)
                                        .getAsJsonObject()
                        );

                return new AndRule(leftAnd, rightAnd);

            case "OR":
                JsonArray orArgs =
                        json.getAsJsonArray("Args");

                BusinessRule leftOr =
                        parseRule(
                                orArgs.get(0)
                                        .getAsJsonObject()
                        );

                BusinessRule rightOr =
                        parseRule(
                                orArgs.get(1)
                                        .getAsJsonObject()
                        );

                return new OrRule(leftOr, rightOr);

            case "GREATER THAN":
                JsonArray greaterArgs =
                        json.getAsJsonArray("Args");

                ValueProvider greaterLeft =
                        parseValue(
                                greaterArgs.get(0)
                                        .getAsJsonObject()
                        );

                ValueProvider greaterRight =
                        parseValue(
                                greaterArgs.get(1)
                                        .getAsJsonObject()
                        );

                return new GreaterThanRule(
                        greaterLeft,
                        greaterRight
                );

            case "NOT BLANK":
                ValueProvider value =
                        parseValue(
                                json.getAsJsonObject("Arg")
                        );

                return new NotBlankRule(value);

            default:
                throw new BusinessRuleException(
                        "Unknown operator: " + operator
                );
        }
    }

    private static ValueProvider parseValue(JsonObject json) {
        String operator =
                json.get("Operator")
                        .getAsString();

        switch (operator) {
            case "LOOKUP":
                return new LookupRule(
                        json.get("Arg")
                                .getAsString()
                );

            case "CONSTANT":
                return new ConstantRule(
                        json.get("Arg")
                                .getAsDouble()
                );

            default:
                throw new BusinessRuleException(
                        "Unknown value operator: " + operator
                );
        }
    }
}
