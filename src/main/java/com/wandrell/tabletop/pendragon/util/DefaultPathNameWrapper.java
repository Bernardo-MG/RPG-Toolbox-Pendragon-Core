package com.wandrell.tabletop.pendragon.util;

import java.nio.file.Path;

public final class DefaultPathNameWrapper implements PathNameWrapper {

    private final String name;
    private final Path path;

    public DefaultPathNameWrapper(final String name, final Path path) {
	super();
	this.name = name;
	this.path = path;
    }

    @Override
    public final boolean equals(final Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	DefaultPathNameWrapper other = (DefaultPathNameWrapper) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    @Override
    public final String getName() {
	return name;
    }

    @Override
    public final Path getPath() {
	return path;
    }

    @Override
    public final int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public final String toString() {
	return String.format("%s - %s", getName(), getPath());
    }

}
