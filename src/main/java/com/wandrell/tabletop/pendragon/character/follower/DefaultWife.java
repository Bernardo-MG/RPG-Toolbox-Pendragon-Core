package com.wandrell.tabletop.pendragon.character.follower;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.wandrell.tabletop.pendragon.character.PendragonBaseCharacter;

public final class DefaultWife implements Wife {

    private PendragonBaseCharacter characterData;
    private final List<Child> children = new LinkedList<Child>();
    private String fileCharacter = "";
    private Integer yearWed = 0;

    public DefaultWife() {
	super();
    }

    public DefaultWife(final DefaultWife wife) {
	super();

	for (final Child child : wife.children) {
	    children.add(child);
	}

	yearWed = wife.yearWed;
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
    public final boolean equals(final Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	DefaultWife other = (DefaultWife) obj;
	if (characterData == null) {
	    if (other.characterData != null)
		return false;
	} else if (!characterData.equals(other.characterData))
	    return false;
	return true;
    }

    @Override
    public final PendragonBaseCharacter getCharacter() {
	if ((characterData == null) && (getFile() != null)
		&& (getFile().length() > 0)) {
	    loadCharacter();
	}
	return characterData;
    }

    @Override
    public final Collection<Child> getChildren() {
	return Collections.unmodifiableCollection(_getChildren());
    }

    @Override
    public final String getFile() {
	return fileCharacter;
    }

    @Override
    public final Integer getYearWed() {
	return yearWed;
    }

    @Override
    public final int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((characterData == null) ? 0 : characterData.hashCode());
	return result;
    }

    public final void setChildren(final Collection<Child> children) {
	_getChildren().clear();
	for (final Child child : children) {
	    if (child == null) {
		throw new NullPointerException();
	    }
	    _getChildren().add(child);
	}
    }

    public final void setFile(final String file) {
	fileCharacter = file;
    }

    public final void setWeddingYear(final Integer year) {
	yearWed = year;
    }

    @Override
    public final String toString() {
	return getFile();
    }

    protected final Collection<Child> _getChildren() {
	return children;
    }

    protected final void loadCharacter() {

    }

}
