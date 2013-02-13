/*
 * Copyright 2012 Astrium Space Transportation. All rights reserved.
 * Use is subject to license terms.
 *
 * $Id: MeasurementImpl.java 16 2013-01-31 22:59:56Z sta4152 $
 * $Date: 2013-01-31 23:59:56 +0100 (Do, 31 Jan 2013) $
 */
package net.eads.astrium.adco.types.base;


import java.io.Serializable;
import java.util.Collection;

import net.eads.astrium.adco.types.Measurement;


/**
 * @author <a href="mailto:Johannes.Stamminger@Astrium.EADS.net">Johannes Stamminger</a>
 * @version $Revision: 16 $
 */
public class MeasurementImpl extends EnditemImpl implements Measurement {

    private String fUnit;
    private String fValueType;
    private Serializable fValue;

    public MeasurementImpl() { }

    public MeasurementImpl(String name,
                           Collection<String> ids,
                           long time,
                           Serializable value,
                           String valueType,
                           String unit) {
        super(name, ids, time);
        fValue = value;
        fUnit = unit;
        fValueType = valueType;
    }

    @Override
    public String getUnit() {
        return fUnit;
    }

    public void setUnit(String unit) {
        fUnit = unit;
    }

    public String getValueType() {
        return fValueType;
    }

    public void setValueType(String valueType) {
        fValueType = valueType;
    }

    public Serializable getValue() {
        return fValue;
    }

    public void setValue(Serializable value) {
        fValue = value;
    }
}
