package com.wandrell.tabletop.pendragon.model.manor;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.pendragon.model.inventory.Money;

public final class DefaultAnimalYearResult implements AnimalYearResult {

    private final Boolean dying;
    private final Money   money;
    private final String  name;
    private final String  puppy;

    public DefaultAnimalYearResult(final DefaultAnimalYearResult result) {
        super();

        checkNotNull(result, "Received a null pointer as year result");

        name = result.name;

        money = result.money;
        puppy = result.puppy;
        dying = result.dying;
    }

    public DefaultAnimalYearResult(final String name, final Money money,
            final String puppy, final Boolean dying) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(money, "Received a null pointer as money");
        checkNotNull(puppy, "Received a null pointer as puppy");
        checkNotNull(dying, "Received a null pointer as dying flag");

        this.name = name;

        this.money = money;
        this.puppy = puppy;
        this.dying = dying;
    }

    @Override
    public final DefaultAnimalYearResult createNewInstance() {
        return new DefaultAnimalYearResult(this);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultAnimalYearResult other = (DefaultAnimalYearResult) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public final String getDescription() {
        return name;
    }

    @Override
    public final Money getMoney() {
        return money;
    }

    @Override
    public final String getPuppy() {
        return puppy;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final Boolean isDying() {
        return dying;
    }

    @Override
    public final Boolean isHavingPuppies() {
        return (getPuppy().length() > 0);
    }

    @Override
    public final Boolean isProducingMoney() {
        return (getMoney().getLibra() > 0) && (getMoney().getDenarii() > 0);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

}
