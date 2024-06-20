const express = require('express');
const passport = require('passport');
const session = require('express-session');
const authRoutes = require('./routes/auth.route');
const profileRoutes = require('./routes/profile.route');
const faceDetectionRoutes = require('./routes/faceDetection.route');
const textDetectionRoutes = require('./routes/textDetection.route'); // Corrected route name
const { loadModelFace } = require('./models/faceDetectionModel'); // Assuming face detection model
const { loadModelText } = require('./models/textDetectionModel'); // Assuming face detection model
const path = require('path');
require('dotenv').config();

const app = express();

// Middleware
app.use(express.json()); // Parse JSON bodies
app.use(session({
    secret: process.env.SESSION_SECRET,
    resave: false,
    saveUninitialized: true
}));
app.use(passport.initialize());
app.use(passport.session());

// Routes
app.use('/auth', authRoutes);
app.use('/profile', profileRoutes);
app.use('/face-detection', faceDetectionRoutes);
app.use('/text-analysis', textDetectionRoutes); // Ensure correct route name

// Home route
app.get('/', (req, res) => {
    res.send('Home Page');
});

// Load the model when the server starts
loadModelFace(path.join(__dirname, 'models/faceDetection/model.json')); // Adjust path as per your folder structure
 loadModelText(path.join(__dirname, 'models/textDetection/model.json')); // Adjust path as per your folder structure

// Error handling middleware
app.use((err, req, res, next) => {
    console.error(err.stack);
    res.status(500).json({ error: 'Internal server error' });
});

const PORT = process.env.PORT || 8080;
app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
});
