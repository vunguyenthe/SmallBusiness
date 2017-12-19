package com.small.business.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.small.business.adapter.OcadoGsonBuilder;

/**
 * Used to serialise/deserialise message received from wcs conveyor from Object to String and opposition
 * 
 */
public class GsonParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(GsonParser.class);

    private static final Gson gson = OcadoGsonBuilder.getGsonBuilder().create();

    /**
     * Build object to json
     * 
     * @param request
     *            {@link Object}
     */
    public static String toJson(Object object) {

        if (object == null) {
            return null;
        }
        return gson.toJson(object);
    }

    /**
     * Build json to object
     * 
     * @param request
     *            {@link String}
     */
    public static Object fromJsonToObject(String json, Class<?> clazz) {

        try {
            return (Object) gson.fromJson(json, clazz);
        } catch (RuntimeException e) {
            LOGGER.error("JSONParser.fromJson() -> Error [" + e.getMessage()
                    + "] when trying to convert json (" + json
                    + ") to BaseMessage");
            return null;
        }
    }

}