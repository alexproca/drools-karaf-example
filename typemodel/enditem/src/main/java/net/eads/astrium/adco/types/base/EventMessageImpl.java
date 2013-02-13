/*
 * Copyright 2012 Astrium Space Transportation. All rights reserved.
 * Use is subject to license terms.
 *
 * $Id: EventMessageImpl.java 16 2013-01-31 22:59:56Z sta4152 $
 * $Date: 2013-01-31 23:59:56 +0100 (Do, 31 Jan 2013) $
 */
package net.eads.astrium.adco.types.base;


import java.util.Collection;

import net.eads.astrium.adco.types.EventMessage;


/**
 * Event messages are immutable instances arriving that are generated outside and are added as facts
 * to a session.
 *
 * @author <a href="mailto:Johannes.Stamminger@Astrium.EADS.net">Johannes Stamminger</a>
 * @version $Revision: 16 $
 */
public class EventMessageImpl extends EnditemImpl implements EventMessage {

    private String fMessage;

    public EventMessageImpl() { }

    public EventMessageImpl(String name, Collection<String> ids, long time, String message) {
        super(name, ids, time);
        fMessage = message;
    }

    @Override
    public String getMessage() {
        return fMessage;
    }

    void setMessage(String message) {
        fMessage = message;
    }

}
