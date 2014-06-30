package com.wandrell.tabletop.rpg.pendragon.inventory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.wandrell.tabletop.rpg.pendragon.conf.factory.PendragonFactory;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;

public class DefaultAdditionalBelongings implements AdditionalBelongings {

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
    public DefaultAdditionalBelongings createNewInstance() {
	return new DefaultAdditionalBelongings(this);
    }

    @Override
    public boolean equals(final Object obj) {
	final DefaultAdditionalBelongings received;
	boolean equals;

	if (super.equals(obj)) {
	    received = (DefaultAdditionalBelongings) obj;
	    if (received.money == null) {
		equals = (money == null);
	    } else {
		equals = (received.money.equals(money));
	    }
	    if ((equals) && (received.fileTable == null)) {
		equals = (fileTable == null);
	    } else if (equals) {
		equals = (received.fileTable.equals(fileTable));
	    }
	    if ((equals) && (received.hasToChoose == null)) {
		equals = (hasToChoose == null);
	    } else if (equals) {
		equals = (received.hasToChoose.equals(hasToChoose));
	    }
	    if ((equals) && (received.equipableItemsFiles == null)) {
		equals = (equipableItemsFiles == null);
	    } else if (equals) {
		equals = (received.equipableItemsFiles
			.equals(equipableItemsFiles));
	    }
	    if ((equals) && (received.horsesFiles == null)) {
		equals = (horsesFiles == null);
	    } else if (equals) {
		equals = (received.horsesFiles.equals(horsesFiles));
	    }
	    if ((equals) && (received.petsFiles == null)) {
		equals = (petsFiles == null);
	    } else if (equals) {
		equals = (received.petsFiles.equals(petsFiles));
	    }
	    if ((equals) && (received.rerolls == null)) {
		equals = (rerolls == null);
	    } else if (equals) {
		equals = (received.rerolls.equals(rerolls));
	    }
	    if ((equals) && (received.shieldsFiles == null)) {
		equals = (shieldsFiles == null);
	    } else if (equals) {
		equals = (received.shieldsFiles.equals(shieldsFiles));
	    }
	    if ((equals) && (received.weaponsFiles == null)) {
		equals = (weaponsFiles == null);
	    } else if (equals) {
		equals = (received.weaponsFiles.equals(weaponsFiles));
	    }
	    if ((equals) && (received.nameMoney == null)) {
		equals = (nameMoney == null);
	    } else if (equals) {
		equals = (received.nameMoney.equals(nameMoney));
	    }
	} else {
	    equals = false;
	}

	return equals;
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
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((money == null) ? 0 : money.hashCode());
	result = prime * result
		+ ((fileTable == null) ? 0 : fileTable.hashCode());
	result = prime * result
		+ ((hasToChoose == null) ? 0 : hasToChoose.hashCode());
	result = prime
		* result
		+ ((equipableItemsFiles == null) ? 0 : equipableItemsFiles
			.hashCode());
	result = prime * result
		+ ((horsesFiles == null) ? 0 : horsesFiles.hashCode());
	result = prime * result
		+ ((petsFiles == null) ? 0 : petsFiles.hashCode());
	result = prime * result + ((rerolls == null) ? 0 : rerolls.hashCode());
	result = prime * result
		+ ((shieldsFiles == null) ? 0 : shieldsFiles.hashCode());
	result = prime * result
		+ ((weaponsFiles == null) ? 0 : weaponsFiles.hashCode());
	result = prime * result
		+ ((nameMoney == null) ? 0 : nameMoney.hashCode());
	return result;
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

    public void setWeaponsFiles(final Collection<String> files) {
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
