import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import Service from './Service'
import Util from '../../util'

export default function EmployeeDelete(props) {
  
  const [ employee, setEmployee ] = useState({})
  
  useEffect(() => {
    get().finally(() => {
      Util.initView(true)
    })
  }, [ props.match.params.employeeId, props.match.params.departmentId, props.match.params.employeeTypeId, props.match.params.branchId, props.match.params.jobPositionId ])
  
  function get() {
    return Service.delete(props.match.params.employeeId, props.match.params.departmentId, props.match.params.employeeTypeId, props.match.params.branchId, props.match.params.jobPositionId).then(response => {
      setEmployee(response.data.employee)
    }).catch(e => {
      alert(e.response.data.message)
    })
  }

  function remove(e) {
    e.preventDefault()
    Service.delete(props.match.params.employeeId, props.match.params.departmentId, props.match.params.employeeTypeId, props.match.params.branchId, props.match.params.jobPositionId, employee).then(() => {
      props.history.push(Util.getRef('/employee'))
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
                <label className="form-label" htmlFor="employee_employee_id">Employee Id</label>
                <input readOnly id="employee_employee_id" name="EmployeeID" className="form-control form-control-sm" value={employee.EmployeeID ?? '' } type="number" required />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_last_name">Last Name</label>
                <input readOnly id="employee_last_name" name="LastName" className="form-control form-control-sm" value={employee.LastName ?? '' } maxLength="50" />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_first_name">First Name</label>
                <input readOnly id="employee_first_name" name="FirstName" className="form-control form-control-sm" value={employee.FirstName ?? '' } maxLength="50" />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_email">Email</label>
                <input readOnly id="employee_email" name="Email" className="form-control form-control-sm" value={employee.Email ?? '' } maxLength="50" />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_date_of_birth">Date Of Birth</label>
                <input readOnly id="employee_date_of_birth" name="DateOfBirth" className="form-control form-control-sm" value={employee.DateOfBirth ?? '' } data-type="date" autoComplete="off" />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_department_id">Department Id</label>
                <input readOnly id="employee_department_id" name="DepartmentID" className="form-control form-control-sm" value={employee.DepartmentID ?? '' } type="number" required />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_employee_type_id">Employee Type Id</label>
                <input readOnly id="employee_employee_type_id" name="EmployeeTypeID" className="form-control form-control-sm" value={employee.EmployeeTypeID ?? '' } type="number" required />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_branch_id">Branch Id</label>
                <input readOnly id="employee_branch_id" name="BranchID" className="form-control form-control-sm" value={employee.BranchID ?? '' } type="number" required />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_gender">Gender</label>
                <input readOnly id="employee_gender" name="Gender" className="form-control form-control-sm" value={employee.Gender ?? '' } maxLength="50" />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_ethnicity">Ethnicity</label>
                <input readOnly id="employee_ethnicity" name="Ethnicity" className="form-control form-control-sm" value={employee.Ethnicity ?? '' } maxLength="50" />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_home_phone">Home Phone</label>
                <input readOnly id="employee_home_phone" name="HomePhone" className="form-control form-control-sm" value={employee.HomePhone ?? '' } maxLength="50" />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_mobile_phone">Mobile Phone</label>
                <input readOnly id="employee_mobile_phone" name="MobilePhone" className="form-control form-control-sm" value={employee.MobilePhone ?? '' } maxLength="50" />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_address">Address</label>
                <input readOnly id="employee_address" name="Address" className="form-control form-control-sm" value={employee.Address ?? '' } maxLength="50" />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_city">City</label>
                <input readOnly id="employee_city" name="City" className="form-control form-control-sm" value={employee.City ?? '' } maxLength="50" />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_state_province">State Province</label>
                <input readOnly id="employee_state_province" name="State_Province" className="form-control form-control-sm" value={employee.State_Province ?? '' } maxLength="50" />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_country_region">Country Region</label>
                <input readOnly id="employee_country_region" name="Country_Region" className="form-control form-control-sm" value={employee.Country_Region ?? '' } maxLength="50" />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_avatar">Avatar</label>
                <input readOnly id="employee_avatar" name="Avatar" className="form-control form-control-sm" value={employee.Avatar ?? '' } maxLength="50" />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="employee_job_position_id">Job Position Id</label>
                <input readOnly id="employee_job_position_id" name="JobPositionID" className="form-control form-control-sm" value={employee.JobPositionID ?? '' } type="number" required />
              </div>
              <div className="col-12">
                <Link className="btn btn-sm btn-secondary" to={Util.getRef('/employee')}>Cancel</Link>
                <button className="btn btn-sm btn-danger">Delete</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  )
}