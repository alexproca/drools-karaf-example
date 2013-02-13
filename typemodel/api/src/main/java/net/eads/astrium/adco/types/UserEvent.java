/*
 * Copyright 2012 Astrium Space Transportation. All rights reserved.
 * Use is subject to license terms.
 *
 * $Id: UserEvent.java 16 2013-01-31 22:59:56Z sta4152 $
 * $Date: 2013-01-31 23:59:56 +0100 (Do, 31 Jan 2013) $
 */
package net.eads.astrium.adco.types;


/**
 * UserEvent instances are generated from within the rules engine are represent notifications to the user.
 *
 * @author <a href="mailto:Johannes.Stamminger@Astrium.EADS.net">Johannes Stamminger</a>
 * @version $Revision: 16 $
 */
public interface UserEvent {

    long getTimestamp();

    void setTimestamp(long timestamp);

    /**
     * E.g. monitoring exception, symbol detection.
     */
    String getType();

    void setType(String type);

    String getText();

    void setText(String text);

    String getSource();

    void setSource(String source);
}
