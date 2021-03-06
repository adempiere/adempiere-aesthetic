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

package org.eevolution.context.workflow.infrastructure.domain.repository

import io.getquill.NamingStrategy
import io.getquill.context.jdbc.JdbcContext
import io.getquill.context.sql.idiom.SqlIdiom
import org.eevolution.context.workflow.domain.model.WfNodeTrl
import org.eevolution.context.workflow.domain.wfNodeTrlRepositoryApi.WfNodeTrlRepository
import org.eevolution.context.kernel.domain.ubiquitouslanguage._
import org.eevolution.context.kernel.domain.util.EntityWrapper
import zio.RIO
import zio.blocking.Blocking

import scala.util.Try
/* 
* WfNodeTrl Repository Base Trait with the implementation for WfNodeTrl Repository Implementation
*
* Is a contract to define the Repository Base Implementation for WfNodeTrl Repository
* This class should not be modified since it is generated from the Application Dictionary 
* maybe any change made manually will be lost.
*/
trait wfNodeTrlRepositoryBase {

  abstract class Service[Dialect <: SqlIdiom, Naming <: NamingStrategy](
    val context: JdbcContext[Dialect, Naming],
    val blocking: Blocking.Service
  ) extends WfNodeTrlRepository.Service {

    import context._
  
     override def getAll: RIO[WfNodeTrlRepository, List[WfNodeTrl]] =
      blocking.blocking(
        RIO(
          performIO(
            runIO(query[WfNodeTrl])
          )
        )
      )

     override def getAllByClientId(tenantId: TableDirect): RIO[WfNodeTrlRepository,List[WfNodeTrl]] =
      blocking.blocking(
        RIO(
          performIO(
            runIO(query[WfNodeTrl].filter(_.clientId == lift(tenantId)))
          )
        )
      )
    
    override def save(wfNodeTrl: WfNodeTrl): RIO[Any, WfNodeTrl] = RIO.fromTry(
       Try(EntityWrapper.save(wfNodeTrl, wfNodeTrlProperties)) 
    )
    
		implicit val wfNodeTrlSchemaMeta : context.SchemaMeta[WfNodeTrl] = 
     schemaMeta[WfNodeTrl] ("AD_WF_Node_Trl",
     _.wfNodeId -> "AD_WF_Node_ID" ,
     _.language -> "AD_Language" ,
     _.name -> "Name" ,
     _.description -> "Description" ,
     _.isTranslated -> "IsTranslated" ,
     _.isActive -> "IsActive" ,
     _.created -> "Created" ,
     _.createdBy -> "CreatedBy" ,
     _.updated -> "Updated" ,
     _.updatedBy -> "UpdatedBy" ,
     _.clientId -> "AD_Client_ID" ,
     _.orgId -> "AD_Org_ID" ,
     _.help -> "Help" ,
     _.uuid -> "UUID" )

     def wfNodeTrlProperties: Seq[(String, String)] = wfNodeTrlSchemaMeta.entity.ast.quat.renames.toSeq  
    }
}        
