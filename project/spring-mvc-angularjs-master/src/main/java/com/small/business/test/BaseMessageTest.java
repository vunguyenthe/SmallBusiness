package com.small.business.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.small.business.adapter.OcadoGsonBuilder;
import com.small.business.argonaut.GsonOperations;
import com.small.business.argonaut.JsonOperationsSerialiser;
import com.small.business.argonaut.JsonSerialiser;
import com.small.business.model.base.BaseMessage;

public abstract class BaseMessageTest {

    private static final Gson gson = OcadoGsonBuilder.getGsonBuilder().create();
    private static final JsonSerialiser jsonSerialiserUnderTest = new JsonOperationsSerialiser<>(
            new GsonOperations(gson));

    private final BaseMessage[] messages;

    public BaseMessageTest(BaseMessage... messages) {

        Preconditions.checkArgument(messages.length > 0,
                "No messages passed to MessageTest constructor");

        this.messages = messages;
    }

    @Test
    public void serialiseAndDeserialise_validMessage()
            throws ClassNotFoundException {

        for (BaseMessage message : messages) {
            testSerialiseAndDeserialise(message);
        }
    }

    protected void testSerialiseAndDeserialise(BaseMessage message)
            throws ClassNotFoundException {

        Preconditions.checkNotNull(message, "Cannot test null message");
        jsonSerialiserUnderTest.registerType(message.getClass());

        String json = jsonSerialiserUnderTest.serialise(message);
        System.out.println("json: " + json);
        System.out.println("message.getClass(): " + message.getClass().getSimpleName());
        Object deserialisedMessage = jsonSerialiserUnderTest.deserialise(json);
        assertEquals("Deserialised message should equal original message",
                message.toString(), deserialisedMessage.toString());
    }

}
