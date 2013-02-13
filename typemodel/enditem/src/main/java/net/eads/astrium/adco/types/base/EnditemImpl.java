/*
 * Copyright 2012 Astrium Space Transportation. All rights reserved.
 * Use is subject to license terms.
 *
 * $Id: EnditemImpl.java 24 2013-02-05 12:52:07Z sta4152 $
 * $Date: 2013-02-05 13:52:07 +0100 (Di, 05 Feb 2013) $
 */
package net.eads.astrium.adco.types.base;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * Enditem instances are immutable facts that are generated outside.
 *
 * @author <a href="mailto:Johannes.Stamminger@Astrium.EADS.net">Johannes Stamminger</a>
 * @version $Revision: 24 $
 */
public class EnditemImpl {

    private String fName;
    private List<String> fIds;
    private String fOpsName;
    private String fPathName;
    private Integer fSid;
    private long fTime;


    public EnditemImpl() { }

    public EnditemImpl(String name, Collection<String> ids, long time) {
        fName = name;
        fTime = time;
        setIds(ids);
    }

    public String getName() {
        return fName;
    }

    public void setName(String name) {
        fName = name;
    }

    private void asureIdsInit() {
        if (fIds == null) {
            fIds = new ArrayList<String>();
        }
    }

    public List<String> getIds() {
        addIds(fOpsName, fPathName, fSid == null ? null : fSid.toString());
        if (fIds == null) {
            return Collections.emptyList();
        } else {
            return Collections.unmodifiableList(fIds);
        }
    }

    public void setIds(Collection<String> ids) {
        if (ids != null && ids.size() > 0) {
            asureIdsInit();
            fIds.addAll(ids);
        }
    }

    public void addIds(String... ids) {
        if (ids != null) {
            for (String id: ids) {
                addId(id);
            }
        }
    }

    public void addId(String id) {
        if (id != null) {
            asureIdsInit();
            if (!fIds.contains(id)) {
                fIds.add(id);
            }
        }
    }

    public void removeId(String id) {
        if (fIds != null) {
            fIds.remove(id);
        }
    }

    public String getOpsName() {
        return fOpsName;
    }

    public void setOpsName(String opsName) {
        fOpsName = opsName;
    }

    public String getPathName() {
        return fPathName;
    }

    public void setPathName(String pathName) {
        fPathName = pathName;
    }

    public Integer getSid() {
        return fSid;
    }

    public void setSid(Integer sid) {
        fSid = sid;
    }

    public long getTime() {
        return fTime;
    }

    public void setTime(long time) {
        fTime = time;
    }

}
