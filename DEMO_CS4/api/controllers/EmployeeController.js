const { knex, db } = require('../db')
const util = require('../util')
const Employee = require('../models/Employee')

exports.index = (req, res, next) => {
  let page = req.query.page || 1
  let size = req.query.size || 10
  let sort = req.query.sort || 'Employee.EmployeeID'
  let sortDirection = req.query.sort ? (req.query.desc ? 'desc' : 'asc') : 'asc'
  let column = req.query.sc
  let query = knex('Employee')
    .select('Employee.EmployeeID', 'Employee.LastName', 'Employee.FirstName', 'Employee.Email', 'Employee.DateOfBirth', 'Employee.DepartmentID', 'Employee.EmployeeTypeID', 'Employee.BranchID', 'Employee.Gender', 'Employee.Ethnicity', 'Employee.HomePhone', 'Employee.MobilePhone', 'Employee.Address', 'Employee.City', 'Employee.State_Province', 'Employee.Country_Region', 'Employee.Avatar', 'Employee.JobPositionID')
    .orderBy(sort, sortDirection)
  let columns = query._statements.find(e => e.grouping == 'columns').value
  if (util.isInvalidSearch(columns, column)) {
    return res.sendStatus(403)
  }
  if (req.query.sw) {
    let search = req.query.sw
    let operator = util.getOperator(req.query.so)
    if (column == 'Employee.DateOfBirth') {
      search = util.formatDateStr(search)
    }
    if (operator == 'like') {
      search = `%${search}%`
    }
    query.where(column, operator, search)
  }
  let sqlCount = query.clone().clearSelect().clearOrder().count('* as "count"').toString()
  let sqlQuery = query.offset((page - 1) * size).limit(size).toString()
  Promise.all([
    db.query(sqlCount, { type: 'SELECT', plain: true }),
    db.query(sqlQuery, { type: 'SELECT' })
  ]).then(([count, employees]) => {
    let last = Math.ceil(count.count / size)
    res.send({ employees, last })
  }).catch(next)
}

exports.getCreate = (req, res, next) => {
  res.end()
}

exports.create = (req, res, next) => {
  let employee = util.parseData(Employee, { ...req.body })
  Employee.create(employee).then(() => {
    res.end()
  }).catch(next)
}

exports.get = (req, res, next) => {
  let sqlEmployee = knex('Employee')
    .select('Employee.EmployeeID', 'Employee.LastName', 'Employee.FirstName', 'Employee.Email', 'Employee.DateOfBirth', 'Employee.DepartmentID', 'Employee.EmployeeTypeID', 'Employee.BranchID', 'Employee.Gender', 'Employee.Ethnicity', 'Employee.HomePhone', 'Employee.MobilePhone', 'Employee.Address', 'Employee.City', 'Employee.State_Province', 'Employee.Country_Region', 'Employee.Avatar', 'Employee.JobPositionID')
    .where('Employee.EmployeeID', req.params.employeeId)
    .where('Employee.DepartmentID', req.params.departmentId)
    .where('Employee.EmployeeTypeID', req.params.employeeTypeId)
    .where('Employee.BranchID', req.params.branchId)
    .where('Employee.JobPositionID', req.params.jobPositionId)
    .toString()
  db.query(sqlEmployee, { type: 'SELECT', plain: true }).then(employee => {
    res.send({ employee })
  }).catch(next)
}

exports.edit = (req, res, next) => {
  let sqlEmployee = knex('Employee')
    .select('Employee.EmployeeID', 'Employee.LastName', 'Employee.FirstName', 'Employee.Email', 'Employee.DateOfBirth', 'Employee.DepartmentID', 'Employee.EmployeeTypeID', 'Employee.BranchID', 'Employee.Gender', 'Employee.Ethnicity', 'Employee.HomePhone', 'Employee.MobilePhone', 'Employee.Address', 'Employee.City', 'Employee.State_Province', 'Employee.Country_Region', 'Employee.Avatar', 'Employee.JobPositionID')
    .where('Employee.EmployeeID', req.params.employeeId)
    .where('Employee.DepartmentID', req.params.departmentId)
    .where('Employee.EmployeeTypeID', req.params.employeeTypeId)
    .where('Employee.BranchID', req.params.branchId)
    .where('Employee.JobPositionID', req.params.jobPositionId)
    .toString()
  db.query(sqlEmployee, { type: 'SELECT', plain: true }).then(employee => {
    res.send({ employee })
  }).catch(next)
}

exports.update = (req, res, next) => {
  let employee = util.parseData(Employee, { ...req.body })
  Employee.update(employee, { where: { EmployeeID: req.params.employeeId, DepartmentID: req.params.departmentId, EmployeeTypeID: req.params.employeeTypeId, BranchID: req.params.branchId, JobPositionID: req.params.jobPositionId }}).then(() => {
    res.end()
  }).catch(next)
}

exports.getDelete = (req, res, next) => {
  let sqlEmployee = knex('Employee')
    .select('Employee.EmployeeID', 'Employee.LastName', 'Employee.FirstName', 'Employee.Email', 'Employee.DateOfBirth', 'Employee.DepartmentID', 'Employee.EmployeeTypeID', 'Employee.BranchID', 'Employee.Gender', 'Employee.Ethnicity', 'Employee.HomePhone', 'Employee.MobilePhone', 'Employee.Address', 'Employee.City', 'Employee.State_Province', 'Employee.Country_Region', 'Employee.Avatar', 'Employee.JobPositionID')
    .where('Employee.EmployeeID', req.params.employeeId)
    .where('Employee.DepartmentID', req.params.departmentId)
    .where('Employee.EmployeeTypeID', req.params.employeeTypeId)
    .where('Employee.BranchID', req.params.branchId)
    .where('Employee.JobPositionID', req.params.jobPositionId)
    .toString()
  db.query(sqlEmployee, { type: 'SELECT', plain: true }).then(employee => {
    res.send({ employee })
  }).catch(next)
}

exports.delete = (req, res, next) => {
  Employee.destroy({ where: { EmployeeID: req.params.employeeId, DepartmentID: req.params.departmentId, EmployeeTypeID: req.params.employeeTypeId, BranchID: req.params.branchId, JobPositionID: req.params.jobPositionId }}).then(() => {
    res.end()
  }).catch(next)
}
