package com.wandrell.tabletop.pendragon.inventory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.wandrell.tabletop.pendragon.conf.factory.PendragonFactory;
import com.wandrell.tabletop.valuehandler.ValueHandler;

public final class DefaultAdditionalBelongings implements AdditionalBelongings {

    private final Collection<String> equipableItemsFiles = new ArrayList<String>();
    private String fileTable = null;
    private Boolean hasToChoose = false;
    private final Collection<String> horsesFiles = new ArrayList<String>();
    private final PendragonMoney money;
    private String nameMoney = "";
    private final Collection<String> petsFiles = new ArrayList<String>();
    private final Collection<ValueHandler<Integer>> rerolls = new ArrayList<ValueHandler<Integer>>();
    private final Collection<String> shieldsFiles = new ArrayList<String>();
    private final Collection<String> weaponsFiles = new ArrayList<String>();

    public DefaultAdditionalBelongings() {
	super();

	money = PendragonFactory.getInstance().getMoney();
    }

    public DefaultAdditionalBelongings(final DefaultAdditionalBelongings itemSet) {
	super();

	fileTable = itemSet.fileTable;

	hasToChoose = itemSet.hasToChoose;

	nameMoney = itemSet.nameMoney;

	money = itemSet.money.createNewInstance();

	rerolls.addAll(itemSet.rerolls);

	for (final String item : itemSet.equipableItemsFiles) {
	    equipableItemsFiles.add(item);
	}

	for (final String item : itemSet.weaponsFiles) {
	    weaponsFiles.add(item);
	}

	for (final String horse : itemSet.horsesFiles) {
	    horsesFiles.add(horse);
	}

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
    public final PendragonMoney getMoney() {
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
    public final Collection<ValueHandler<Integer>> getRerolls() {
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

    public final void setEquippableItemsFiles(final Collection<String> files) {
	_getEquipableItemsFiles().clear();
	for (final String file : files) {
	    if (file == null) {
		throw new NullPointerException();
	    }

	    _getEquipableItemsFiles().add(file);
	}
    }

    public final void setHasToChoose(final Boolean hasToChoose) {
	if (hasToChoose == null) {
	    throw new NullPointerException();
	}

	this.hasToChoose = hasToChoose;
    }

    public final void setHorsesFiles(final Collection<String> files) {
	_getHorsesFiles().clear();
	for (final String file : files) {
	    if (file == null) {
		throw new NullPointerException();
	    }

	    _getHorsesFiles().add(file);
	}
    }

    public final void setMoneyName(final String nameMoney) {
	this.nameMoney = nameMoney;
    }

    public final void setPetsFiles(final Collection<String> files) {
	_getPetsFiles().clear();
	for (final String file : files) {
	    if (file == null) {
		throw new NullPointerException();
	    }

	    _getPetsFiles().add(file);
	}
    }

    public final void setReroll(final String table,
	    final Collection<ValueHandler<Integer>> rerolls) {
	fileTable = table;
	for (final ValueHandler<Integer> reroll : rerolls) {
	    if (reroll == null) {
		throw new NullPointerException();
	    }

	    rerolls.add(reroll);
	}
    }

    public final void setShieldsFiles(final Collection<String> files) {
	_getShieldsFiles().clear();
	for (final String file : files) {
	    if (file == null) {
		throw new NullPointerException();
	    }

	    _getShieldsFiles().add(file);
	}
    }

    public final void setWeaponsFiles(final Collection<String> files) {
	_getWeaponsFiles().clear();
	for (final String file : files) {
	    if (file == null) {
		throw new NullPointerException();
	    }

	    _getWeaponsFiles().add(file);
	}
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

    protected final Collection<ValueHandler<Integer>> _getRerolls() {
	return rerolls;
    }

    protected final Collection<String> _getShieldsFiles() {
	return shieldsFiles;
    }

    protected final Collection<String> _getWeaponsFiles() {
	return weaponsFiles;
    }

}
