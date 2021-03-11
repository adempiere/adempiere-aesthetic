/**
 * Copyright (C) 2003-2021, e-Evolution Consultants S.A. , http://www.e-evolution.com
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * Email: victor.perez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
 * Created by victor.perez@e-evolution.com , www.e-evolution.com
 */

package org.eevolution.context.workflow.infrastructure.service

import org.eevolution.context.workflow.domain.workflowTrlRepositoryApi.WorkflowTrlRepository
import org.eevolution.context.workflow.domain.workflowTrlServiceApi.WorkflowTrlService
import org.eevolution.context.workflow.infrastructure.service.grpc.gRPCWorkflowTrlServiceBase

/*
* gRPC WorkflowTrl Service Module Package Object with the implementation for gRPC WorkflowTrl Service
*
* Default implementation to gRPC WorkflowTrl Service Base
* this class is generated from the Application Dictionary if it does not exist and 
* extends from the base contract class, the developer can add or modify the Api or create their own contract
*/
package object gRPCWorkflowTrlServiceModule extends gRPCWorkflowTrlServiceBase {

  object Service extends Service[WorkflowTrlService with WorkflowTrlRepository] {
  
  }

}
