import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import Service from './Service'
import Util from '../../util'

export default function DepartmentDelete(props) {
  
  const [ department, setDepartment ] = useState({})
  
  useEffect(() => {
    get().finally(() => {
      Util.initView(true)
    })
  }, [ props.match.params.departmentId ])
  
  function get() {
    return Service.delete(props.match.params.departmentId).then(response => {
      setDepartment(response.data.department)
    }).catch(e => {
      alert(e.response.data.message)
    })
  }

  function remove(e) {
    e.preventDefault()
    Service.delete(props.match.params.departmentId, department).then(() => {
      props.history.push(Util.getRef('/department'))
    }).catch((e) => {
      alert(e.response.data.message)
    })
  }

  return (
    <div className="container">
      <div className="row">
        <div className="col">
          <form method="post" onSubmit={remove}>
            <div className="row">
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="department_department_id">Department Id</label>
                <input readOnly id="department_department_id" name="DepartmentID" className="form-control form-control-sm" value={department.DepartmentID ?? '' } type="number" required />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="department_department_name">Department Name</label>
                <input readOnly id="department_department_name" name="DepartmentName" className="form-control form-control-sm" value={department.DepartmentName ?? '' } maxLength="50" />
              </div>
              <div className="col-12">
                <Link className="btn btn-sm btn-secondary" to={Util.getRef('/department')}>Cancel</Link>
                <button className="btn btn-sm btn-danger">Delete</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  )
}