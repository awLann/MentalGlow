const express = require('express');
const passport = require('passport');
const session = require('express-session');
const authRoutes = require('./routes/auth.route');
const profileRoutes = require('./routes/profile.route');
const faceDetectionRoutes = require('./routes/faceDetection.route');
const { loadModel } = require('./models/faceDetectionModel');
const path = require('path');

require('dotenv').config();

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
app.use('/face-detection', faceDetectionRoutes);

app.get('/', (req, res) => {
    res.send('Home Page');
});

// Load the model when the server starts
loadModel(path.join(__dirname, 'path_to_your_model/model.json'));

const PORT = process.env.PORT || 8080;
app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
});
