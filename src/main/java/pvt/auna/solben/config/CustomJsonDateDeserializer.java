package pvt.auna.solben.config;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class CustomJsonDateDeserializer extends JsonDeserializer<Date> {
	@Override
    public Date deserialize(JsonParser jsonparser,
            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String dateStr = jsonparser.getText();
        try {
            return (Date)formatter.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
