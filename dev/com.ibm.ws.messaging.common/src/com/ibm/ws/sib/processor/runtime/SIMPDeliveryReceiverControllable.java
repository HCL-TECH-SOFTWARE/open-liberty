/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
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
package com.ibm.ws.sib.processor.runtime;


import com.ibm.ws.sib.utils.SIBUuid12;

/**
 * Interface to manipulate a flow of incoming messages from a remote
 * messaging engine.
 * This is the super interface for message flows that are request/response
 * (remote get) and also for message flows that are receive only (remote put)
 * @author tpm100
 */
public interface SIMPDeliveryReceiverControllable extends SIMPControllable
{
  
  /**
   * The possible states for this stream (to be implemented by the 
   * stream itself).
   */
  public static interface StreamState
  {
    public String toString();
    public int getValue();
  }
  
  /**
   * @return the StreamState of the stream
   * @author tpm
   */
  StreamState getStreamState();
  
  /**
   * @return the stream ID of this stream.
   * @author tpm
   */
  SIBUuid12 getStreamID();   
  
  /**
   * Return the health state of the stream set
   * 
   * @return HealthState    The state of the stream set
   */
  HealthState getHealthState(); 

}
