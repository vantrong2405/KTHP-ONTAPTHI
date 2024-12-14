import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import Service from './Service'
import Util from '../../util'

export default function EmployeeTypeDetail(props) {
  
  const [ employeeType, setEmployeeType ] = useState({})
  
  useEffect(() => {
    get().finally(() => {
      Util.initView(true)
    })
  }, [ props.match.params.employeeTypeId ])
  
  function get() {
    return Service.get(props.match.params.employeeTypeId).then(response => {
      setEmployeeType(response.data.employeeType)
    }).catch(e => {
      alert(e.response.data.message)
    })
  }

  return (
    <div className="container">
      <div className="row">
        <div className="col">
          <form method="post">
            <div className="row">
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_type_employee_type_id">Employee Type Id</label>
                <input readOnly id="employee_type_employee_type_id" name="EmployeeTypeID" className="form-control form-control-sm" value={employeeType.EmployeeTypeID ?? '' } type="number" required />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_type_employee_type_name">Employee Type Name</label>
                <input readOnly id="employee_type_employee_type_name" name="EmployeeTypeName" className="form-control form-control-sm" value={employeeType.EmployeeTypeName ?? '' } maxLength="50" />
              </div>
              <div className="col-12">
                <Link className="btn btn-sm btn-secondary" to={Util.getRef('/employeeType')}>Back</Link>
                <Link className="btn btn-sm btn-primary" to={`/employeeType/edit/${employeeType.EmployeeTypeID}?ref=${encodeURIComponent(Util.getRef('/employeeType'))}`}>Edit</Link>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  )
}