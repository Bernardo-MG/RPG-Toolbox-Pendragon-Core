package com.wandrell.tabletop.pendragon.model.inventory;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;

import com.wandrell.tabletop.pendragon.model.character.Horse;

public final class DefaultHorseStash implements HorseStash {

    private final Stash baseStash;
    private Horse       horse;

    public DefaultHorseStash(final DefaultHorseStash stash) {
        super();

        checkNotNull(stash, "Received a null pointer as stash");

        baseStash = stash.baseStash.createNewInstance();
        horse = stash.horse.createNewInstance();
    }

    public DefaultHorseStash(final String name, final Horse horse) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(horse, "Received a null pointer as horse");

        baseStash = new DefaultStash(name);
        this.horse = horse;
    }

    @Override
    public final void addItem(final Item item) {
        getBaseStash().addItem(item);
    }

    @Override
    public final void clearItems() {
        getBaseStash().clearItems();
    }

    @Override
    public final DefaultHorseStash createNewInstance() {
        return new DefaultHorseStash(this);
    }

    @Override
    public final Horse getHorse() {
        return horse;
    }

    @Override
    public final Collection<Item> getItems() {
        return getBaseStash().getItems();
    }

    @Override
    public final Money getMoney() {
        return getBaseStash().getMoney();
    }

    @Override
    public final String getName() {
        return getBaseStash().getName();
    }

    @Override
    public final void removeItem(final Item item) {
        getBaseStash().removeItem(item);
    }

    @Override
    public final void setHorse(final Horse horse) {
        this.horse = horse;
    }

    private final Stash getBaseStash() {
        return baseStash;
    }

}
