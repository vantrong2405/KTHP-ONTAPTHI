import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import Util from '../../util'
import Service from './Service'

export default function EmployeeIndex(props) {

  const [employees, setEmployees] = useState([])
  const [paging, setPaging] = useState({
    current: 1,
    size: 1,
    last: 1
  })

  useEffect(() => {
    Util.initView()
  }, [])

  useEffect(() => {
    get()
  }, [props.location])

  function get() {
    Service.get().then(response => {
      let query = Util.getQuery()
      setEmployees(response.data.employees)
      setPaging({
        current: parseInt(query.page) || 1,
        size: parseInt(query.size) || 10,
        last: response.data.last
      })
    }).catch(e => {
      alert(e.response.data.message)
    })
  }

  return (
    <div className="container">
      <div className="row">
        <div className="col">
          <div className="col-12"><input id="searchbar_toggle" type="checkbox" />
            <div id="searchbar" className="mb-4">
              <div className="form-group col-lg-2 me-2 mb-lg-0 mb-3">
                <select id="search_col" onChange={()=> Util.searchChange()} className="form-select form-select-sm">
                  <option value="Employee.EmployeeID" data-type="number">Employee Employee Id</option>
                  <option value="Employee.LastName">Employee Last Name</option>
                  <option value="Employee.FirstName">Employee First Name</option>
                  <option value="Employee.Email">Employee Email</option>
                  <option value="Employee.DateOfBirth" data-type="date">Employee Date Of Birth</option>
                  <option value="Employee.DepartmentID" data-type="number">Employee Department Id</option>
                  <option value="Employee.EmployeeTypeID" data-type="number">Employee Employee Type Id</option>
                  <option value="Employee.BranchID" data-type="number">Employee Branch Id</option>
                  <option value="Employee.Gender">Employee Gender</option>
                  <option value="Employee.Ethnicity">Employee Ethnicity</option>
                  <option value="Employee.HomePhone">Employee Home Phone</option>
                  <option value="Employee.MobilePhone">Employee Mobile Phone</option>
                  <option value="Employee.Address">Employee Address</option>
                  <option value="Employee.City">Employee City</option>
                  <option value="Employee.State_Province">Employee State Province</option>
                  <option value="Employee.Country_Region">Employee Country Region</option>
                  <option value="Employee.Avatar">Employee Avatar</option>
                  <option value="Employee.JobPositionID" data-type="number">Employee Job Position Id</option>
                </select>
              </div>
              <div className="form-group col-lg-2 me-2 mb-lg-0 mb-3">
                <select id="search_oper" className="form-select form-select-sm">
                  <option value="c">Contains</option>
                  <option value="e">Equals</option>
                  <option value="g">&gt;</option>
                  <option value="ge">&gt;&#x3D;</option>
                  <option value="l">&lt;</option>
                  <option value="le">&lt;&#x3D;</option>
                </select>
              </div>
              <div className="form-group col-lg-2 me-2 mb-lg-0 mb-3">
                <input id="search_word" autoComplete="off" onKeyUp={event=> Util.search(event)} className="form-control form-control-sm" />
              </div>
              <div className="col">
                <button className="btn btn-primary btn-sm" onClick={()=> Util.search()}>Search</button>
                <button className="btn btn-secondary btn-sm" onClick={()=> Util.clearSearch()}>Clear</button>
              </div>
            </div>
            <table className="table table-sm table-striped table-hover">
              <thead>
                <tr>
                  <th className={Util.getSortClass('Employee.EmployeeID','asc')}>
                    <Link to={Util.getLink(paging,'sort','Employee.EmployeeID','asc')}>Employee Id</Link>
                  </th>
                  <th className={Util.getSortClass('Employee.LastName')}>
                    <Link to={Util.getLink(paging,'sort','Employee.LastName')}>Last Name</Link>
                  </th>
                  <th className={Util.getSortClass('Employee.FirstName')}>
                    <Link to={Util.getLink(paging,'sort','Employee.FirstName')}>First Name</Link>
                  </th>
                  <th className={Util.getSortClass('Employee.Email') + ' d-none d-md-table-cell' }>
                    <Link to={Util.getLink(paging,'sort','Employee.Email')}>Email</Link>
                  </th>
                  <th className={Util.getSortClass('Employee.DateOfBirth') + ' d-none d-md-table-cell' }>
                    <Link to={Util.getLink(paging,'sort','Employee.DateOfBirth')}>Date Of Birth</Link>
                  </th>
                  <th className={Util.getSortClass('Employee.DepartmentID') + ' d-none d-md-table-cell' }>
                    <Link to={Util.getLink(paging,'sort','Employee.DepartmentID')}>Department Id</Link>
                  </th>
                  <th className={Util.getSortClass('Employee.EmployeeTypeID') + ' d-none d-md-table-cell' }>
                    <Link to={Util.getLink(paging,'sort','Employee.EmployeeTypeID')}>Employee Type Id</Link>
                  </th>
                  <th className={Util.getSortClass('Employee.BranchID') + ' d-none d-md-table-cell' }>
                    <Link to={Util.getLink(paging,'sort','Employee.BranchID')}>Branch Id</Link>
                  </th>
                  <th className={Util.getSortClass('Employee.Gender') + ' d-none d-md-table-cell' }>
                    <Link to={Util.getLink(paging,'sort','Employee.Gender')}>Gender</Link>
                  </th>
                  <th className={Util.getSortClass('Employee.Ethnicity') + ' d-none d-md-table-cell' }>
                    <Link to={Util.getLink(paging,'sort','Employee.Ethnicity')}>Ethnicity</Link>
                  </th>
                  <th className={Util.getSortClass('Employee.HomePhone') + ' d-none d-md-table-cell' }>
                    <Link to={Util.getLink(paging,'sort','Employee.HomePhone')}>Home Phone</Link>
                  </th>
                  <th className={Util.getSortClass('Employee.MobilePhone') + ' d-none d-md-table-cell' }>
                    <Link to={Util.getLink(paging,'sort','Employee.MobilePhone')}>Mobile Phone</Link>
                  </th>
                  <th className={Util.getSortClass('Employee.Address') + ' d-none d-md-table-cell' }>
                    <Link to={Util.getLink(paging,'sort','Employee.Address')}>Address</Link>
                  </th>
                  <th className={Util.getSortClass('Employee.City') + ' d-none d-md-table-cell' }>
                    <Link to={Util.getLink(paging,'sort','Employee.City')}>City</Link>
                  </th>
                  <th className={Util.getSortClass('Employee.State_Province') + ' d-none d-md-table-cell' }>
                    <Link to={Util.getLink(paging,'sort','Employee.State_Province')}>State Province</Link>
                  </th>
                  <th className={Util.getSortClass('Employee.Country_Region') + ' d-none d-md-table-cell' }>
                    <Link to={Util.getLink(paging,'sort','Employee.Country_Region')}>Country Region</Link>
                  </th>
                  <th className={Util.getSortClass('Employee.Avatar') + ' d-none d-md-table-cell' }>
                    <Link to={Util.getLink(paging,'sort','Employee.Avatar')}>Avatar</Link>
                  </th>
                  <th className={Util.getSortClass('Employee.JobPositionID') + ' d-none d-md-table-cell' }>
                    <Link to={Util.getLink(paging,'sort','Employee.JobPositionID')}>Job Position Id</Link>
                  </th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                {employees.map((employee, index) =>
                <tr key={index}>
                  <td className="text-center">{employee.EmployeeID}</td>
                  <td>{employee.LastName}</td>
                  <td>{employee.FirstName}</td>
                  <td className="d-none d-md-table-cell">{employee.Email}</td>
                  <td className="d-none d-md-table-cell text-center">{employee.DateOfBirth}</td>
                  <td className="d-none d-md-table-cell text-center">{employee.DepartmentID}</td>
                  <td className="d-none d-md-table-cell text-center">{employee.EmployeeTypeID}</td>
                  <td className="d-none d-md-table-cell text-center">{employee.BranchID}</td>
                  <td className="d-none d-md-table-cell">{employee.Gender}</td>
                  <td className="d-none d-md-table-cell">{employee.Ethnicity}</td>
                  <td className="d-none d-md-table-cell">{employee.HomePhone}</td>
                  <td className="d-none d-md-table-cell">{employee.MobilePhone}</td>
                  <td className="d-none d-md-table-cell">{employee.Address}</td>
                  <td className="d-none d-md-table-cell">{employee.City}</td>
                  <td className="d-none d-md-table-cell">{employee.State_Province}</td>
                  <td className="d-none d-md-table-cell">{employee.Country_Region}</td>
                  <td className="d-none d-md-table-cell">{employee.Avatar}</td>
                  <td className="d-none d-md-table-cell text-center">{employee.JobPositionID}</td>
                  <td className="text-center">
                    <Link className="btn btn-sm btn-secondary" to={`/employee/${employee.EmployeeID}/${employee.DepartmentID}/${employee.EmployeeTypeID}/${employee.BranchID}/${employee.JobPositionID}`} title="View"><i className="fa fa-eye"></i></Link>
                    <Link className="btn btn-sm btn-primary" to={`/employee/edit/${employee.EmployeeID}/${employee.DepartmentID}/${employee.EmployeeTypeID}/${employee.BranchID}/${employee.JobPositionID}`} title="Edit"><i className="fa fa-pencil"></i></Link>
                    <Link className="btn btn-sm btn-danger" to={`/employee/delete/${employee.EmployeeID}/${employee.DepartmentID}/${employee.EmployeeTypeID}/${employee.BranchID}/${employee.JobPositionID}`} title="Delete"><i className="fa fa-times"></i></Link>
                  </td>
                </tr>
                )}
              </tbody>
            </table>
            <div className="row mb-1">
              <div className="col-md-3 col-6">
                <label>Show
                  <select id="page_size" onChange={event=> props.history.push(event.target.value)} value={Util.getLink(paging,'size',paging.size)}>
                    <option value={Util.getLink(paging,'size',10)}>10</option>
                    <option value={Util.getLink(paging,'size',20)}>20</option>
                    <option value={Util.getLink(paging,'size',30)}>30</option>
                  </select>
                  entries
                </label>
              </div>
              <div className="col-md-9 col-6">
                <div className="float-right d-none d-md-block">
                  <ul className="pagination flex-wrap">
                    <li className={`page-item${paging.current <=1 ? ' disabled' : '' }`}>
                      <Link className="page-link" to={Util.getLink(paging,'page',paging.current-1)}>Prev</Link>
                    </li>
                    {Util.getPages(paging.last).map(page => 
                    <li key={page} className={`page-item${paging.current==page ? ' active' : '' }`}>
                      <Link className="page-link" to={Util.getLink(paging,'page',page)}>{page}</Link>
                    </li>
                    )}
                    <li className={`page-item${paging.current>= paging.last ? ' disabled' : ''}`}>
                      <Link className="page-link" to={Util.getLink(paging,'page',paging.current+1)}>Next</Link>
                    </li>
                  </ul>
                </div>
                <div className="float-right d-block d-md-none">
                  <label> Page
                    <select id="page_size" onChange={event=> props.history.push(event.target.value)} value={Util.getLink(paging,'page', paging.current)}>
                      {Util.getPages(paging.last).map(page => 
                      <option key={page} value={Util.getLink(paging,'page',page)}>{page}</option>
                      )}
                    </select>
                  </label> of <span>{paging.last}</span>
                  <div className="btn-group">
                    <Link className={` btn btn-primary btn-sm${paging.current <=1 ? ' disabled' : '' }`} to={Util.getLink(paging,'page',paging.current-1)}><i className="fa fa-chevron-left"></i></Link>
                    <Link className={` btn btn-primary btn-sm${paging.current>= paging.last ? ' disabled' : ''}`} to={Util.getLink(paging,'page',paging.current+1)}><i className="fa fa-chevron-right"></i></Link>
                  </div>
                </div>
              </div>
            </div>
            <Link className="btn btn-sm btn-primary" to="/employee/create">Create</Link>
          </div>
          <style dangerouslySetInnerHTML={{ __html: '#searchbar_toggle_menu { display: inline-flex!important }' }} />
        </div>
      </div>
    </div>
  )
}