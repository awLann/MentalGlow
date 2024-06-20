# Tracks Recommendation API

This project provides a Flask-based web service for recommending music tracks based on user moods. It uses the Spotify API to fetch user's top tracks and recommends new tracks based on the specified mood.

## Features

- **Login with Spotify:** Authenticate using Spotify OAuth to access user's top tracks.
- **Mood-Based Recommendations:** Get track recommendations based on different moods such as Happy, Sad, Angry, Disgust, Fear, and Surprise.
- **YouTube and Spotify Links:** Generate YouTube and Spotify links for the recommended tracks.

## Endpoints

### 1. Index

- **URL:** `/`
- **Method:** `GET`
- **Response:** 404 Not Found

### 2. Login

- **URL:** `/login`
- **Method:** `GET`
- **Parameters:**
  - `mood` (query parameter) - Mood for which to generate recommendations (e.g., happy, sad, angry, etc.)
- **Response:** Redirects to Spotify OAuth login page.
- **Description:** Initiates the OAuth process with Spotify and sets mood-based parameters.

### 3. Callback

- **URL:** `/callback`
- **Method:** `GET`
- **Response:** Redirects to `/getTracks` if authentication is successful, otherwise redirects to `/login`.
- **Description:** Handles the Spotify OAuth callback and stores the access token in the session.

### 4. Get Tracks

- **URL:** `/getTracks`
- **Method:** `GET`
- **Response:** JSON containing user's top tracks, recommended tracks, YouTube links, and Spotify links.
- **Description:** Retrieves user's top tracks and generates recommendations based on the specified mood. Generates YouTube and Spotify links for the recommended tracks.

## Setup

### Prerequisites

- Python 3.12
- Flask
- Spotipy

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/awLann/MentalGlow/tree/Spotify-API/
    cd Spotify-API
    ```

2. Create VENV:

    ```bash
    (Windows)
    py -3 -m venv .venv
    .venv\Scripts\activate
    ```

3. Install the required packages:

    ```bash
    pip install flask spotipy
    ```

4. Set the `CLIENT_ID` and `CLIENT_SECRET` variables in `main.py` to your Spotify API credentials.

### Running the Server

Start the Flask server:

```bash
python main.py
or
flask run
```

### Example Usage

To initiate the login process with a specified mood, make a GET request to:

```bash
http://0.0.0.0:8000/login?mood=angry
```
