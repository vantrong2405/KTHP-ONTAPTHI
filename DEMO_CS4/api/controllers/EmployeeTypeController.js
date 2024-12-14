const { knex, db } = require('../db')
const util = require('../util')
const EmployeeType = require('../models/EmployeeType')

exports.index = (req, res, next) => {
  let page = req.query.page || 1
  let size = req.query.size || 10
  let sort = req.query.sort || 'EmployeeType.EmployeeTypeID'
  let sortDirection = req.query.sort ? (req.query.desc ? 'desc' : 'asc') : 'asc'
  let column = req.query.sc
  let query = knex('EmployeeType')
    .select('EmployeeType.EmployeeTypeID', 'EmployeeType.EmployeeTypeName')
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
  ]).then(([count, employeeTypes]) => {
    let last = Math.ceil(count.count / size)
    res.send({ employeeTypes, last })
  }).catch(next)
}

exports.getCreate = (req, res, next) => {
  res.end()
}

exports.create = (req, res, next) => {
  let employeeType = util.parseData(EmployeeType, { ...req.body })
  EmployeeType.create(employeeType).then(() => {
    res.end()
  }).catch(next)
}

exports.get = (req, res, next) => {
  let sqlEmployeeType = knex('EmployeeType')
    .select('EmployeeType.EmployeeTypeID', 'EmployeeType.EmployeeTypeName')
    .where('EmployeeType.EmployeeTypeID', req.params.employeeTypeId)
    .toString()
  db.query(sqlEmployeeType, { type: 'SELECT', plain: true }).then(employeeType => {
    res.send({ employeeType })
  }).catch(next)
}

exports.edit = (req, res, next) => {
  let sqlEmployeeType = knex('EmployeeType')
    .select('EmployeeType.EmployeeTypeID', 'EmployeeType.EmployeeTypeName')
    .where('EmployeeType.EmployeeTypeID', req.params.employeeTypeId)
    .toString()
  db.query(sqlEmployeeType, { type: 'SELECT', plain: true }).then(employeeType => {
    res.send({ employeeType })
  }).catch(next)
}

exports.update = (req, res, next) => {
  let employeeType = util.parseData(EmployeeType, { ...req.body })
  EmployeeType.update(employeeType, { where: { EmployeeTypeID: req.params.employeeTypeId }}).then(() => {
    res.end()
  }).catch(next)
}

exports.getDelete = (req, res, next) => {
  let sqlEmployeeType = knex('EmployeeType')
    .select('EmployeeType.EmployeeTypeID', 'EmployeeType.EmployeeTypeName')
    .where('EmployeeType.EmployeeTypeID', req.params.employeeTypeId)
    .toString()
  db.query(sqlEmployeeType, { type: 'SELECT', plain: true }).then(employeeType => {
    res.send({ employeeType })
  }).catch(next)
}

exports.delete = (req, res, next) => {
  EmployeeType.destroy({ where: { EmployeeTypeID: req.params.employeeTypeId }}).then(() => {
    res.end()
  }).catch(next)
}
