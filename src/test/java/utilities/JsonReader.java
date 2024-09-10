package utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {

    @DataProvider(name = "getJsonTestData")
    public static Object[][] getJsonTestData() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/main/resources/testData.json");

        Object parsedObject = jsonParser.parse(reader);
        List<Object[]> testData = new ArrayList<>();

        if (parsedObject instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) parsedObject;
            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                String username = (String) jsonObject.get("username");
                String password = (String) jsonObject.get("password");
                testData.add(new Object[]{username, password});
            }
        } else if (parsedObject instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) parsedObject;
            String username = (String) jsonObject.get("username");
            String password = (String) jsonObject.get("password");
            testData.add(new Object[]{username, password});
        }
        return testData.toArray(new Object[0][]);
    }


}