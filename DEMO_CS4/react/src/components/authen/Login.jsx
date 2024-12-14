import  { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import http from '../../http'
import 'font-awesome/css/font-awesome.min.css';
export default function Login(props) {
  const [ user, setUser ] = useState({})
  const [ error, setError ] = useState(null)
  let { user: loginUser, history } = props



  useEffect(() => {
    console.log("🚀 ~ Login ~ loginUser", loginUser);
    console.log("🚀 ~ Login ~ history", history);
  }, [ loginUser, history ])

  useEffect(() => {
    if (loginUser) {
      history.push(history.redirect || '/home')
    }
  }, [ loginUser, history ])
  function onChange(e) {
    let data = { ...user }
    data[e.target.name.toLowerCase()] = e.target.value
    setUser(data)
  }
  function login(e) {
    e.preventDefault()
    http.post('/login', user).then(response => {
      console.log("response.data.user:",response.data.user)
      props.setUser(response.data.user)
      localStorage.setItem('express_token', response.data.token)
    }).catch((e) => {
      setError(e.response.data)
    })
  }

  return (
    <div className="container">
      <div className="row">
        <div className="col">
          <div className="center-container">
            <div className="d-flex justify-content-center">
              <div className="card card-width p-0">
                <div className="card-header">
                  <h3>Login</h3>
                </div>
                <div className="card-body">
                  <i className="login fa fa-user-circle"></i>
                  <form method="post" onSubmit={login}>
                    <div className="row">
                      <div className="mb-3 col-12">
                        <label className="form-label" htmlFor="user_account_name">User Name</label>
                        <input id="user_account_name" name="name" className="form-control form-control-sm" onChange={onChange} value={user.name ?? '' } required maxLength="50" />
                      </div>
                      <div className="mb-3 col-12">
                        <label className="form-label" htmlFor="user_account_password">Password</label>
                        <input id="user_account_password" name="password" className="form-control form-control-sm" onChange={onChange} value={user.password ?? '' } type="password" required maxLength="100" />
                      </div>
                      <div className="col-12">
                        <button className="btn btn-sm btn-secondary w-100" type='submit'>Login</button>
                        <Link to="/resetPassword">Forgot Password?</Link>
                      </div>
                    </div>
                  </form>
                  { error && <span className="text-danger">{ error.message }</span> }
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}