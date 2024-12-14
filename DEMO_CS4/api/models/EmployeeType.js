const Sequelize = require('sequelize')
const { db } = require('../db')

module.exports = db.define('EmployeeType', {
  EmployeeTypeID: {
    type: Sequelize.INTEGER,
    primaryKey: true
  },
  EmployeeTypeName: Sequelize.STRING,
})