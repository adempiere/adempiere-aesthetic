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

package org.eevolution.context.workflow.domain

import org.eevolution.context.workflow.domain.model.WorkflowAccess
import org.eevolution.context.workflow.domain.workflowAccessRepositoryApi.WorkflowAccessRepository
import org.eevolution.context.workflow.domain.workflowAccessServiceApi.WorkflowAccessService
import org.eevolution.context.workflow.domain.service.workflowAccessServiceBase
import org.eevolution.context.kernel.domain.ubiquitouslanguage._
import zio.{ RIO, ZLayer }

/*
* WorkflowAccess Service Module Package Object with the implementation for WorkflowAccess Domain Service
*
* Default implementation to WorkflowAccess Domain Service Base
* this class is generated from the Application Dictionary if it does not exist and 
* extends from the base contract class, the developer can add or modify the Api or create their own contract
*/
package object workflowAccessServiceModule extends workflowAccessServiceBase {

  case class Live(workflowAccessRepository: WorkflowAccessRepository.Service) extends Service(workflowAccessRepository) {
  
  }
  
  object WorkflowAccessServiceLayer {

    def live: ZLayer[WorkflowAccessRepository, Nothing, WorkflowAccessService] = ZLayer.fromService[
      WorkflowAccessRepository.Service,
      WorkflowAccessService.Service
    ](workflowAccessRepository => Live(workflowAccessRepository))

  }
}
  
