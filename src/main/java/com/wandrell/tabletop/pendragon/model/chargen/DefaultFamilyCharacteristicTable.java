package com.wandrell.tabletop.pendragon.model.chargen;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.wandrell.tabletop.interval.DefaultIntervalTable;
import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.IntervalTable;

public final class DefaultFamilyCharacteristicTable implements
        FamilyCharacteristicTable {

    private final String                                      name;
    private final IntervalTable<FamilyCharacteristicTemplate> table;

    public DefaultFamilyCharacteristicTable(
            final DefaultFamilyCharacteristicTable characteristic) {
        super();

        checkNotNull(characteristic,
                "Received a null pointer as family characteristic");

        name = characteristic.name;
        table = characteristic.table.createNewInstance();
    }

    public DefaultFamilyCharacteristicTable(final String name,
            final Map<Interval, FamilyCharacteristicTemplate> intervals) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(intervals, "Received a null pointer as intervals");

        this.name = name;
        table = new DefaultIntervalTable<FamilyCharacteristicTemplate>(
                intervals);
    }

    @Override
    public final DefaultFamilyCharacteristicTable createNewInstance() {
        return new DefaultFamilyCharacteristicTable(this);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultFamilyCharacteristicTable other = (DefaultFamilyCharacteristicTable) obj;
        return Objects.equal(name, other.name);
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

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

    private final IntervalTable<FamilyCharacteristicTemplate>
            getIntervalTable() {
        return table;
    }

}
