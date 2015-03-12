package com.wandrell.tabletop.pendragon.model.inventory;

import java.util.Collection;

import com.wandrell.tabletop.pendragon.model.character.Horse;

public final class DefaultHorseStash implements HorseStash {

    private final Stash baseStash;
    private Horse       horse;

    public DefaultHorseStash(final String name, final Horse horse) {
        super();

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
    public final Horse getHorse() {
        return horse;
    }

    @Override
    public final Collection<Item> getItems() {
        return getBaseStash().getItems();
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
