package com.wandrell.tabletop.rpg.pendragon.character.follower;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.wandrell.tabletop.rpg.conf.factory.ValueHandlerFactory;
import com.wandrell.tabletop.rpg.pendragon.character.PendragonBaseCharacter;
import com.wandrell.tabletop.rpg.pendragon.conf.PendragonLabels;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultWife implements Wife, NewInstantiable {

    private PendragonBaseCharacter characterData;
    private String fileCharacter = "";
    private final List<Child> listChildren = new ArrayList<Child>();
    private final ValueHandler<Integer> vhYearWed;

    public DefaultWife() {
	super();
	vhYearWed = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_YEAR_WED);
    }

    public DefaultWife(final DefaultWife wife) {
	super();

	for (final Child child : wife.listChildren) {
	    listChildren.add(child.createNewInstance());
	}

	vhYearWed = wife.vhYearWed.createNewInstance();
    }

    public DefaultWife(final String file) {
	super();
	vhYearWed = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_YEAR_WED);
    }

    public DefaultWife(final String file, final PendragonBaseCharacter character) {
	super();
	vhYearWed = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonLabels.VH_YEAR_WED);
    }

    @Override
    public DefaultWife createNewInstance() {
	return new DefaultWife(this);
    }

    @Override
    public PendragonBaseCharacter getCharacter() {
	if ((characterData == null) && (getFile() != null)
		&& (getFile().length() > 0)) {
	    loadCharacter();
	}
	return characterData;
    }

    @Override
    public Collection<Child> getChildren() {
	return Collections.unmodifiableCollection(getChildrenList());
    }

    @Override
    public String getFile() {
	return fileCharacter;
    }

    @Override
    public ValueHandler<Integer> getYearWed() {
	return vhYearWed;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result
		+ ((listChildren == null) ? 0 : listChildren.hashCode());
	result = prime * result
		+ ((vhYearWed == null) ? 0 : vhYearWed.hashCode());
	return result;
    }

    public void setChildren(final Iterator<Child> iteratorChildren) {
	Child child;

	getChildrenList().clear();

	while (iteratorChildren.hasNext()) {
	    child = iteratorChildren.next();
	    getChildrenList().add(child);
	}
    }

    public void setFile(final String file) {
	fileCharacter = file;
    }

    private List<Child> getChildrenList() {
	return listChildren;
    }

    protected void loadCharacter() {

    }

}
