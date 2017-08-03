package by.alex.allwayticket.json;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class JsonLocalTimeConverter {
    public static class UserSettingSerializer extends JsonSerializer<LocalTime> {
        @Override
        public void serialize(LocalTime lt, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            jgen.writeString(TimeUtil.toString(lt));
        }

       @Override
        public Class<LocalTime> handledType() {
            return LocalTime.class;
        }
    }

    public static class UserSettingDeserializer extends JsonDeserializer<LocalTime> {
        @Override
        public LocalTime deserialize(JsonParser jp, DeserializationContext ctx) throws IOException, JsonProcessingException {
            return TimeUtil.toTime(jp.getText());
        }

        @Override
        public Class<LocalTime> handledType() {
            return LocalTime.class;
        }
    }
}
