const router = require('express').Router();
const passport = require('passport');

// Auth login
router.get('/login', (req, res) => {
    res.send('Login Page');
});

// Auth logout
router.get('/logout', (req, res) => {
    req.logout();
    res.redirect('/');
});

// Auth with Google
router.get('/google', passport.authenticate('google', {
    scope: ['profile']
}));

// Callback route for Google to redirect to
router.get('/google/redirect', passport.authenticate('google', {
    successRedirect: '/profile',
    failureRedirect: '/auth/login' // Redirect ke halaman login jika autentikasi gagal
}));

module.exports = router;