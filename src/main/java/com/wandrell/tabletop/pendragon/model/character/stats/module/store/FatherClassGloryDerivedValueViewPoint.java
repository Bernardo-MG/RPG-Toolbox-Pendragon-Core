package com.wandrell.tabletop.pendragon.model.character.stats.module.store;

import static com.google.common.base.Preconditions.checkNotNull;

import com.wandrell.tabletop.pendragon.model.glory.FatherClassGlory;
import com.wandrell.tabletop.valuebox.ValueBox;
import com.wandrell.tabletop.valuebox.derived.AbstractDerivedValueViewPoint;

public final class FatherClassGloryDerivedValueViewPoint extends
        AbstractDerivedValueViewPoint {

    private final FatherClassGlory fatherClass;
    private final ValueBox         years;

    public FatherClassGloryDerivedValueViewPoint(
            final FatherClassGlory fatherClass, final ValueBox years) {
        super();

        checkNotNull(fatherClass, "Received a null pointer as father class");
        checkNotNull(years, "Received a null pointer as years");

        this.fatherClass = fatherClass;
        this.years = years;
    }

    public FatherClassGloryDerivedValueViewPoint(
            final FatherClassGloryDerivedValueViewPoint store) {
        super();

        checkNotNull(store, "Received a null pointer as store");

        fatherClass = store.fatherClass;
        years = store.years;
    }

    @Override
    public final Integer getValue() {
        final Integer value;

        value = getFatherClassGlory().getBaseGlory()
                + (getFatherClassGlory().getYearlyGlory() * getYears()
                        .getValue());

        return value;
    }

    private final FatherClassGlory getFatherClassGlory() {
        return fatherClass;
    }

    private final ValueBox getYears() {
        return years;
    }

}
