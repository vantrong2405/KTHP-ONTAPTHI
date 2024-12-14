import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import Service from './Service'
import Util from '../../util'

export default function DepartmentEdit(props) {
  
  const [ department, setDepartment ] = useState({})
  const [ errors, setErrors ] = useState({})
  
  useEffect(() => {
    get().finally(() => {
      Util.initView(true)
    })
  }, [ props.match.params.departmentId ])
  
  function get() {
    return Service.edit(props.match.params.departmentId).then(response => {
      setDepartment(response.data.department)
    }).catch(e => {
      alert(e.response.data.message)
    })
  }

  function edit(e) {
    e.preventDefault()
    Service.edit(props.match.params.departmentId, department).then(() => {
      props.history.push(Util.getRef('/department'))
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
    let data = { ...department }
    data[e.target.name] = e.target.value
    setDepartment(data)
  }

  return (
    <div className="container">
      <div className="row">
        <div className="col">
          <form method="post" onSubmit={edit}>
            <div className="row">
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="department_department_id">Department Id</label>
                <input readOnly id="department_department_id" name="DepartmentID" className="form-control form-control-sm" onChange={onChange} value={department.DepartmentID ?? '' } type="number" required />
                {errors.DepartmentID && <span className="text-danger">{errors.DepartmentID}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="department_department_name">Department Name</label>
                <input id="department_department_name" name="DepartmentName" className="form-control form-control-sm" onChange={onChange} value={department.DepartmentName ?? '' } maxLength="50" />
                {errors.DepartmentName && <span className="text-danger">{errors.DepartmentName}</span>}
              </div>
              <div className="col-12">
                <Link className="btn btn-sm btn-secondary" to={Util.getRef('/department')}>Cancel</Link>
                <button className="btn btn-sm btn-primary">Submit</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  )
}