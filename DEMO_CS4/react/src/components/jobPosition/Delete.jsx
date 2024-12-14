import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import Service from './Service'
import Util from '../../util'

export default function JobPositionDelete(props) {
  
  const [ jobPosition, setJobPosition ] = useState({})
  
  useEffect(() => {
    get().finally(() => {
      Util.initView(true)
    })
  }, [ props.match.params.jobPositionId ])
  
  function get() {
    return Service.delete(props.match.params.jobPositionId).then(response => {
      setJobPosition(response.data.jobPosition)
    }).catch(e => {
      alert(e.response.data.message)
    })
  }

  function remove(e) {
    e.preventDefault()
    Service.delete(props.match.params.jobPositionId, jobPosition).then(() => {
      props.history.push(Util.getRef('/jobPosition'))
    }).catch((e) => {
      alert(e.response.data.message)
    })
  }

  return (
    <div className="container">
      <div className="row">
        <div className="col">
          <form method="post" onSubmit={remove}>
            <div className="row">
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="job_position_job_position_id">Job Position Id</label>
                <input readOnly id="job_position_job_position_id" name="JobPositionID" className="form-control form-control-sm" value={jobPosition.JobPositionID ?? '' } type="number" required />
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="job_position_job_position_name">Job Position Name</label>
                <input readOnly id="job_position_job_position_name" name="JobPositionName" className="form-control form-control-sm" value={jobPosition.JobPositionName ?? '' } maxLength="50" />
              </div>
              <div className="col-12">
                <Link className="btn btn-sm btn-secondary" to={Util.getRef('/jobPosition')}>Cancel</Link>
                <button className="btn btn-sm btn-danger">Delete</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  )
}