package com.wandrell.tabletop.business.model.pendragon.valuehandler.module.store;

import static com.google.common.base.Preconditions.checkNotNull;

import com.wandrell.tabletop.business.model.pendragon.glory.FatherClassGlory;
import com.wandrell.tabletop.business.model.valuehandler.ValueHandler;
import com.wandrell.tabletop.business.model.valuehandler.module.store.AbstractStoreModule;

public final class FatherClassGloryStore extends AbstractStoreModule {

    private final FatherClassGlory fatherClass;
    private final ValueHandler     years;

    public FatherClassGloryStore(final FatherClassGlory fatherClass,
            final ValueHandler years) {
        super();

        checkNotNull(fatherClass, "Received a null pointer as father class");
        checkNotNull(years, "Received a null pointer as years");

        this.fatherClass = fatherClass;
        this.years = years;
    }

    public FatherClassGloryStore(final FatherClassGloryStore store) {
        super();

        checkNotNull(store, "Received a null pointer as store");

        fatherClass = store.fatherClass;
        years = store.years;
    }

    @Override
    public final FatherClassGloryStore createNewInstance() {
        return new FatherClassGloryStore(this);
    }

    @Override
    public final Integer getValue() {
        final Integer value;

        value = getFatherClassGlory().getBaseGlory()
                + (getFatherClassGlory().getGloryPerYear() * getYears()
                        .getValue());

        return value;
    }

    private final FatherClassGlory getFatherClassGlory() {
        return fatherClass;
    }

    private final ValueHandler getYears() {
        return years;
    }

}
