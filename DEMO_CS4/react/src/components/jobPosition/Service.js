import http from '../../http'

export default {
  get(jobPositionId) {
    if (jobPositionId) {
      return http.get(`/jobPositions/${jobPositionId}`)
    }
    else {
      return http.get('/jobPositions' + location.search)
    }
  },
  create(data) {
    if (data) {
      return http.post('/jobPositions', data)
    }
    else {
      return http.get('/jobPositions/create')
    }
  },
  edit(jobPositionId, data) {
    if (data) {
      return http.put(`/jobPositions/${jobPositionId}`, data)
    }
    else {
      return http.get(`/jobPositions/${jobPositionId}/edit`)
    }
  },
  delete(jobPositionId, data) {
    if (data) {
      return http.delete(`/jobPositions/${jobPositionId}`)
    }
    else {
      return http.get(`/jobPositions/${jobPositionId}/delete`)
    }
  }
}