package com.wandrell.tabletop.business.model.pendragon.inventory;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.valuehandler.EditableValueHandler;

public final class DefaultMoney implements Money {

    private final EditableValueHandler denarii;
    private final EditableValueHandler libra;

    public DefaultMoney(final DefaultMoney money) {
        super();

        checkNotNull(money, "Received a null pointer as money");

        denarii = money.denarii.createNewInstance();
        libra = money.libra.createNewInstance();
    }

    public DefaultMoney(final EditableValueHandler denarii,
            final EditableValueHandler libra) {
        super();

        checkNotNull(denarii, "Received a null pointer as denarii");
        checkNotNull(libra, "Received a null pointer as libra");

        this.denarii = denarii;
        this.libra = libra;
    }

    @Override
    public final DefaultMoney createNewInstance() {
        return new DefaultMoney(this);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultMoney other = (DefaultMoney) obj;
        return Objects.equals(denarii, other.denarii)
                && Objects.equals(libra, other.libra);
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
        return Objects.hash(denarii, libra);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("denarii", denarii.getValue())
                .add("libra", libra.getValue()).toString();
    }

}
