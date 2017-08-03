package by.alex.allwayticket.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;


import java.time.LocalDateTime;
import java.time.LocalTime;


public class JacksonObjectMapper extends ObjectMapper {

    private static final ObjectMapper MAPPER = new JacksonObjectMapper();

    public static ObjectMapper getMapper() {
        return MAPPER;
    }

    private JacksonObjectMapper() {
        registerModule(new Hibernate5Module());

        SimpleModule customModule = new SimpleModule("customModule", new Version(1, 0, 0, null));
        customModule.addSerializer(new JsonLocalDateTimeConverter.UserSettingSerializer());
        customModule.addDeserializer(LocalDateTime.class, new JsonLocalDateTimeConverter.UserSettingDeserializer());
        customModule.addSerializer(new JsonLocalTimeConverter.UserSettingSerializer());
        customModule.addDeserializer(LocalTime.class, new JsonLocalTimeConverter.UserSettingDeserializer());
        registerModule(customModule);


        setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    }
}




