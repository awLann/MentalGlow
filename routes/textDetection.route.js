const express = require('express');
const router = express.Router();
const { predict } = require('../models/textDetectionModel');

// Text analysis route
router.post('/predict', async (req, res) => {
    try {
        const { text } = req.body;
        const result = await predict(text);
        res.json(result);
    } catch (error) {
        console.error('Prediction error:', error);
        res.status(500).json({ error: 'Internal server error' });
    }
});

module.exports = router;
