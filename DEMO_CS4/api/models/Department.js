const Sequelize = require('sequelize')
const { db } = require('../db')

module.exports = db.define('Department', {
  DepartmentID: {
    type: Sequelize.INTEGER,
    primaryKey: true
  },
  DepartmentName: Sequelize.STRING,
})