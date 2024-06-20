# MentalGlow Face and Text Detection Backend 

This is an Express-based backend application that provides APIs for face expression detection and text expression analysis. The application includes authentication using Google OAuth and routes for profile management.

## Table of Contents

- [Installation](#installation)
- [Folder Structure](#folder-structure)
- [Routes](#routes)
  - [Authentication Routes](#authentication-routes)
  - [Profile Routes](#profile-routes)
  - [Face Detection Routes](#face-detection-routes)
  - [Text Analysis Routes](#text-analysis-routes)
- [Middleware](#middleware)
- [Configuration](#configuration)
  - [Passport Configuration](#passport-configuration)
- [Starting the Application](#starting-the-application)
- [Troubleshooting](#troubleshooting)

## Installation

1. Clone the repository.
2. Run `npm install` to install all dependencies.
3. Create a `.env` file with the necessary environment variables (e.g., `SESSION_SECRET`, `GOOGLE_CLIENT_ID`, `GOOGLE_CLIENT_SECRET`).


### `middleware/`
Contains custom middleware for the application.

- **authMiddleware.js**: Middleware to ensure user authentication.

### `routes/`
Contains route definitions for different parts of the application.

- **auth.route.js**: Routes for authentication using Google OAuth.
- **profile.route.js**: Routes for handling user profiles.
- **faceDetection.route.js**: Routes for face detection functionality.
- **textDetection.route.js**: Routes for text analysis functionality.

### `models/`
Contains the model loading and prediction logic for both face detection and text analysis.

- **faceDetectionModel.js**: Loads and performs predictions using the face detection model.
- **textDetectionModel.js**: Loads and performs predictions using the text analysis model.

### `config/`
Contains configuration files for the application.

- **passportConfig.js**: Configuration for Passport.js authentication strategies.
- **config.js**: General configuration settings (not specified here, but typically used for database configuration, etc.).

### Root Files

- **app.js**: The main application file that sets up the server and routes.
- **.env**: Environment variables for the application.
- **package.json**: Node.js project dependencies and scripts.
- **package-lock.json**: Lockfile for Node.js dependencies.

## Routes

### Authentication Routes

**File:** `routes/auth.route.js`

These routes handle user authentication using Google OAuth.

- `GET /auth/login`
  - Renders the login page.
  
- `GET /auth/logout`
  - Logs the user out and redirects to the home page.

- `GET /auth/google`
  - Initiates Google OAuth authentication.

- `GET /auth/google/redirect`
  - Handles the callback from Google OAuth authentication.
  - Redirects to the profile page on success or login page on failure.

### Profile Routes

**File:** `routes/profile.route.js`

These routes handle user profile operations.

- `GET /profile`
  - Requires authentication.
  - Displays the profile page for the logged-in user.

### Face Detection Routes

**File:** `routes/faceDetection.route.js`

These routes handle face detection operations.

- `POST /face-detection/predict`
  - Expects an image file upload.
  - Performs face detection on the uploaded image.
  - Returns the prediction result.

Example request with Postman:
1. Set the request method to POST.
2. Set the request URL to `http://localhost:8080/face-detection/predict`.
3. In the `Body` tab, select `form-data`.
4. Add a key named `image` and set the type to `File`.
5. Choose an image file to upload.
6. Send the request to get the prediction result.

### Text Analysis Routes

**File:** `routes/textDetection.route.js`

These routes handle text analysis operations.

- `POST /text-analysis/predict`
  - Expects a JSON body with a `text` field.
  - Analyzes the provided text.
  - Returns the analysis result.

Example request with Postman:
1. Set the request method to POST.
2. Set the request URL to `http://localhost:8080/text-analysis/predict`.
3. In the `Body` tab, select `raw` and choose `JSON` format.
4. Enter the following JSON:
   ```json
   {
     "text": "Your text here"
   }


