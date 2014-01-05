package com.orangelit.stocktracker.common.exceptions;

import java.lang.reflect.Type;
import java.text.MessageFormat;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(Type entityType, String entityId) {
        super(MessageFormat.format("Entity of type {0} with id {1} not found", entityType.getClass().getName(), entityId));
    }
}
