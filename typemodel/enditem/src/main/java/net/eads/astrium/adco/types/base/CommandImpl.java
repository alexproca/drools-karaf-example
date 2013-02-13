/*
 * Copyright 2012 Astrium Space Transportation. All rights reserved.
 * Use is subject to license terms.
 *
 * $Id: CommandImpl.java 16 2013-01-31 22:59:56Z sta4152 $
 * $Date: 2013-01-31 23:59:56 +0100 (Do, 31 Jan 2013) $
 */
package net.eads.astrium.adco.types.base;


import java.util.Collection;

import net.eads.astrium.adco.types.Command;


/**
 * @author <a href="mailto:Johannes.Stamminger@Astrium.EADS.net">Johannes Stamminger</a>
 * @version $Revision: 16 $
 */
public class CommandImpl extends EnditemImpl implements Command {

    private String fText;

    public CommandImpl() { }

    public CommandImpl(String name, Collection<String> ids, long time, String text) {
        super(name, ids, time);
        fText = text;
    }

    @Override
    public String getText() {
        return fText;
    }

    void setText(String text) {
        fText = text;
    }
}
