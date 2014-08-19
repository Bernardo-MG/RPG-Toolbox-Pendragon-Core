package com.wandrell.tabletop.pendragon.inventory;

import java.util.Collection;
import java.util.Collections;

import com.wandrell.tabletop.dice.Dice;

public final class DefaultAdditionalBelongings implements AdditionalBelongings {

    private final Collection<String> equipableItemsFiles;
    private final String             fileTable;
    private final Boolean            hasToChoose;
    private final Collection<String> horsesFiles;
    private final Money              money;
    private final String             nameMoney;
    private final Collection<String> petsFiles;
    private final Collection<Dice>   rerolls;
    private final Collection<String> shieldsFiles;
    private final Collection<String> weaponsFiles;

    public DefaultAdditionalBelongings(
            final Collection<String> equipableItemsFiles,
            final String fileTable, final Boolean hasToChoose,
            final Collection<String> horsesFiles, final Money money,
            final String nameMoney, final Collection<String> petsFiles,
            final Collection<Dice> rerolls,
            final Collection<String> shieldsFiles,
            final Collection<String> weaponsFiles) {
        super();

        // TODO: Check nulls

        this.equipableItemsFiles = equipableItemsFiles;
        this.fileTable = fileTable;
        this.hasToChoose = hasToChoose;
        this.horsesFiles = horsesFiles;
        this.money = money;
        this.nameMoney = nameMoney;
        this.petsFiles = petsFiles;
        this.rerolls = rerolls;
        this.shieldsFiles = shieldsFiles;
        this.weaponsFiles = weaponsFiles;
    }

    public DefaultAdditionalBelongings(final DefaultAdditionalBelongings itemSet) {
        super();

        fileTable = itemSet.fileTable;

        hasToChoose = itemSet.hasToChoose;

        nameMoney = itemSet.nameMoney;

        money = itemSet.money.createNewInstance();

        rerolls = itemSet.rerolls;
        equipableItemsFiles = itemSet.equipableItemsFiles;
        weaponsFiles = itemSet.weaponsFiles;
        horsesFiles = itemSet.horsesFiles;
        shieldsFiles = itemSet.shieldsFiles;
        petsFiles = itemSet.petsFiles;
    }

    @Override
    public final Collection<String> getEquipableItemsFiles() {
        return Collections.unmodifiableCollection(_getEquipableItemsFiles());
    }

    @Override
    public final Collection<String> getHorsesFiles() {
        return Collections.unmodifiableCollection(_getHorsesFiles());
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
    public final Collection<String> getPetsFiles() {
        return Collections.unmodifiableCollection(_getPetsFiles());
    }

    @Override
    public final Collection<Dice> getRerolls() {
        return Collections.unmodifiableCollection(_getRerolls());
    }

    @Override
    public final Collection<String> getShieldsFiles() {
        return Collections.unmodifiableCollection(_getShieldsFiles());
    }

    @Override
    public final String getTableFile() {
        return fileTable;
    }

    @Override
    public final Collection<String> getWeaponsFiles() {
        return Collections.unmodifiableCollection(_getWeaponsFiles());
    }

    @Override
    public final Boolean hasToChoose() {
        return hasToChoose;
    }

    protected final Collection<String> _getEquipableItemsFiles() {
        return equipableItemsFiles;
    }

    protected final Collection<String> _getHorsesFiles() {
        return horsesFiles;
    }

    protected final Collection<String> _getPetsFiles() {
        return petsFiles;
    }

    protected final Collection<Dice> _getRerolls() {
        return rerolls;
    }

    protected final Collection<String> _getShieldsFiles() {
        return shieldsFiles;
    }

    protected final Collection<String> _getWeaponsFiles() {
        return weaponsFiles;
    }

}
