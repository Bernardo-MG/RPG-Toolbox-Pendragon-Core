package com.wandrell.tabletop.business.model.pendragon.valuehandler.module.store;

import com.wandrell.tabletop.business.model.valuehandler.EditableValueHandler;
import com.wandrell.tabletop.business.model.valuehandler.module.store.AbstractStoreModule;

public final class FatherClassGloryStore extends AbstractStoreModule {

    private final EditableValueHandler baseGlory;
    private final EditableValueHandler gloryPerYear;
    private final EditableValueHandler years;

    public FatherClassGloryStore(final EditableValueHandler vhBaseGlory,
            final EditableValueHandler vhYears,
            final EditableValueHandler vhGloryPerYear) {
        super();
        this.baseGlory = vhBaseGlory;
        this.years = vhYears;
        this.gloryPerYear = vhGloryPerYear;
    }

    public FatherClassGloryStore(final FatherClassGloryStore store) {
        super();
        baseGlory = store.baseGlory.createNewInstance();
        gloryPerYear = store.gloryPerYear.createNewInstance();
        years = store.years.createNewInstance();
    }

    @Override
    public final FatherClassGloryStore createNewInstance() {
        return new FatherClassGloryStore(this);
    }

    @Override
    public final Integer getValue() {
        final Integer value;

        value = getBaseGlory().getValue()
                + (getGloryPerYear().getValue() * getYears().getValue());

        return value;
    }

    private final EditableValueHandler getBaseGlory() {
        return baseGlory;
    }

    private final EditableValueHandler getGloryPerYear() {
        return gloryPerYear;
    }

    private final EditableValueHandler getYears() {
        return years;
    }

}
