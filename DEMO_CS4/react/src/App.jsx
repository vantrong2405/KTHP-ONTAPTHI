import  { useState, useEffect } from 'react'
import { Router, Link } from 'react-router-dom'
import history from './history'
import http from './http'
import Route  from './router'
import './assets/style.css'

export default function App() {
  const [ isReady, setIsReady ] = useState(false)
  const [ user, setUser ] = useState(null)
  const [ path, setPath ] = useState(location.pathname)
  
  useEffect(() => {
    let unlisten = history.listen((location) => {
      setPath(location.pathname)
      history.prev = history.current
      history.current = location.pathname + location.search
    })
    http.get('/user').then(response => {
      setUser(response.data)
      setIsReady(true)
    }).catch(() => {
      setIsReady(true)
    })
    return () => {
      unlisten()
    }
  }, [])
  
  if (!isReady) {
    return null
  }
  return (
    <Router history={history}>
      { user ?
      <div className="wrapper">
        <input id="sidebar_toggle" type="checkbox" />
        <nav id="sidebar">
          <Link to="/" className="bg-light border-bottom">
          <h4>CASE_STUDY_4</h4>
          </Link>
          <ul className="list-unstyled">
            <li>
              <Link to="/home" className={path.endsWith('/home') ? 'active bg-primary' : '' }>Home</Link>
            </li>
            {user && user.menu.map((menu, index) =>
            <li key={index}>
              <Link to={`/${menu.path}`} className={path.substr(1).split('/')[0]==menu.path ? 'active bg-primary' : '' }>{menu.title}</Link>
            </li>
            )}
          </ul>
        </nav>
        <div id="body">
          <nav className="navbar bg-light border-bottom">
            <div className="container-fluid">
              <label htmlFor="sidebar_toggle" className=" btn btn-primary btn-sm"><i className="fa fa-bars"></i></label>
              <ul className="navbar-nav ms-auto">
                <li id="searchbar_toggle_menu" className="d-none">
                  <a className="nav-link text-secondary" href="#"><label htmlFor="searchbar_toggle" className="d-lg-none"><i className="fa fa-search"></i></label></a>
                </li>
                <li className="nav-item dropdown">
              <a
                className="nav-link text-secondary dropdown-toggle"
                href="#"
                id="userDropdown"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                <i className="fa fa-user"></i>
                <span className="d-none d-lg-inline">
                  {user && user.name ? user.name : ""}
                </span>
              </a>
              <ul
                className="dropdown-menu dropdown-menu-end"
                aria-labelledby="userDropdown"
              >
                <li>
                  <Link to="/profile" className="dropdown-item">
                    <i className="fa fa-user"></i> Profile
                  </Link>
                </li>
                <li>
                  <Link to="/logout" className="dropdown-item">
                    <i className="fa fa-sign-out"></i> Logout
                  </Link>
                </li>
              </ul>
            </li>
              </ul>
            </div>
          </nav>
          <div className="content">
            <Route user={user} setUser={setUser} />
          </div>
        </div>








      </div>
      :
      <Route user={user} setUser={setUser} />
      }
    </Router>
  )
}