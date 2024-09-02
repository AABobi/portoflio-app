package radoslaw.kopec.portfolio.user.auth.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class JsonReader {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T readJsonValue(String json, Class<T> classType) throws JsonProcessingException {
        return objectMapper.readValue(json,classType);
    }
}
