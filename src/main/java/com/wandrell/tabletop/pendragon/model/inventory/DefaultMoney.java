package com.wandrell.tabletop.pendragon.model.inventory;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.stat.valuebox.DefaultValueBox;
import com.wandrell.tabletop.stat.valuebox.ValueBox;

public final class DefaultMoney implements Money {

    private final ValueBox denarii;
    private final ValueBox libra;

    public DefaultMoney() {
        this(0, 0);
    }

    public DefaultMoney(final DefaultMoney money) {
        super();

        checkNotNull(money, "Received a null pointer as money");

        denarii = new DefaultValueBox(money.denarii.getValue());
        libra = new DefaultValueBox(money.libra.getValue());
    }

    public DefaultMoney(final Integer libra, final Integer denarii) {
        super();

        checkNotNull(denarii, "Received a null pointer as denarii");
        checkNotNull(libra, "Received a null pointer as libra");

        this.denarii = new DefaultValueBox(denarii);
        this.libra = new DefaultValueBox(libra);
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
        return Objects.equals(getDenariiValueBox(), other.getDenariiValueBox())
                && Objects.equals(getLibraValueBox(), other.getLibraValueBox());
    }

    @Override
    public final Integer getDenarii() {
        return getDenariiValueBox().getValue();
    }

    @Override
    public final Integer getLibra() {
        return getLibraValueBox().getValue();
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getDenariiValueBox(), getLibraValueBox());
    }

    @Override
    public final void setDenarii(final Integer denarii) {
        getDenariiValueBox().setValue(denarii);
    }

    @Override
    public final void setLibra(final Integer libra) {
        getLibraValueBox().setValue(libra);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("denarii", getDenariiValueBox().getValue())
                .add("libra", getLibraValueBox().getValue()).toString();
    }

    private final ValueBox getDenariiValueBox() {
        return denarii;
    }

    private final ValueBox getLibraValueBox() {
        return libra;
    }

}
