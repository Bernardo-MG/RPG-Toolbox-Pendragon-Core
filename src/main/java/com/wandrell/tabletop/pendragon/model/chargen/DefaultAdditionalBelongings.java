package com.wandrell.tabletop.pendragon.model.chargen;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;

import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.pendragon.model.character.Horse;
import com.wandrell.tabletop.pendragon.model.inventory.Item;
import com.wandrell.tabletop.pendragon.model.inventory.Money;
import com.wandrell.tabletop.pendragon.model.inventory.armor.Shield;
import com.wandrell.tabletop.pendragon.model.inventory.weapon.Weapon;
import com.wandrell.tabletop.pendragon.model.manor.Pet;

public final class DefaultAdditionalBelongings implements AdditionalBelongings {

    private final Boolean            hasToChoose;
    private final Collection<Horse>  horses;
    private final Collection<Item>   items;
    private final Money              money;
    private final String             nameMoney;
    private final Collection<Pet>    pets;
    private final Collection<Dice>   rerolls;
    private final Collection<Shield> shields;
    private final String             table;
    private final Collection<Weapon> weapons;

    public DefaultAdditionalBelongings(final Boolean hasToChoose,
            final Money money, final String nameMoney, final String table,
            final Collection<Dice> rerolls, final Collection<Item> items,
            final Collection<Horse> horses, final Collection<Pet> pets,
            final Collection<Shield> shields, final Collection<Weapon> weapons) {
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
    public final Collection<Dice> getRerolls() {
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

    private final Collection<Dice> getRerollsModifiable() {
        return rerolls;
    }

    private final Collection<Shield> getShieldsModifiable() {
        return shields;
    }

    private final Collection<Weapon> getWeaponsModifiable() {
        return weapons;
    }

}
