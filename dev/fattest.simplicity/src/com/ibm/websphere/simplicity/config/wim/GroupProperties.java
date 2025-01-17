/*******************************************************************************
 * Copyright (c) 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.websphere.simplicity.config.wim;

import javax.xml.bind.annotation.XmlElement;

import com.ibm.websphere.simplicity.config.ConfigElement;
import com.ibm.websphere.simplicity.config.ConfigElementList;

/**
 * Configuration for the following nested elements:
 *
 * <ul>
 * <li>ldapRegistry --> groupConfiguration</li>
 * </ul>
 */
public class GroupProperties extends ConfigElement {

    private DynamicMemberAttribute dynamicMemberAttribute;
    private ConfigElementList<MemberAttribute> memberAttribute;
    private MembershipAttribute membershipAttribute;

    /**
     * @return the dynamicMemberAttribute
     */
    public DynamicMemberAttribute getDynamicMemberAttribute() {
        return dynamicMemberAttribute;
    }

    /**
     * @return the memberAttribute
     */
    public ConfigElementList<MemberAttribute> getMemberAttributes() {
        return (memberAttribute == null) ? (memberAttribute = new ConfigElementList<MemberAttribute>()) : memberAttribute;
    }

    /**
     * @return the membershipAttribute
     */
    public MembershipAttribute getMembershipAttribute() {
        return membershipAttribute;
    }

    /**
     * @param dynamicMemberAttribute the dynamicMemberAttribute to set
     */
    @XmlElement(name = "dynamicMemberAttribute")
    public void setDynamicMemberAttribute(DynamicMemberAttribute dynamicMemberAttribute) {
        this.dynamicMemberAttribute = dynamicMemberAttribute;
    }

    /**
     * @param memberAttribute the memberAttribute to set
     */
    @XmlElement(name = "memberAttribute")
    public void setMemberAttributes(ConfigElementList<MemberAttribute> memberAttribute) {
        this.memberAttribute = memberAttribute;
    }

    /**
     * @param membershipAttribute the membershipAttribute to set
     */
    @XmlElement(name = "membershipAttribute")
    public void setMembershipAttribute(MembershipAttribute membershipAttribute) {
        this.membershipAttribute = membershipAttribute;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append(getClass().getSimpleName()).append("{ ");

        if (dynamicMemberAttribute != null) {
            sb.append("dynamicMemberAttribute=\"").append(dynamicMemberAttribute).append("\" ");;
        }
        if (memberAttribute != null) {
            sb.append("memberAttribute=\"").append(memberAttribute).append("\" ");;
        }
        if (membershipAttribute != null) {
            sb.append("membershipAttribute=\"").append(membershipAttribute).append("\" ");;
        }

        sb.append("}");

        return sb.toString();
    }
}
