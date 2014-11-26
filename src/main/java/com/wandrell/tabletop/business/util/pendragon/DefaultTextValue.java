package com.wandrell.tabletop.business.util.pendragon;

import com.wandrell.tabletop.business.model.pendragon.util.TextValue;

public final class DefaultTextValue implements TextValue {

    private final String key;
    private final String value;

    public DefaultTextValue(final String key, final String value) {
        super();
        this.key = key;
        this.value = value;
    }

    @Override
    public final String getKey() {
        return key;
    }

    @Override
    public final String getValue() {
        return value;
    }

}
