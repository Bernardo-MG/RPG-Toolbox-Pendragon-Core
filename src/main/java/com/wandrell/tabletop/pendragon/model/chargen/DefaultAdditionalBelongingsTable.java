package com.wandrell.tabletop.pendragon.model.chargen;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import com.wandrell.tabletop.interval.DefaultIntervalTable;
import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.IntervalTable;

public final class DefaultAdditionalBelongingsTable implements
        AdditionalBelongingsTable {

    private final String                              name;
    private final IntervalTable<AdditionalBelongings> table;

    public DefaultAdditionalBelongingsTable(
            final DefaultAdditionalBelongingsTable table) {
        super();

        checkNotNull(table,
                "Received a null pointer as additional belongings table");

        name = table.name;
        this.table = table.table.createNewInstance();
    }

    public DefaultAdditionalBelongingsTable(final String name,
            final Map<Interval, AdditionalBelongings> intervals) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(intervals, "Received a null pointer as intervals");

        this.name = name;
        table = new DefaultIntervalTable<AdditionalBelongings>(intervals);
    }

    @Override
    public final DefaultAdditionalBelongingsTable createNewInstance() {
        return new DefaultAdditionalBelongingsTable(this);
    }

    @Override
    public final Map<Interval, AdditionalBelongings> getIntervals() {
        return getIntervalTable().getIntervals();
    }

    @Override
    public final Integer getLowerLimit() {
        return getIntervalTable().getLowerLimit();
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Integer getUpperLimit() {
        return getIntervalTable().getUpperLimit();
    }

    @Override
    public final AdditionalBelongings getValue(final Integer number) {
        return getIntervalTable().getValue(number);
    }

    private final IntervalTable<AdditionalBelongings> getIntervalTable() {
        return table;
    }

}
