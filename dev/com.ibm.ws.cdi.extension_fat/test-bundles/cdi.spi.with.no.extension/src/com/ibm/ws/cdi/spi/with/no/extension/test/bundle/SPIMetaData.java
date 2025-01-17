/*******************************************************************************
 * Copyright (c) 2020. 2023 IBM Corporation and others.
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
package com.ibm.ws.cdi.spi.with.no.extension.test.bundle;

import static org.osgi.service.component.annotations.ConfigurationPolicy.IGNORE;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.inject.spi.Extension;

import org.osgi.service.component.annotations.Component;

import com.ibm.ws.cdi.spi.with.no.extension.test.bundle.annotations.NewBDA;
import com.ibm.ws.cdi.spi.with.no.extension.test.bundle.annotations.NewBDATwo;
import com.ibm.ws.cdi.spi.with.no.extension.test.bundle.getclass.beaninjection.MyBeanInjectionString;
import com.ibm.ws.cdi.spi.with.no.extension.test.bundle.getclass.interceptor.ClassSPIInterceptor;
import com.ibm.ws.cdi.spi.with.no.extension.test.bundle.getclass.producer.ClassSPIRegisteredProducer;

import io.openliberty.cdi.spi.CDIExtensionMetadata;

@Component(service = CDIExtensionMetadata.class, configurationPolicy = IGNORE)
public class SPIMetaData implements CDIExtensionMetadata {

    @Override
    public Set<Class<?>> getBeanClasses() {
        Set<Class<?>> beans = new HashSet<Class<?>>();
        //This will register a producer class and expose it's produced beans to applications
        beans.add(ClassSPIRegisteredProducer.class);

        //This will register a regular bean which can be injected.
        beans.add(MyBeanInjectionString.class);

        //This will register an intercepter that can be applied to other beans.
        beans.add(ClassSPIInterceptor.class);

        return beans;
    }

    public Set<Class<? extends Annotation>> getBeanDefiningAnnotationClasses() {
        Set<Class<? extends Annotation>> BDAs = new HashSet<Class<? extends Annotation>>();
        BDAs.add(NewBDA.class);
        BDAs.add(NewBDATwo.class);

        return BDAs;
    }
}
