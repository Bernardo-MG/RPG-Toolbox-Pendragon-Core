package com.wandrell.tabletop.pendragon.model.inventory;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public final class DefaultStash implements Stash {

    private final Collection<Item> items = new LinkedList<>();
    private final Money            money;
    private final String           name;

    public DefaultStash(final String name) {
        super();

        this.name = name;
        money = new DefaultMoney(0, 0);
    }

    @Override
    public final void addItem(final Item item) {
        getItemsModifiable().add(item);
    }

    @Override
    public final void clearItems() {
        getItemsModifiable().clear();
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
    public final String getName() {
        return name;
    }

    @Override
    public final void removeItem(final Item item) {
        getItemsModifiable().remove(item);
    }

    private final Collection<Item> getItemsModifiable() {
        return items;
    }

}
