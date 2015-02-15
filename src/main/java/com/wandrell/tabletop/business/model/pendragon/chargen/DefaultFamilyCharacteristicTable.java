package com.wandrell.tabletop.business.model.pendragon.chargen;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import com.wandrell.tabletop.business.model.interval.DefaultIntervalTable;
import com.wandrell.tabletop.business.model.interval.Interval;
import com.wandrell.tabletop.business.model.interval.IntervalTable;

public final class DefaultFamilyCharacteristicTable implements
        FamilyCharacteristicTable {

    private final String                                      name;
    private final IntervalTable<FamilyCharacteristicTemplate> table;

    public DefaultFamilyCharacteristicTable(final String name,
            final Map<Interval, FamilyCharacteristicTemplate> intervals) {
        super();

        checkNotNull(name, "Received a null pointer as name");

        this.name = name;
        table = new DefaultIntervalTable<FamilyCharacteristicTemplate>(
                intervals);
    }

    @Override
    public final Map<Interval, FamilyCharacteristicTemplate> getIntervals() {
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
    public final FamilyCharacteristicTemplate getValue(final Integer number) {
        return getIntervalTable().getValue(number);
    }

    private final IntervalTable<FamilyCharacteristicTemplate>
            getIntervalTable() {
        return table;
    }

}
