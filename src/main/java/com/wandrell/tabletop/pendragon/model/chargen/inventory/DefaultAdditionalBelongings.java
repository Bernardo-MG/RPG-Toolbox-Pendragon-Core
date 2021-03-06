package com.wandrell.tabletop.pendragon.model.chargen.inventory;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;

import com.wandrell.tabletop.dice.notation.DiceExpression;
import com.wandrell.tabletop.pendragon.model.character.Horse;
import com.wandrell.tabletop.pendragon.model.inventory.Item;
import com.wandrell.tabletop.pendragon.model.inventory.Money;
import com.wandrell.tabletop.pendragon.model.inventory.armor.Shield;
import com.wandrell.tabletop.pendragon.model.inventory.weapon.Weapon;
import com.wandrell.tabletop.pendragon.model.manor.Pet;

public final class DefaultAdditionalBelongings implements AdditionalBelongings {

    private final Boolean                    hasToChoose;
    private final Collection<Horse>          horses;
    private final Collection<Item>           items;
    private final Money                      money;
    private final String                     nameMoney;
    private final Collection<Pet>            pets;
    private final Collection<DiceExpression> rerolls;
    private final Collection<Shield>         shields;
    private final String                     table;
    private final Collection<Weapon>         weapons;

    public DefaultAdditionalBelongings(final Boolean hasToChoose,
            final Money money, final String nameMoney, final String table,
            final Collection<DiceExpression> rerolls,
            final Collection<Item> items, final Collection<Horse> horses,
            final Collection<Pet> pets, final Collection<Shield> shields,
            final Collection<Weapon> weapons) {
        super();

        checkNotNull(hasToChoose, "Received a null pointer as choose flag");
        checkNotNull(money, "Received a null pointer as money");
        checkNotNull(nameMoney, "Received a null pointer as money name");
        checkNotNull(table, "Received a null pointer as table");
        checkNotNull(rerolls, "Received a null pointer as re-rolls");
        checkNotNull(items, "Received a null pointer as equipment");
        checkNotNull(horses, "Received a null pointer as horses");
        checkNotNull(pets, "Received a null pointer as pets");
        checkNotNull(shields, "Received a null pointer as shields");
        checkNotNull(weapons, "Received a null pointer as weapons");

        this.hasToChoose = hasToChoose;
        this.money = money;
        this.nameMoney = nameMoney;
        this.rerolls = rerolls;

        this.table = table;

        this.items = items;
        this.horses = horses;
        this.pets = pets;
        this.shields = shields;
        this.weapons = weapons;
    }

    public DefaultAdditionalBelongings(
            final DefaultAdditionalBelongings belongings) {
        super();

        checkNotNull(belongings,
                "Received a null pointer as additional belongings");

        hasToChoose = belongings.hasToChoose;
        money = belongings.money;
        nameMoney = belongings.nameMoney;
        rerolls = belongings.rerolls;

        table = belongings.table;

        items = belongings.items;
        horses = belongings.horses;
        pets = belongings.pets;
        shields = belongings.shields;
        weapons = belongings.weapons;
    }

    @Override
    public final DefaultAdditionalBelongings createNewInstance() {
        return new DefaultAdditionalBelongings(this);
    }

    @Override
    public final Collection<Horse> getHorses() {
        return Collections.unmodifiableCollection(getHorsesModifiable());
    }

    @Override
    public final Collection<Item> getItems() {
        return Collections.unmodifiableCollection(getItemsModifiable());
    }

    @Override
    public final Money getMoney() {
        return money;
    }

    @Override
    public final String getMoneyName() {
        return nameMoney;
    }

    @Override
    public final Collection<Pet> getPets() {
        return Collections.unmodifiableCollection(getPetsModifiable());
    }

    @Override
    public final Collection<DiceExpression> getRerolls() {
        return Collections.unmodifiableCollection(getRerollsModifiable());
    }

    @Override
    public final String getRerollTable() {
        return table;
    }

    @Override
    public final Collection<Shield> getShields() {
        return Collections.unmodifiableCollection(getShieldsModifiable());
    }

    @Override
    public final Collection<Weapon> getWeapons() {
        return Collections.unmodifiableCollection(getWeaponsModifiable());
    }

    @Override
    public final Boolean hasToChoose() {
        return hasToChoose;
    }

    private final Collection<Horse> getHorsesModifiable() {
        return horses;
    }

    private final Collection<Item> getItemsModifiable() {
        return items;
    }

    private final Collection<Pet> getPetsModifiable() {
        return pets;
    }

    private final Collection<DiceExpression> getRerollsModifiable() {
        return rerolls;
    }

    private final Collection<Shield> getShieldsModifiable() {
        return shields;
    }

    private final Collection<Weapon> getWeaponsModifiable() {
        return weapons;
    }

}
