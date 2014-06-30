package com.wandrell.tabletop.pendragon.character.follower;

import com.wandrell.tabletop.pendragon.character.DefaultPendragonPlayerCharacter;
import com.wandrell.tabletop.pendragon.character.PendragonBaseCharacter;

public class DefaultFollower implements Follower {

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
    public DefaultFollower createNewInstance() {
	return new DefaultFollower(this);
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
    public String getFile() {
	return fileCharacter;
    }

    @Override
    public String getJob() {
	return job;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;

	result = prime * result
		+ ((fileCharacter == null) ? 0 : fileCharacter.hashCode());

	result = prime * result + ((job == null) ? 0 : job.hashCode());

	return result;
    }

    public void setFile(final String file) {
	if (file == null) {
	    throw new NullPointerException();
	}

	fileCharacter = file;
    }

    public void setJob(final String job) {
	if (job == null) {
	    throw new NullPointerException();
	}

	this.job = job;
    }

    @Override
    public String toString() {
	return getFile();
    }

    protected void loadCharacter() {
	// setCharacterData(new
	// PlayerCharacterFileStreamer<DefaultPendragonPlayerCharacter>(
	// getFile()).read());
    }

    protected void setCharacterData(
	    DefaultPendragonPlayerCharacter characterData) {
	if (characterData == null) {
	    throw new NullPointerException();
	}

	this.characterData = characterData;
    }

}
