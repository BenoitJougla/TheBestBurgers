package presentation.add;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class ErrorJsonBuilder {
    private final JsonArrayBuilder jab;

    public ErrorJsonBuilder() {
        jab = Json.createArrayBuilder();
    }

    public void add(String field, String message) {
        final JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("field", field);
        job.add("message", message);

        jab.add(job.build());
    }

    public JsonObject build() {
        final JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("errors", jab);
        return job.build();
    }
}