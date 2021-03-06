/*
 * Copyright 2012 Astrium Space Transportation. All rights reserved.
 * Use is subject to license terms.
 *
 * $Id: EventMessage.java 11 2013-01-24 19:57:58Z sta4152 $
 * $Date: 2013-01-24 20:57:58 +0100 (Do, 24 Jan 2013) $
 */
package net.eads.astrium.adco.types;


/**
 * @author <a href="mailto:Johannes.Stamminger@Astrium.EADS.net">Johannes Stamminger</a>
 * @version $Revision: 11 $
 */
public interface EventMessage extends Enditem {

    String getMessage();
}
