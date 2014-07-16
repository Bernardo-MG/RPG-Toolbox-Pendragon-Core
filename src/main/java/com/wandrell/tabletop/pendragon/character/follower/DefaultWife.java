package com.wandrell.tabletop.pendragon.character.follower;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.wandrell.tabletop.conf.factory.ValueHandlerFactory;
import com.wandrell.tabletop.pendragon.character.PendragonBaseCharacter;
import com.wandrell.tabletop.pendragon.conf.PendragonToken;
import com.wandrell.tabletop.valuehandler.ValueHandler;

public class DefaultWife implements Wife {

    private PendragonBaseCharacter characterData;
    private final List<Child> children = new LinkedList<Child>();
    private String fileCharacter = "";
    private final ValueHandler<Integer> yearWed;

    public DefaultWife() {
	super();
	yearWed = ValueHandlerFactory.getInstance().getValueHandler(
		PendragonToken.VH_YEAR_WED);
    }

    public DefaultWife(final DefaultWife wife) {
	super();

	for (final Child child : wife.children) {
	    children.add(child.createNewInstance());
	}

	yearWed = wife.yearWed.createNewInstance();
    }

    public DefaultWife(final String file) {
	this();
	fileCharacter = file;
    }

    public DefaultWife(final String file, final PendragonBaseCharacter character) {
	this(file);
	characterData = character;
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
	return Collections.unmodifiableCollection(_getChildren());
    }

    @Override
    public String getFile() {
	return fileCharacter;
    }

    @Override
    public ValueHandler<Integer> getYearWed() {
	return yearWed;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result
		+ ((children == null) ? 0 : children.hashCode());
	result = prime * result + ((yearWed == null) ? 0 : yearWed.hashCode());
	return result;
    }

    public void setChildren(final Collection<Child> children) {
	_getChildren().clear();
	for (final Child child : children) {
	    if (child == null) {
		throw new NullPointerException();
	    }
	    _getChildren().add(child);
	}
    }

    public void setFile(final String file) {
	fileCharacter = file;
    }

    @Override
    public String toString() {
	return getFile();
    }

    protected Collection<Child> _getChildren() {
	return children;
    }

    protected void loadCharacter() {

    }

}
