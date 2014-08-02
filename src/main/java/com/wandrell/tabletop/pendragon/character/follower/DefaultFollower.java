package com.wandrell.tabletop.pendragon.character.follower;

import com.wandrell.tabletop.pendragon.character.DefaultPendragonPlayerCharacter;
import com.wandrell.tabletop.pendragon.character.PendragonBaseCharacter;

public final class DefaultFollower implements Follower {

    private PendragonBaseCharacter characterData;
    private String fileCharacter = "";
    private String job = "";

    public DefaultFollower() {
	super();
    }

    public DefaultFollower(final DefaultFollower data) {
	super();

	characterData = data.characterData;
	fileCharacter = data.fileCharacter;
	job = data.job;
    }

    public DefaultFollower(final String file, final String job) {
	super();
	this.fileCharacter = file;
	this.job = job;
    }

    public DefaultFollower(final String file, final String job,
	    final PendragonBaseCharacter character) {
	super();
	this.fileCharacter = file;
	this.job = job;
	characterData = character;
    }

    @Override
    public final DefaultFollower createNewInstance() {
	return new DefaultFollower(this);
    }

    @Override
    public final boolean equals(final Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	DefaultFollower other = (DefaultFollower) obj;
	if (job == null) {
	    if (other.job != null)
		return false;
	} else if (!job.equals(other.job))
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
    public final String getFile() {
	return fileCharacter;
    }

    @Override
    public final String getJob() {
	return job;
    }

    @Override
    public final int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((job == null) ? 0 : job.hashCode());
	return result;
    }

    public final void setFile(final String file) {
	if (file == null) {
	    throw new NullPointerException();
	}

	fileCharacter = file;
    }

    public final void setJob(final String job) {
	if (job == null) {
	    throw new NullPointerException();
	}

	this.job = job;
    }

    @Override
    public final String toString() {
	return getFile();
    }

    protected final void loadCharacter() {
	// setCharacterData(new
	// PlayerCharacterFileStreamer<DefaultPendragonPlayerCharacter>(
	// getFile()).read());
    }

    protected final void setCharacterData(
	    DefaultPendragonPlayerCharacter characterData) {
	if (characterData == null) {
	    throw new NullPointerException();
	}

	this.characterData = characterData;
    }

}
