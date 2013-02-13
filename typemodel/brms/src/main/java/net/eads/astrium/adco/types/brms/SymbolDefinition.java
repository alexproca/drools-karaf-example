/*
 * Copyright 2012 Astrium Space Transportation. All rights reserved.
 * Use is subject to license terms.
 *
 * $Id: SymbolImpl.java 11 2013-01-24 19:57:58Z sta4152 $
 * $Date: 2013-01-24 20:57:58 +0100 (Do, 24. Jan 2013) $
 */
package net.eads.astrium.adco.types.brms;


import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import net.eads.astrium.adco.types.UserSymbolDefinition;


/**
 * @author <a href="mailto:Johannes.Stamminger@Astrium.EADS.net">Johannes Stamminger</a>
 * @version $Revision: 11 $
 */
public class SymbolDefinition implements UserSymbolDefinition {

    private String fId;
    private long fTimestamp;
    private String fClassName;
    private Map<String, Serializable> fProperties;


    public SymbolDefinition() { }


    public SymbolDefinition(String id) {
        fId = id;
    }

    public SymbolDefinition(String id, Date timestamp) {
        fId = id;
        fTimestamp = timestamp.getTime();
    }

    @Override
    public String getId() {
        return fId;
    }

    public void setId(String id) {
        fId = id;
    }

    @Override
    public long getTimestamp() {
        return fTimestamp;
    }

    @Override
    public void setTimestamp(long timestamp) {
        fTimestamp = timestamp;
    }

    @Override
    public String getClassName() {
        return fClassName;
    }

    @Override
    public void setClassName(String className) {
        fClassName = className;
    }

    @Override
    public Map<String, Serializable> getProperties() {
        asurePropertiesInit();
        return fProperties;
    }

    private void asurePropertiesInit() {
        if (fProperties == null) {
            fProperties = new LinkedHashMap<String, Serializable>();
        }
    }

    @Override
    public Serializable getProperty(String name) {
        asurePropertiesInit();
        return fProperties.get(name);
    }

    public void setProperty(String name, Serializable value) {
        asurePropertiesInit();
        if (value == null) {
            fProperties.remove(name);
        } else {
            fProperties.put(name, value);
        }
    }
}
