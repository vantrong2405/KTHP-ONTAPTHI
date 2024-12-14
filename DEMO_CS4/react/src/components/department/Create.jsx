import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import Service from './Service'
import Util from '../../util'

export default function DepartmentCreate(props) {
  
  const [ department, setDepartment ] = useState({})
  const [ errors, setErrors ] = useState({})
  
  useEffect(() => {
    Util.initView(true)
  }, [])

  function create(e) {
    e.preventDefault()
    Service.create(department).then(() => {
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
          <form method="post" onSubmit={create}>
            <div className="row">
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="department_department_id">Department Id</label>
                <input id="department_department_id" name="DepartmentID" className="form-control form-control-sm" onChange={onChange} value={department.DepartmentID ?? '' } type="number" required />
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