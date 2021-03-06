package com.wandrell.tabletop.pendragon.model.inventory.armor;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.wandrell.tabletop.pendragon.model.inventory.DefaultItem;
import com.wandrell.tabletop.pendragon.model.inventory.Item;
import com.wandrell.tabletop.pendragon.model.inventory.Money;

public final class DefaultArmor implements Armor {

    private final Integer   armorValue;
    private final Integer   dexModifier;
    private final Boolean   heavyLoad;
    private final Item      item;
    private final ArmorType type;

    public DefaultArmor(final DefaultArmor armor) {
        super();

        checkNotNull(armor, "Received a null pointer as armor");

        item = armor.item.createNewInstance();
        type = armor.type;
        armorValue = armor.armorValue;
        dexModifier = armor.dexModifier;
        heavyLoad = armor.heavyLoad;
    }

    public DefaultArmor(final String name, final String description,
            final Money money, final ArmorType type, final Integer armorValue,
            final Integer dexModifier, final Boolean heavyLoad) {
        super();

        checkNotNull(type, "Received a null pointer as armor type");
        checkNotNull(armorValue, "Received a null pointer as armor value");
        checkNotNull(dexModifier,
                "Received a null pointer as dexterity modifier");
        checkNotNull(heavyLoad, "Received a null pointer as heavy load flag");

        this.item = new DefaultItem(name, description, money);
        this.type = type;
        this.armorValue = armorValue;
        this.dexModifier = dexModifier;
        this.heavyLoad = heavyLoad;
    }

    @Override
    public final DefaultArmor createNewInstance() {
        return new DefaultArmor(this);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultArmor other = (DefaultArmor) obj;
        return Objects.equal(getName(), other.getName());
    }

    @Override
    public final ArmorType getArmorType() {
        return type;
    }

    @Override
    public final Integer getArmorValue() {
        return armorValue;
    }

    @Override
    public final String getDescription() {
        return getBaseItem().getDescription();
    }

    @Override
    public final Integer getDexterityModifier() {
        return dexModifier;
    }

    @Override
    public final Money getMoney() {
        return getBaseItem().getMoney();
    }

    @Override
    public final String getName() {
        return getBaseItem().getName();
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(getName());
    }

    @Override
    public final Boolean isHeavyLoad() {
        return heavyLoad;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", getName())
                .toString();
    }

    private final Item getBaseItem() {
        return item;
    }

}
