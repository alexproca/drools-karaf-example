/*
 * Copyright 2012 Astrium Space Transportation. All rights reserved.
 * Use is subject to license terms.
 *
 * $Id: UserSymbol.java 16 2013-01-31 22:59:56Z sta4152 $
 * $Date: 2013-01-31 23:59:56 +0100 (Do, 31 Jan 2013) $
 */
package net.eads.astrium.adco.types;


import java.io.Serializable;
import java.util.Map;


/**
 * @author <a href="mailto:Johannes.Stamminger@Astrium.EADS.net">Johannes Stamminger</a>
 * @version $Revision: 16 $
 */
public interface UserSymbol {

    String getId();

    String getClassName();

    void setClassName(String className);

    long getTimestamp();

    void setTimestamp(long timestamp);

    Map<String, Serializable> getProperties();

    Serializable getProperty(String name);

    void setProperty(String name, Serializable value);

}
