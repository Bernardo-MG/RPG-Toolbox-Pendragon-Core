package com.wandrell.tabletop.rpg.pendragon.inventory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultAdditionalBelongingsSetData implements
	AdditionalBelongingsSetData, NewInstantiable {

    private final DefaultMoneyData dataMoney;
    private String fileTable = null;
    private Boolean flagHasToChoose = false;
    private final List<String> listEquipableItemsFiles = new ArrayList<String>();
    private final List<String> listHorsesFiles = new ArrayList<String>();
    private final List<String> listPetsFiles = new ArrayList<String>();
    private final List<ValueHandler<Integer>> listRerolls = new ArrayList<ValueHandler<Integer>>();
    private final List<String> listShieldsFiles = new ArrayList<String>();
    private final List<String> listWeaponsFiles = new ArrayList<String>();
    private String nameMoney = "";

    public DefaultAdditionalBelongingsSetData() {
	super();

	dataMoney = new DefaultMoneyData();
    }

    public DefaultAdditionalBelongingsSetData(
	    final DefaultAdditionalBelongingsSetData itemSet) {
	super();

	fileTable = itemSet.fileTable;

	flagHasToChoose = itemSet.flagHasToChoose;

	nameMoney = itemSet.nameMoney;

	dataMoney = new DefaultMoneyData(itemSet.dataMoney);

	listRerolls.addAll(itemSet.listRerolls);

	for (final String item : itemSet.listEquipableItemsFiles) {
	    listEquipableItemsFiles.add(item);
	}

	for (final String item : itemSet.listWeaponsFiles) {
	    listWeaponsFiles.add(item);
	}

	for (final String horse : itemSet.listHorsesFiles) {
	    listHorsesFiles.add(horse);
	}

    }

    @Override
    public DefaultAdditionalBelongingsSetData createNewInstance() {
	return new DefaultAdditionalBelongingsSetData(this);
    }

    @Override
    public boolean equals(final Object obj) {
	final DefaultAdditionalBelongingsSetData received;
	boolean equals;

	if (super.equals(obj)) {
	    received = (DefaultAdditionalBelongingsSetData) obj;
	    if (received.dataMoney == null) {
		equals = (dataMoney == null);
	    } else {
		equals = (received.dataMoney.equals(dataMoney));
	    }
	    if ((equals) && (received.fileTable == null)) {
		equals = (fileTable == null);
	    } else if (equals) {
		equals = (received.fileTable.equals(fileTable));
	    }
	    if ((equals) && (received.flagHasToChoose == null)) {
		equals = (flagHasToChoose == null);
	    } else if (equals) {
		equals = (received.flagHasToChoose.equals(flagHasToChoose));
	    }
	    if ((equals) && (received.listEquipableItemsFiles == null)) {
		equals = (listEquipableItemsFiles == null);
	    } else if (equals) {
		equals = (received.listEquipableItemsFiles
			.equals(listEquipableItemsFiles));
	    }
	    if ((equals) && (received.listHorsesFiles == null)) {
		equals = (listHorsesFiles == null);
	    } else if (equals) {
		equals = (received.listHorsesFiles.equals(listHorsesFiles));
	    }
	    if ((equals) && (received.listPetsFiles == null)) {
		equals = (listPetsFiles == null);
	    } else if (equals) {
		equals = (received.listPetsFiles.equals(listPetsFiles));
	    }
	    if ((equals) && (received.listRerolls == null)) {
		equals = (listRerolls == null);
	    } else if (equals) {
		equals = (received.listRerolls.equals(listRerolls));
	    }
	    if ((equals) && (received.listShieldsFiles == null)) {
		equals = (listShieldsFiles == null);
	    } else if (equals) {
		equals = (received.listShieldsFiles.equals(listShieldsFiles));
	    }
	    if ((equals) && (received.listWeaponsFiles == null)) {
		equals = (listWeaponsFiles == null);
	    } else if (equals) {
		equals = (received.listWeaponsFiles.equals(listWeaponsFiles));
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
    public Collection<String> getEquipableItemsFiles() {
	return Collections.unmodifiableCollection(getEquipableItemsFilesList());
    }

    @Override
    public Collection<String> getHorsesFiles() {
	return Collections.unmodifiableCollection(getHorsesFilesList());
    }

    @Override
    public DefaultMoneyData getMoneyData() {
	return dataMoney;
    }

    @Override
    public String getMoneyName() {
	return nameMoney;
    }

    @Override
    public Collection<String> getPetsFiles() {
	return Collections.unmodifiableCollection(getPetsFilesList());
    }

    @Override
    public Collection<ValueHandler<Integer>> getRerolls() {
	return Collections.unmodifiableCollection(getRerollsList());
    }

    @Override
    public Collection<String> getShieldsFiles() {
	return Collections.unmodifiableCollection(getShieldsFilesList());
    }

    @Override
    public String getTableFile() {
	return fileTable;
    }

    @Override
    public Collection<String> getWeaponsFiles() {
	return Collections.unmodifiableCollection(getWeaponsFilesList());
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((dataMoney == null) ? 0 : dataMoney.hashCode());
	result = prime * result
		+ ((fileTable == null) ? 0 : fileTable.hashCode());
	result = prime * result
		+ ((flagHasToChoose == null) ? 0 : flagHasToChoose.hashCode());
	result = prime
		* result
		+ ((listEquipableItemsFiles == null) ? 0
			: listEquipableItemsFiles.hashCode());
	result = prime * result
		+ ((listHorsesFiles == null) ? 0 : listHorsesFiles.hashCode());
	result = prime * result
		+ ((listPetsFiles == null) ? 0 : listPetsFiles.hashCode());
	result = prime * result
		+ ((listRerolls == null) ? 0 : listRerolls.hashCode());
	result = prime
		* result
		+ ((listShieldsFiles == null) ? 0 : listShieldsFiles.hashCode());
	result = prime
		* result
		+ ((listWeaponsFiles == null) ? 0 : listWeaponsFiles.hashCode());
	result = prime * result
		+ ((nameMoney == null) ? 0 : nameMoney.hashCode());
	return result;
    }

    @Override
    public Boolean hasToChoose() {
	return flagHasToChoose;
    }

    public void setEquippableItemsFiles(final Collection<String> files) {
	getEquipableItemsFilesList().clear();
	for (final String file : files) {
	    getEquipableItemsFilesList().add(file);
	}
    }

    public void setHasToChoose(final Boolean hasToChoose) {
	this.flagHasToChoose = hasToChoose;
    }

    public void setHorsesFiles(final Collection<String> files) {
	getHorsesFilesList().clear();
	for (final String file : files) {
	    getHorsesFilesList().add(file);
	}
    }

    public void setMoneyName(final String nameMoney) {
	this.nameMoney = nameMoney;
    }

    public void setPetsFiles(final Collection<String> files) {
	getPetsFilesList().clear();
	for (final String file : files) {
	    getPetsFilesList().add(file);
	}
    }

    public void setReroll(final String table,
	    final Collection<ValueHandler<Integer>> rerolls) {
	fileTable = table;
	for (final ValueHandler<Integer> reroll : rerolls) {
	    listRerolls.add(reroll);
	}
    }

    public void setShieldsFiles(final Collection<String> files) {
	getShieldsFilesList().clear();
	for (final String file : files) {
	    getShieldsFilesList().add(file);
	}
    }

    public void setWeaponsFiles(final Collection<String> files) {
	getWeaponsFilesList().clear();
	for (final String file : files) {
	    getWeaponsFilesList().add(file);
	}
    }

    protected List<String> getEquipableItemsFilesList() {
	return listEquipableItemsFiles;
    }

    protected List<String> getHorsesFilesList() {
	return listHorsesFiles;
    }

    protected List<String> getPetsFilesList() {
	return listPetsFiles;
    }

    protected List<ValueHandler<Integer>> getRerollsList() {
	return listRerolls;
    }

    protected List<String> getShieldsFilesList() {
	return listShieldsFiles;
    }

    protected List<String> getWeaponsFilesList() {
	return listWeaponsFiles;
    }

}
