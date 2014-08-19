package com.wandrell.tabletop.pendragon.valuehandler.module.store;

import com.wandrell.tabletop.valuehandler.ValueHandler;
import com.wandrell.tabletop.valuehandler.module.StoreModule;

public final class FatherClassGloryStore extends StoreModule {

    private final ValueHandler baseGlory;
    private final ValueHandler gloryPerYear;
    private final ValueHandler years;

    public FatherClassGloryStore(final FatherClassGloryStore module) {
        super(module);
        baseGlory = module.baseGlory.createNewInstance();
        gloryPerYear = module.gloryPerYear.createNewInstance();
        years = module.years.createNewInstance();
    }

    public FatherClassGloryStore(final ValueHandler vhBaseGlory,
            final ValueHandler vhYears, final ValueHandler vhGloryPerYear) {
        super();
        this.baseGlory = vhBaseGlory;
        this.years = vhYears;
        this.gloryPerYear = vhGloryPerYear;
    }

    @Override
    public final void addValue(final Integer value) {}

    @Override
    public final FatherClassGloryStore createNewInstance() {
        return new FatherClassGloryStore(this);
    }

    public final ValueHandler getBaseGlory() {
        return baseGlory;
    }

    public final ValueHandler getGloryPerYear() {
        return gloryPerYear;
    }

    @Override
    public final Integer getValue() {
        final Integer value;

        value = getBaseGlory().getStoredValue()
                + (getGloryPerYear().getStoredValue() * getYears()
                        .getStoredValue());

        return value;
    }

    public final ValueHandler getYears() {
        return years;
    }

    @Override
    public final void setValue(final Integer value) {}

}
