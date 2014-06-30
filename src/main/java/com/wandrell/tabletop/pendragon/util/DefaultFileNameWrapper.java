package com.wandrell.tabletop.pendragon.util;

import java.nio.file.Path;

public class DefaultFileNameWrapper implements FileNameWrapper {

    private final String name;
    private final Path path;

    public DefaultFileNameWrapper(final String name, final Path path) {
	super();
	this.name = name;
	this.path = path;
    }

    @Override
    public final Path getFile() {
	return path;
    }

    @Override
    public final String getName() {
	return name;
    }

}
