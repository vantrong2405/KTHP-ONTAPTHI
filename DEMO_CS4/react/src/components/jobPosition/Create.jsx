import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import Service from './Service'
import Util from '../../util'

export default function JobPositionCreate(props) {
  
  const [ jobPosition, setJobPosition ] = useState({})
  const [ errors, setErrors ] = useState({})
  
  useEffect(() => {
    Util.initView(true)
  }, [])

  function create(e) {
    e.preventDefault()
    Service.create(jobPosition).then(() => {
      props.history.push(Util.getRef('/jobPosition'))
    }).catch((e) => {
      if (e.response.data.errors) {
        setErrors(e.response.data.errors)
      }
      else {
        alert(e.response.data.message)
      }
    })
  }

  function onChange(e) {
    let data = { ...jobPosition }
    data[e.target.name] = e.target.value
    setJobPosition(data)
  }

  return (
    <div className="container">
      <div className="row">
        <div className="col">
          <form method="post" onSubmit={create}>
            <div className="row">
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="job_position_job_position_id">Job Position Id</label>
                <input id="job_position_job_position_id" name="JobPositionID" className="form-control form-control-sm" onChange={onChange} value={jobPosition.JobPositionID ?? '' } type="number" required />
                {errors.JobPositionID && <span className="text-danger">{errors.JobPositionID}</span>}
              </div>
              <div className="mb-3 col-md-6 col-lg-4">
                <label className="form-label" htmlFor="job_position_job_position_name">Job Position Name</label>
                <input id="job_position_job_position_name" name="JobPositionName" className="form-control form-control-sm" onChange={onChange} value={jobPosition.JobPositionName ?? '' } maxLength="50" />
                {errors.JobPositionName && <span className="text-danger">{errors.JobPositionName}</span>}
              </div>
              <div className="col-12">
                <Link className="btn btn-sm btn-secondary" to={Util.getRef('/jobPosition')}>Cancel</Link>
                <button className="btn btn-sm btn-primary">Submit</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  )
}