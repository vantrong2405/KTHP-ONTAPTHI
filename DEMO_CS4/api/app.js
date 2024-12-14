const express = require('express');
const cors = require('cors');
const authen = require('./middleware/authenticate');
const router = require('./router.js');
const util = require('./util');
const { db } = require('./db.js');

const app = express();
app.use(cors(), express.json());
app.use('/uploads', express.static('uploads'));
app.use('/api', authen, router);
app.use((err, req, res, next) => {
  res.status(500).send(util.getError(err));
});
app.listen(8000, () => {
  console.log('Server is listening on port 8000');
});

// Kiểm tra kết nối DB
async function checkDbConnection() {
  try {
    // Thực hiện một truy vấn SQL đơn giản
    await db.query('SELECT 1+1 AS result');
    console.log('Database connection successful');
  } catch (error) {
    console.error('Database connection failed:', error.message);
  }
}

checkDbConnection();
