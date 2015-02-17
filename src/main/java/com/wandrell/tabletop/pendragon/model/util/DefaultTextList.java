package com.wandrell.tabletop.pendragon.model.util;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Objects;

import com.google.common.base.MoreObjects;

public final class DefaultTextList implements TextList {

    private final String             listName;
    private final Collection<String> listValues;

    public DefaultTextList(final String name, final Collection<String> values) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(values, "Received a null pointer as values");

        listName = name;
        listValues = values;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultTextList other = (DefaultTextList) obj;
        return Objects.equals(listName, other.listName);
    }

    @Override
    public final String getName() {
        return listName;
    }

    @Override
    public final Collection<String> getValues() {
        return listValues;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(listName);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", listName)
                .toString();
    }

}
