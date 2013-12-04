package com.lnu.controller.json.converter;

import antlr.StringUtils;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: igor
 * Date: 12/2/13
 */
public class JsonDateDeserealizer extends JsonDeserializer<Date> {

    private SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        try {
            String date = jsonParser.getText();
            if(date == null || date.equals("")){
                return null;
            }
            return formatter.parse(date);
        } catch (ParseException e) {
           throw new IOException("Incorrect date format");
        }
    }
}
