package com.wandrell.tabletop.rpg.pendragon.util;

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
    public Path getFile() {
	return path;
    }

    @Override
    public String getName() {
	return name;
    }

}
