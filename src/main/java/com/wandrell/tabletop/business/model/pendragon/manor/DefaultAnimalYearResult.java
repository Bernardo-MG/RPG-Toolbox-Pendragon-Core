package com.wandrell.tabletop.business.model.pendragon.manor;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.pendragon.inventory.Money;

public final class DefaultAnimalYearResult implements AnimalYearResult {

    private final Boolean dying;
    private final Money   money;
    private final String  name;
    private final Boolean producesMoney;
    private final Boolean puppies;
    private final String  puppy;

    public DefaultAnimalYearResult(final String name, final Money money,
            final String puppy, final Boolean dying,
            final Boolean producesMoney, final Boolean puppies) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(money, "Received a null pointer as money");
        checkNotNull(puppy, "Received a null pointer as puppy");
        checkNotNull(dying, "Received a null pointer as dying flag");
        checkNotNull(producesMoney,
                "Received a null pointer as produces money flag");
        checkNotNull(puppies, "Received a null pointer as puppies flag");

        this.name = name;

        this.money = money;
        this.puppy = puppy;
        this.dying = dying;
        this.producesMoney = producesMoney;
        this.puppies = puppies;
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
        return puppies;
    }

    @Override
    public final Boolean isProducingMoney() {
        return producesMoney;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

}
