const { knex, db } = require('../db')
const util = require('../util')
const JobPosition = require('../models/JobPosition')

exports.index = (req, res, next) => {
  let page = req.query.page || 1
  let size = req.query.size || 10
  let sort = req.query.sort || 'JobPosition.JobPositionID'
  let sortDirection = req.query.sort ? (req.query.desc ? 'desc' : 'asc') : 'asc'
  let column = req.query.sc
  let query = knex('JobPosition')
    .select('JobPosition.JobPositionID', 'JobPosition.JobPositionName')
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
  ]).then(([count, jobPositions]) => {
    let last = Math.ceil(count.count / size)
    res.send({ jobPositions, last })
  }).catch(next)
}

exports.getCreate = (req, res, next) => {
  res.end()
}

exports.create = (req, res, next) => {
  let jobPosition = util.parseData(JobPosition, { ...req.body })
  JobPosition.create(jobPosition).then(() => {
    res.end()
  }).catch(next)
}

exports.get = (req, res, next) => {
  let sqlJobPosition = knex('JobPosition')
    .select('JobPosition.JobPositionID', 'JobPosition.JobPositionName')
    .where('JobPosition.JobPositionID', req.params.jobPositionId)
    .toString()
  db.query(sqlJobPosition, { type: 'SELECT', plain: true }).then(jobPosition => {
    res.send({ jobPosition })
  }).catch(next)
}

exports.edit = (req, res, next) => {
  let sqlJobPosition = knex('JobPosition')
    .select('JobPosition.JobPositionID', 'JobPosition.JobPositionName')
    .where('JobPosition.JobPositionID', req.params.jobPositionId)
    .toString()
  db.query(sqlJobPosition, { type: 'SELECT', plain: true }).then(jobPosition => {
    res.send({ jobPosition })
  }).catch(next)
}

exports.update = (req, res, next) => {
  let jobPosition = util.parseData(JobPosition, { ...req.body })
  JobPosition.update(jobPosition, { where: { JobPositionID: req.params.jobPositionId }}).then(() => {
    res.end()
  }).catch(next)
}

exports.getDelete = (req, res, next) => {
  let sqlJobPosition = knex('JobPosition')
    .select('JobPosition.JobPositionID', 'JobPosition.JobPositionName')
    .where('JobPosition.JobPositionID', req.params.jobPositionId)
    .toString()
  db.query(sqlJobPosition, { type: 'SELECT', plain: true }).then(jobPosition => {
    res.send({ jobPosition })
  }).catch(next)
}

exports.delete = (req, res, next) => {
  JobPosition.destroy({ where: { JobPositionID: req.params.jobPositionId }}).then(() => {
    res.end()
  }).catch(next)
}
