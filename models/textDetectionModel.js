const tf = require('@tensorflow/tfjs-node');

let model;

// Load the custom model
async function loadModelText(modelPath) {
    model = await tf.loadLayersModel(`file://models/textDetection/model.json`);
    console.log('Custom model text loaded successfully');
}

// Tokenizer mockup
const tokenizer = {
    texts_to_sequences: (texts) => texts.map(text => text.split(/\s+/).map(word => word.toLowerCase().charCodeAt(0) - 'a'.charCodeAt(0) + 1)),
};

// Function to pad sequences
const padSequences = (sequences, maxlen) => {
    return sequences.map(seq => {
        if (seq.length > maxlen) {
            return seq.slice(0, maxlen);
        } else {
            return [...Array(maxlen - seq.length).fill(0), ...seq];
        }
    });
};



// Function to predict text
async function predict(inputText) {
    if (!model) {
        throw new Error('Model text has not been loaded yet');
    }

    const sequences = tokenizer.texts_to_sequences([inputText]);
    const paddedSequences = tf.tensor(padSequences(sequences, 200), [1, 200]);

    const predictions = model.predict(paddedSequences);
    const predictionResult = predictions.squeeze().arraySync()[0];
    const result = predictionResult > 0.5 ? 1 : 0;
    const keterangan = result === 1 ? 'Memiliki masalah kesehatan mental' : 'Tidak memiliki masalah kesehatan mental';

    return { result: result.toString(), keterangan };
}

module.exports = {
    loadModelText,
    predict,
};
