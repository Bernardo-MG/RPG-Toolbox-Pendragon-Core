package com.wandrell.tabletop.business.model.pendragon.character.follower;

import com.wandrell.tabletop.business.model.pendragon.character.PendragonBaseCharacter;

public final class DefaultFollower implements Follower {

    private final String fileCharacter;
    private final String job;

    public DefaultFollower(final DefaultFollower data) {
        super();

        fileCharacter = data.fileCharacter;
        job = data.job;
    }

    public DefaultFollower(final String file, final String job,
            final PendragonBaseCharacter characterData) {
        super();

        if (file == null) {
            throw new NullPointerException();
        }

        if (job == null) {
            throw new NullPointerException();
        }

        if (characterData == null) {
            throw new NullPointerException();
        }

        this.fileCharacter = file;
        this.job = job;
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
        if (fileCharacter == null) {
            if (other.fileCharacter != null)
                return false;
        } else if (!fileCharacter.equals(other.fileCharacter))
            return false;
        return true;
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
        result = prime * result
                + ((fileCharacter == null) ? 0 : fileCharacter.hashCode());
        return result;
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

}
