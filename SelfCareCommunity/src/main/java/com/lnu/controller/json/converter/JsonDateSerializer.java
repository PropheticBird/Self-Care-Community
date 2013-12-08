package com.lnu.controller.json.converter;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: igor
 * Date: 12/2/13
 */
public class JsonDateSerializer extends JsonSerializer<Date> {

    private SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        String formattedDate = formatter.format(date);
        jsonGenerator.writeString(formattedDate);
    }
}
