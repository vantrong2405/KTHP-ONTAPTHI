import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import Service from './Service'
import Util from '../../util'

export default function EmployeeEdit(props) {
  
  const [ employee, setEmployee ] = useState({})
  const [ errors, setErrors ] = useState({})
  
  useEffect(() => {
    get().finally(() => {
      Util.initView(true)
    })
  }, [ props.match.params.employeeId, props.match.params.departmentId, props.match.params.employeeTypeId, props.match.params.branchId, props.match.params.jobPositionId ])
  
  function get() {
    return Service.edit(props.match.params.employeeId, props.match.params.departmentId, props.match.params.employeeTypeId, props.match.params.branchId, props.match.params.jobPositionId).then(response => {
      setEmployee(response.data.employee)
    }).catch(e => {
      alert(e.response.data.message)
    })
  }

  function edit(e) {
    e.preventDefault()
    Service.edit(props.match.params.employeeId, props.match.params.departmentId, props.match.params.employeeTypeId, props.match.params.branchId, props.match.params.jobPositionId, employee).then(() => {
      props.history.push(Util.getRef('/employee'))
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
    let data = { ...employee }
    data[e.target.name] = e.target.value
    setEmployee(data)
  }

  return (
    <div className="container">
      <div className="row">
        <div className="col">
          <form method="post" onSubmit={edit}>
            <div className="row">
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_employee_id">Employee Id</label>
                <input readOnly id="employee_employee_id" name="EmployeeID" className="form-control form-control-sm" onChange={onChange} value={employee.EmployeeID ?? '' } type="number" required />
                {errors.EmployeeID && <span className="text-danger">{errors.EmployeeID}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_last_name">Last Name</label>
                <input id="employee_last_name" name="LastName" className="form-control form-control-sm" onChange={onChange} value={employee.LastName ?? '' } maxLength="50" />
                {errors.LastName && <span className="text-danger">{errors.LastName}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_first_name">First Name</label>
                <input id="employee_first_name" name="FirstName" className="form-control form-control-sm" onChange={onChange} value={employee.FirstName ?? '' } maxLength="50" />
                {errors.FirstName && <span className="text-danger">{errors.FirstName}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_email">Email</label>
                <input id="employee_email" name="Email" className="form-control form-control-sm" onChange={onChange} value={employee.Email ?? '' } maxLength="50" />
                {errors.Email && <span className="text-danger">{errors.Email}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_date_of_birth">Date Of Birth</label>
                <input id="employee_date_of_birth" name="DateOfBirth" className="form-control form-control-sm" onChange={onChange} value={employee.DateOfBirth ?? '' } data-type="date" autoComplete="off" />
                {errors.DateOfBirth && <span className="text-danger">{errors.DateOfBirth}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_department_id">Department Id</label>
                <input readOnly id="employee_department_id" name="DepartmentID" className="form-control form-control-sm" onChange={onChange} value={employee.DepartmentID ?? '' } type="number" required />
                {errors.DepartmentID && <span className="text-danger">{errors.DepartmentID}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_employee_type_id">Employee Type Id</label>
                <input readOnly id="employee_employee_type_id" name="EmployeeTypeID" className="form-control form-control-sm" onChange={onChange} value={employee.EmployeeTypeID ?? '' } type="number" required />
                {errors.EmployeeTypeID && <span className="text-danger">{errors.EmployeeTypeID}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_branch_id">Branch Id</label>
                <input readOnly id="employee_branch_id" name="BranchID" className="form-control form-control-sm" onChange={onChange} value={employee.BranchID ?? '' } type="number" required />
                {errors.BranchID && <span className="text-danger">{errors.BranchID}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_gender">Gender</label>
                <input id="employee_gender" name="Gender" className="form-control form-control-sm" onChange={onChange} value={employee.Gender ?? '' } maxLength="50" />
                {errors.Gender && <span className="text-danger">{errors.Gender}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_ethnicity">Ethnicity</label>
                <input id="employee_ethnicity" name="Ethnicity" className="form-control form-control-sm" onChange={onChange} value={employee.Ethnicity ?? '' } maxLength="50" />
                {errors.Ethnicity && <span className="text-danger">{errors.Ethnicity}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_home_phone">Home Phone</label>
                <input id="employee_home_phone" name="HomePhone" className="form-control form-control-sm" onChange={onChange} value={employee.HomePhone ?? '' } maxLength="50" />
                {errors.HomePhone && <span className="text-danger">{errors.HomePhone}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_mobile_phone">Mobile Phone</label>
                <input id="employee_mobile_phone" name="MobilePhone" className="form-control form-control-sm" onChange={onChange} value={employee.MobilePhone ?? '' } maxLength="50" />
                {errors.MobilePhone && <span className="text-danger">{errors.MobilePhone}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_address">Address</label>
                <input id="employee_address" name="Address" className="form-control form-control-sm" onChange={onChange} value={employee.Address ?? '' } maxLength="50" />
                {errors.Address && <span className="text-danger">{errors.Address}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_city">City</label>
                <input id="employee_city" name="City" className="form-control form-control-sm" onChange={onChange} value={employee.City ?? '' } maxLength="50" />
                {errors.City && <span className="text-danger">{errors.City}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_state_province">State Province</label>
                <input id="employee_state_province" name="State_Province" className="form-control form-control-sm" onChange={onChange} value={employee.State_Province ?? '' } maxLength="50" />
                {errors.State_Province && <span className="text-danger">{errors.State_Province}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_country_region">Country Region</label>
                <input id="employee_country_region" name="Country_Region" className="form-control form-control-sm" onChange={onChange} value={employee.Country_Region ?? '' } maxLength="50" />
                {errors.Country_Region && <span className="text-danger">{errors.Country_Region}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_avatar">Avatar</label>
                <input id="employee_avatar" name="Avatar" className="form-control form-control-sm" onChange={onChange} value={employee.Avatar ?? '' } maxLength="50" />
                {errors.Avatar && <span className="text-danger">{errors.Avatar}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_job_position_id">Job Position Id</label>
                <input readOnly id="employee_job_position_id" name="JobPositionID" className="form-control form-control-sm" onChange={onChange} value={employee.JobPositionID ?? '' } type="number" required />
                {errors.JobPositionID && <span className="text-danger">{errors.JobPositionID}</span>}
              </div>
              <div className="col-12">
                <Link className="btn btn-sm btn-secondary" to={Util.getRef('/employee')}>Cancel</Link>
                <button className="btn btn-sm btn-primary">Submit</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  )
}