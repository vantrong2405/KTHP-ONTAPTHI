const Sequelize = require('sequelize')
const { db } = require('../db')

module.exports = db.define('Employee', {
  EmployeeID: {
    type: Sequelize.INTEGER,
    primaryKey: true
  },
  LastName: Sequelize.STRING,
  FirstName: Sequelize.STRING,
  Email: Sequelize.STRING,
  DateOfBirth: Sequelize.DATEONLY,
  DepartmentID: {
    type: Sequelize.INTEGER,
    primaryKey: true
  },
  EmployeeTypeID: {
    type: Sequelize.INTEGER,
    primaryKey: true
  },
  BranchID: {
    type: Sequelize.INTEGER,
    primaryKey: true
  },
  Gender: Sequelize.STRING,
  Ethnicity: Sequelize.STRING,
  HomePhone: Sequelize.STRING,
  MobilePhone: Sequelize.STRING,
  Address: Sequelize.STRING,
  City: Sequelize.STRING,
  State_Province: Sequelize.STRING,
  Country_Region: Sequelize.STRING,
  Avatar: Sequelize.STRING,
  JobPositionID: {
    type: Sequelize.INTEGER,
    primaryKey: true
  },
})