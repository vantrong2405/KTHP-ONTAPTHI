import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import Service from './Service'
import Util from '../../util'

export default function JobPositionDetail(props) {
  
  const [ jobPosition, setJobPosition ] = useState({})
  
  useEffect(() => {
    get().finally(() => {
      Util.initView(true)
    })
  }, [ props.match.params.jobPositionId ])
  
  function get() {
    return Service.get(props.match.params.jobPositionId).then(response => {
      setJobPosition(response.data.jobPosition)
    }).catch(e => {
      alert(e.response.data.message)
    })
  }

  return (
    <div className="container">
      <div className="row">
        <div className="col">
          <form method="post">
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
                <Link className="btn btn-sm btn-secondary" to={Util.getRef('/jobPosition')}>Back</Link>
                <Link className="btn btn-sm btn-primary" to={`/jobPosition/edit/${jobPosition.JobPositionID}?ref=${encodeURIComponent(Util.getRef('/jobPosition'))}`}>Edit</Link>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  )
}