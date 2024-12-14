const { knex, db } = require('../db')
const util = require('../util')
const Department = require('../models/Department')

exports.index = (req, res, next) => {
  let page = req.query.page || 1
  let size = req.query.size || 10
  let sort = req.query.sort || 'Department.DepartmentID'
  let sortDirection = req.query.sort ? (req.query.desc ? 'desc' : 'asc') : 'asc'
  let column = req.query.sc
  let query = knex('Department')
    .select('Department.DepartmentID', 'Department.DepartmentName')
    .orderBy(sort, sortDirection)
  let columns = query._statements.find(e => e.grouping == 'columns').value
  if (util.isInvalidSearch(columns, column)) {
    return res.sendStatus(403)
  }
  if (req.query.sw) {
    let search = req.query.sw
    let operator = util.getOperator(req.query.so)
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
  ]).then(([count, departments]) => {
    let last = Math.ceil(count.count / size)
    res.send({ departments, last })
  }).catch(next)
}

exports.getCreate = (req, res, next) => {
  res.end()
}

exports.create = (req, res, next) => {
  let department = util.parseData(Department, { ...req.body })
  Department.create(department).then(() => {
    res.end()
  }).catch(next)
}

exports.get = (req, res, next) => {
  let sqlDepartment = knex('Department')
    .select('Department.DepartmentID', 'Department.DepartmentName')
    .where('Department.DepartmentID', req.params.departmentId)
    .toString()
  db.query(sqlDepartment, { type: 'SELECT', plain: true }).then(department => {
    res.send({ department })
  }).catch(next)
}

exports.edit = (req, res, next) => {
  let sqlDepartment = knex('Department')
    .select('Department.DepartmentID', 'Department.DepartmentName')
    .where('Department.DepartmentID', req.params.departmentId)
    .toString()
  db.query(sqlDepartment, { type: 'SELECT', plain: true }).then(department => {
    res.send({ department })
  }).catch(next)
}

exports.update = (req, res, next) => {
  let department = util.parseData(Department, { ...req.body })
  Department.update(department, { where: { DepartmentID: req.params.departmentId }}).then(() => {
    res.end()
  }).catch(next)
}

exports.getDelete = (req, res, next) => {
  let sqlDepartment = knex('Department')
    .select('Department.DepartmentID', 'Department.DepartmentName')
    .where('Department.DepartmentID', req.params.departmentId)
    .toString()
  db.query(sqlDepartment, { type: 'SELECT', plain: true }).then(department => {
    res.send({ department })
  }).catch(next)
}

exports.delete = (req, res, next) => {
  Department.destroy({ where: { DepartmentID: req.params.departmentId }}).then(() => {
    res.end()
  }).catch(next)
}
