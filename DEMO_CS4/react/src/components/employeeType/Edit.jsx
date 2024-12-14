import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import Service from './Service'
import Util from '../../util'

export default function EmployeeTypeEdit(props) {
  
  const [ employeeType, setEmployeeType ] = useState({})
  const [ errors, setErrors ] = useState({})
  
  useEffect(() => {
    get().finally(() => {
      Util.initView(true)
    })
  }, [ props.match.params.employeeTypeId ])
  
  function get() {
    return Service.edit(props.match.params.employeeTypeId).then(response => {
      setEmployeeType(response.data.employeeType)
    }).catch(e => {
      alert(e.response.data.message)
    })
  }

  function edit(e) {
    e.preventDefault()
    Service.edit(props.match.params.employeeTypeId, employeeType).then(() => {
      props.history.push(Util.getRef('/employeeType'))
    }).catch((e) => {
      if (e.response.data.errors) {
        setErrors(e.response.data.errors)
      }
      else {
        alert(e.response.data.message)
      }
    })
  }

  function onChange(e) {
    let data = { ...employeeType }
    data[e.target.name] = e.target.value
    setEmployeeType(data)
  }

  return (
    <div className="container">
      <div className="row">
        <div className="col">
          <form method="post" onSubmit={edit}>
            <div className="row">
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_type_employee_type_id">Employee Type Id</label>
                <input readOnly id="employee_type_employee_type_id" name="EmployeeTypeID" className="form-control form-control-sm" onChange={onChange} value={employeeType.EmployeeTypeID ?? '' } type="number" required />
                {errors.EmployeeTypeID && <span className="text-danger">{errors.EmployeeTypeID}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_type_employee_type_name">Employee Type Name</label>
                <input id="employee_type_employee_type_name" name="EmployeeTypeName" className="form-control form-control-sm" onChange={onChange} value={employeeType.EmployeeTypeName ?? '' } maxLength="50" />
                {errors.EmployeeTypeName && <span className="text-danger">{errors.EmployeeTypeName}</span>}
              </div>
              <div className="col-12">
                <Link className="btn btn-sm btn-secondary" to={Util.getRef('/employeeType')}>Cancel</Link>
                <button className="btn btn-sm btn-primary">Submit</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  )
}