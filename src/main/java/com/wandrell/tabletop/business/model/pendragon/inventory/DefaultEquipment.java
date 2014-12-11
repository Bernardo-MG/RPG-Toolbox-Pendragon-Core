package com.wandrell.tabletop.business.model.pendragon.inventory;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public final class DefaultEquipment implements Equipment {

    private final Collection<String>   flags;
    private final Item                 item;
    private final Map<String, Integer> values;

    public DefaultEquipment(final Item item, final Set<String> flags,
            final Map<String, Integer> values) {
        super();

        checkNotNull(item, "Received a null pointer as item");
        checkNotNull(flags, "Received a null pointer as flags");
        checkNotNull(values, "Received a null pointer as values");

        this.item = item;
        this.flags = flags;
        this.values = values;
    }

    @Override
    public final String getDescription() {
        return getBaseItem().getDescription();
    }

    @Override
    public final Money getMoney() {
        return getBaseItem().getMoney();
    }

    @Override
    public final String getName() {
        return getBaseItem().getName();
    }

    private final Item getBaseItem() {
        return item;
    }

    private final Collection<String> getFlagsModifiable() {
        return flags;
    }

    private final Map<String, Integer> getMiscelanyValuesModifiable() {
        return values;
    }

}
