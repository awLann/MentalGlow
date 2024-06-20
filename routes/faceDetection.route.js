const router = require('express').Router();
const { predict } = require('../models/faceDetectionModel');
const multer = require('multer');
const upload = multer();

// Face detection route
router.post('/predict', upload.single('image'), async (req, res) => {
    try {
        const imageData = req.file.buffer;
        const result = await predict(imageData);
        res.json(result);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

module.exports = router;
