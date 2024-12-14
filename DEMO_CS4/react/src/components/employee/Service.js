import http from '../../http'

export default {
  get(employeeId, departmentId, employeeTypeId, branchId, jobPositionId) {
    if (employeeId) {
      return http.get(`/employees/${employeeId}/${departmentId}/${employeeTypeId}/${branchId}/${jobPositionId}`)
    }
    else {
      return http.get('/employees' + location.search)
    }
  },
  create(data) {
    if (data) {
      return http.post('/employees', data)
    }
    else {
      return http.get('/employees/create')
    }
  },
  edit(employeeId, departmentId, employeeTypeId, branchId, jobPositionId, data) {
    if (data) {
      return http.put(`/employees/${employeeId}/${departmentId}/${employeeTypeId}/${branchId}/${jobPositionId}`, data)
    }
    else {
      return http.get(`/employees/${employeeId}/${departmentId}/${employeeTypeId}/${branchId}/${jobPositionId}/edit`)
    }
  },
  delete(employeeId, departmentId, employeeTypeId, branchId, jobPositionId, data) {
    if (data) {
      return http.delete(`/employees/${employeeId}/${departmentId}/${employeeTypeId}/${branchId}/${jobPositionId}`)
    }
    else {
      return http.get(`/employees/${employeeId}/${departmentId}/${employeeTypeId}/${branchId}/${jobPositionId}/delete`)
    }
  }
}