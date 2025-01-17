/*******************************************************************************
 * Copyright (c) 2019, 2024 IBM Corporation and others.
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
package com.ibm.ws.fat.util.tck;

import java.io.File;
import java.util.Collections;
import java.util.Set;

/**
 * The TCK makes references to org.json classes that must be provided; others CNFEs ensue...
 */
public class OrgJsonArchiveProcessor extends AbstractArchiveWeaver {

    private final Set<File> files = Collections.singleton(new File(System.getProperty("wlp"),
                                                                   "/usr/servers/FATServer/json-20190722.jar"));

    @Override
    protected Set<File> getJarsToWeave() {
        return files;
    }
}
