import  { Suspense, lazy } from 'react'
import { Switch, Route } from 'react-router-dom'
import Login from './components/authen/Login'
import Logout from './components/authen/Logout'
import ResetPassword from './components/authen/ResetPassword'
import ChangePassword from './components/authen/ChangePassword'
import Profile from './components/Profile'
import Default from './components/Default'
import Home from './components/Home'
import NotFound from './components/NotFound'

export default function AppRoute(props) {
  console.log("🚀 ~ AppRoute ~ props:", props)
  
  return (
    <Suspense fallback={''}>
      <Switch>
        <Route path="/login" component={(p) => <Login {...p} user={props.user} setUser={props.setUser} />} />
        <Route path="/logout" component={(p) => <Logout {...p} setUser={props.setUser} />} />
        <Route path="/resetPassword" component={ResetPassword} />
        <Route path="/changePassword/:token" component={ChangePassword} />
        <Route path="/" component={Default} exact />
        <Route path="/home" component={Home} />
        <Route path="/profile" component={Profile} />
        <Route path="/userAccount" component={lazy(() => import('./components/userAccount/Index'))} exact />
        <Route path="/userAccount/create" component={lazy(() => import('./components/userAccount/Create'))} exact />
        <Route path="/userAccount/:id/" component={lazy(() => import('./components/userAccount/Detail'))} exact />
        <Route path="/userAccount/edit/:id/" component={lazy(() => import('./components/userAccount/Edit'))} exact />
        <Route path="/userAccount/delete/:id/" component={lazy(() => import('./components/userAccount/Delete'))} exact />
        <Route path="/jobPosition" component={lazy(() => import('./components/jobPosition/Index'))} exact />
        <Route path="/jobPosition/create" component={lazy(() => import('./components/jobPosition/Create'))} exact />
        <Route path="/jobPosition/:jobPositionId/" component={lazy(() => import('./components/jobPosition/Detail'))} exact />
        <Route path="/jobPosition/edit/:jobPositionId/" component={lazy(() => import('./components/jobPosition/Edit'))} exact />
        <Route path="/jobPosition/delete/:jobPositionId/" component={lazy(() => import('./components/jobPosition/Delete'))} exact />
        <Route path="/department" component={lazy(() => import('./components/department/Index'))} exact />
        <Route path="/department/create" component={lazy(() => import('./components/department/Create'))} exact />
        <Route path="/department/:departmentId/" component={lazy(() => import('./components/department/Detail'))} exact />
        <Route path="/department/edit/:departmentId/" component={lazy(() => import('./components/department/Edit'))} exact />
        <Route path="/department/delete/:departmentId/" component={lazy(() => import('./components/department/Delete'))} exact />
        <Route path="/employeeType" component={lazy(() => import('./components/employeeType/Index'))} exact />
        <Route path="/employeeType/create" component={lazy(() => import('./components/employeeType/Create'))} exact />
        <Route path="/employeeType/:employeeTypeId/" component={lazy(() => import('./components/employeeType/Detail'))} exact />
        <Route path="/employeeType/edit/:employeeTypeId/" component={lazy(() => import('./components/employeeType/Edit'))} exact />
        <Route path="/employeeType/delete/:employeeTypeId/" component={lazy(() => import('./components/employeeType/Delete'))} exact />
        <Route path="/employee" component={lazy(() => import('./components/employee/Index'))} exact />
        <Route path="/employee/create" component={lazy(() => import('./components/employee/Create'))} exact />
        <Route path="/employee/:employeeId/:departmentId/:employeeTypeId/:branchId/:jobPositionId/" component={lazy(() => import('./components/employee/Detail'))} exact />
        <Route path="/employee/edit/:employeeId/:departmentId/:employeeTypeId/:branchId/:jobPositionId/" component={lazy(() => import('./components/employee/Edit'))} exact />
        <Route path="/employee/delete/:employeeId/:departmentId/:employeeTypeId/:branchId/:jobPositionId/" component={lazy(() => import('./components/employee/Delete'))} exact />
        <Route path="*" component={NotFound} />
      </Switch>
    </Suspense>
  )
}