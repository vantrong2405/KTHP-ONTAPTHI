import http from '../../http'

export default {
  get(employeeTypeId) {
    if (employeeTypeId) {
      return http.get(`/employeeTypes/${employeeTypeId}`)
    }
    else {
      return http.get('/employeeTypes' + location.search)
    }
  },
  create(data) {
    if (data) {
      return http.post('/employeeTypes', data)
    }
    else {
      return http.get('/employeeTypes/create')
    }
  },
  edit(employeeTypeId, data) {
    if (data) {
      return http.put(`/employeeTypes/${employeeTypeId}`, data)
    }
    else {
      return http.get(`/employeeTypes/${employeeTypeId}/edit`)
    }
  },
  delete(employeeTypeId, data) {
    if (data) {
      return http.delete(`/employeeTypes/${employeeTypeId}`)
    }
    else {
      return http.get(`/employeeTypes/${employeeTypeId}/delete`)
    }
  }
}