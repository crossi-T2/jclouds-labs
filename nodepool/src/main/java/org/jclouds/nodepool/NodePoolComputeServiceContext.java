/*
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.nodepool;

import org.jclouds.Context;
import org.jclouds.compute.ComputeService;
import org.jclouds.compute.Utils;
import org.jclouds.compute.internal.ComputeServiceContextImpl;
import org.jclouds.nodepool.internal.BaseNodePoolComputeService;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;

public class NodePoolComputeServiceContext extends ComputeServiceContextImpl {

   @Inject
   public NodePoolComputeServiceContext(Context backend, TypeToken<? extends Context> backendType,
            ComputeService computeService, Utils utils) {
      super(backend, backendType, computeService, utils);
   }

   @Override
   public BaseNodePoolComputeService getComputeService() {
      return BaseNodePoolComputeService.class.cast(super.getComputeService());
   }

   public NodePoolStats getPoolStats() {
      return new NodePoolStats(getComputeService().currentSize(), getComputeService().idleNodes(), getComputeService()
               .usedNodes(), getComputeService().allocationInProgressNodes(), getComputeService().maxNodes(),
               getComputeService().minNodes());
   }
}