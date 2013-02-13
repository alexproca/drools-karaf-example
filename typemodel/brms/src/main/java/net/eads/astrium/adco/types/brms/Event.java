/*
 * Copyright 2012 Astrium Space Transportation. All rights reserved.
 * Use is subject to license terms.
 *
 * $Id: Event.java 16 2013-01-31 22:59:56Z sta4152 $
 * $Date: 2013-01-31 23:59:56 +0100 (Do, 31 Jan 2013) $
 */
package net.eads.astrium.adco.types.brms;


import net.eads.astrium.adco.types.UserEvent;


/**
 *
 * @author <a href="mailto:Johannes.Stamminger@Astrium.EADS.net">Johannes Stamminger</a>
 * @version $Revision: 16 $
 */
public class Event implements UserEvent {

    private long fTimestamp;
    private String fType;
    private String fText;
    private String fSource;

    @Override
    public long getTimestamp() {
        return fTimestamp;
    }

    @Override
    public void setTimestamp(long timestamp) {
        fTimestamp = timestamp;
    }

    @Override
    public String getType() {
        return fType;
    }

    @Override
    public void setType(String type) {
        fType = type;
    }

    @Override
    public String getText() {
        return fText;
    }

    @Override
    public void setText(String text) {
        fText = text;
    }

    @Override
    public String getSource() {
        return fSource;
    }

    @Override
    public void setSource(String source) {
        fSource = source;
    }
}
