const tf = require('@tensorflow/tfjs-node');

let model;
const height = 48;
const width = 48;

const classLabels = ['Angry', 'Happy', 'Neutral', 'Sad'];

// Load the custom model
async function loadModelFace(modelPath) {
    model = await tf.loadLayersModel(`file://models/faceDetection/model.json`);
    console.log('Custom face detection model loaded successfully');
}

// Function to predict face expression
async function predict(imageData) {
    if (!model) {
        throw new Error('face detection Model has not been loaded yet');
    }

    const imageTensor = await loadImageAndPreprocess(imageData);

    const prediction = model.predict(imageTensor);
    const result = await prediction.data();

    const maxIndex = result.indexOf(Math.max(...result));

    const topResult = {
        class: classLabels[maxIndex],
        probability: result[maxIndex]
    };

    return topResult;
}

// Helper function to load and preprocess image
async function loadImageAndPreprocess(imageData) {
    const imageTensor = tf.node.decodeImage(imageData, 3);
    const resizedImageTensor = tf.image.resizeBilinear(imageTensor, [height, width]);
    const normalizedImageTensor = resizedImageTensor.div(255.0);
    const expandedImageTensor = normalizedImageTensor.expandDims(0);

    return expandedImageTensor;
}

module.exports = {
    loadModelFace,
    predict,
};
