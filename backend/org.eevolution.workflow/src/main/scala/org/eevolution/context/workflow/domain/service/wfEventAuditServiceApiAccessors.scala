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

package org.eevolution.context.workflow.domain.service

import org.eevolution.context.workflow.domain.model.WfEventAudit
import org.eevolution.context.workflow.domain.wfEventAuditRepositoryApi.WfEventAuditRepository
import org.eevolution.context.workflow.domain.wfEventAuditServiceApi.WfEventAuditService
import org.eevolution.context.kernel.domain.ubiquitouslanguage._
import zio.blocking.Blocking
import zio.RIO

/*
* Accessors method Trait for WfEventAudit Domain Service 
*
* The accessor methods are provided so that we can build programs without 
* bothering about the implementation details of the required modules. 
* The compiler will fully infer all the required modules to complete the task. 
* This class should not be modified since it is generated from the Application Dictionary 
* maybe any change made manually will be lost.
*/
trait wfEventAuditServiceApiAccessors {

  def getByAttributeName(attributeName: Option[String]): RIO[WfEventAuditService with WfEventAuditRepository, List[WfEventAudit]] =
   RIO.accessM(_.get.getByAttributeName(attributeName))
   
  def getByWfEventAuditId(wfEventAuditId: Id): RIO[WfEventAuditService with WfEventAuditRepository, Option[WfEventAudit]] =
   RIO.accessM(_.get.getByWfEventAuditId(wfEventAuditId))
   
  def getByDescription(description: Option[String]): RIO[WfEventAuditService with WfEventAuditRepository, List[WfEventAudit]] =
   RIO.accessM(_.get.getByDescription(description))
   

  def getAll: RIO[WfEventAuditService with WfEventAuditRepository, List[WfEventAudit]] =
    RIO.accessM(_.get.getAll)

  def getAllByClientId(tenantId: TableDirect): RIO[WfEventAuditService with WfEventAuditRepository, List[WfEventAudit]] =
    RIO.accessM(_.get.getAllByClientId(tenantId))
    
    def save(wfEventAudit: WfEventAudit): RIO[WfEventAuditService with WfEventAuditRepository, WfEventAudit] =
    RIO.accessM(_.get.save(wfEventAudit))  
   
}