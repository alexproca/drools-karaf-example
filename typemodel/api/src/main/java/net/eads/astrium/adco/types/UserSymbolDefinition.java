/*
 * Copyright 2010 Astrium Space Transportation. All rights reserved.
 * Use is subject to license terms.
 *
 * $Id: $
 * $Date: $
 */
package net.eads.astrium.adco.types;

import java.io.Serializable;
import java.util.Map;

/**
 * @author <a href="mailto:Johannes.Stamminger@Astrium.EADS.net">Johannes Stamminger</a>
 * @version $Revision: $
 */
public interface UserSymbolDefinition {

    String getId();

    String getClassName();

    void setClassName(String className);

    long getTimestamp();

    void setTimestamp(long timestamp);

    Map<String, Serializable> getProperties();

    Serializable getProperty(String name);

    void setProperty(String name, Serializable value);
}
