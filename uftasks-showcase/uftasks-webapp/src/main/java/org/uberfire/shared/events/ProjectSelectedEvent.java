package org.uberfire.shared.events;

/**
 * Created by nheron on 04/04/2016.
 */
public class ProjectSelectedEvent {
    private final String name;

    public ProjectSelectedEvent( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
