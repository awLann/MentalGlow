const router = require('express').Router();
const { ensureAuth } = require('../middleware/authMiddleware');

// Profile route
router.get('/', ensureAuth, (req, res) => {
    res.send(`Hello ${req.user.displayName}`);
});

module.exports = router;