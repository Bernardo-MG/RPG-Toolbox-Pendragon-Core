package com.wandrell.tabletop.business.model.pendragon.inventory;

import com.wandrell.tabletop.business.model.valuehandler.EditableValueHandler;

public final class DefaultMoney implements Money {

    private final EditableValueHandler denarii;
    private final EditableValueHandler libra;

    public DefaultMoney(final DefaultMoney data) {
        super();

        denarii = data.denarii.createNewInstance();
        libra = data.libra.createNewInstance();
    }

    public DefaultMoney(final EditableValueHandler denarii,
            final EditableValueHandler libra) {
        super();
        this.denarii = denarii;
        this.libra = libra;
    }

    @Override
    public final DefaultMoney createNewInstance() {
        return new DefaultMoney(this);
    }

    @Override
    public final boolean equals(final Object obj) {
        final DefaultMoney received;
        boolean equals;

        if (obj == this) {
            equals = true;
        } else if (obj == null) {
            equals = false;
        } else if (getClass() != obj.getClass()) {
            equals = false;
        } else {
            received = (DefaultMoney) obj;
            if (received.denarii == null) {
                equals = (denarii == null);
            } else {
                equals = (received.denarii.equals(denarii));
            }
            if ((equals) && (received.libra == null)) {
                equals = (libra == null);
            } else if (equals) {
                equals = (received.libra.equals(libra));
            }
        }

        return equals;
    }

    @Override
    public final EditableValueHandler getDenarii() {
        return denarii;
    }

    @Override
    public final EditableValueHandler getLibra() {
        return libra;
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((denarii == null) ? 0 : denarii.hashCode());

        result = prime * result + ((libra == null) ? 0 : libra.hashCode());

        return result;
    }

}
