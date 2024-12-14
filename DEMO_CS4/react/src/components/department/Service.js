import http from '../../http'

export default {
  get(departmentId) {
    if (departmentId) {
      return http.get(`/departments/${departmentId}`)
    }
    else {
      return http.get('/departments' + location.search)
    }
  },
  create(data) {
    if (data) {
      return http.post('/departments', data)
    }
    else {
      return http.get('/departments/create')
    }
  },
  edit(departmentId, data) {
    if (data) {
      return http.put(`/departments/${departmentId}`, data)
    }
    else {
      return http.get(`/departments/${departmentId}/edit`)
    }
  },
  delete(departmentId, data) {
    if (data) {
      return http.delete(`/departments/${departmentId}`)
    }
    else {
      return http.get(`/departments/${departmentId}/delete`)
    }
  }
}