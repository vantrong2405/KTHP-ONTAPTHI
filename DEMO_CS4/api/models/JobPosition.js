const Sequelize = require('sequelize')
const { db } = require('../db')

module.exports = db.define('JobPosition', {
  JobPositionID: {
    type: Sequelize.INTEGER,
    primaryKey: true
  },
  JobPositionName: Sequelize.STRING,
})