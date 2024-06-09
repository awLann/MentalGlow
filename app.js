const express = require('express');
const passport = require('passport');
const session = require('express-session');
const authRoutes = require('./routes/auth.route');
const profileRoutes = require('./routes/profile.route');
require('dotenv').config();
require('./config'); // Load the Passport configuration

const app = express();

app.use(session({
    secret: process.env.SESSION_SECRET,
    resave: false,
    saveUninitialized: true
  }));
app.use(passport.initialize());
app.use(passport.session());

app.use('/auth', authRoutes);
app.use('/profile', profileRoutes);

app.get('/', (req, res) => {
    res.send('Home Page');
});

const PORT = process.env.PORT || 8080;
app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
});