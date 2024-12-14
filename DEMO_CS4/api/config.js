module.exports = {
  app: {
    url: 'http://localhost:5173',
    name: 'CASE_STUDY_4',
  },
  smtp: {
    host: 'smtp.mailgun.com',
    port: '587',
    user: '',
    password: '',
  },
  mail: {
    sender: 'admin@example.com',
    welcome:
      'Welcome to {app_name},\n\nYour user has been created. The login information:\nLogin URL: {app_url}/#/login\nUser Name: {user}\n\nPlease click the link below to set your password.\n{app_url}/#/changePassword/{token}\n\nBest Regards,\nAdministrator',
    reset:
      'Dear User,\n\nYou recently requested to reset the password for your {app_name} account. Please click the link below to proceed.\n{app_url}/#/changePassword/{token}\n\nBest Regards,\nAdministrator',
  },
  db: {
    host: '127.0.0.1', // Địa chỉ máy chủ cơ sở dữ liệu
    port: 3306, // Cổng MySQL (mặc định)
    user: 'root', // Tên người dùng MySQL
    password: 'Admin123@', // Mật khẩu MySQL
    database: 'casestudy4_db', // Tên cơ sở dữ liệu của bạn
    dialect: 'mysql', // Chỉ định sử dụng MySQL
  },
  menu: [
    {
      title: 'Department',
      path: 'department',
      roles: 'ADMIN,USER',
      show: true,
    },
    { title: 'Employee', path: 'employee', roles: 'ADMIN,USER', show: true },
    {
      title: 'Employee Type',
      path: 'employeeType',
      roles: 'ADMIN,USER',
      show: true,
    },
    {
      title: 'Job Position',
      path: 'jobPosition',
      roles: 'ADMIN,USER',
      show: true,
    },
    { title: 'User Account', path: 'userAccount', roles: 'ADMIN', show: true },
  ],
  jwtSecret: 'b0WciedNJvFCqFRbB2A1QhZoCDnutAOen5g1FEDO0HsLTwGINp04GXh2OXVpTqQL',
};
