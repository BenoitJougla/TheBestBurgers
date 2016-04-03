package presentation;

import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletResponse;

public class ErrorResponse {

    public static void sendError(int errorCode, JsonObject json, HttpServletResponse response) throws IOException {
        response.setStatus(errorCode);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Json.createWriter(response.getOutputStream()).writeObject(json);
    }
}
