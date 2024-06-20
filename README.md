Movie Recommendation API
This project provides a FastAPI-based web service for recommending movies based on genres and different moods. It fetches movie data from a specified CSV file hosted online.

Features
Get Genres: Retrieve a list of unique movie genres available in the dataset.
Random Movies: Get a random selection of movies.
Mood-Based Recommendations: Get movie recommendations based on different moods such as Angry, Sad, Happy, Disgust, Fear, Neutral, and Surprise.
Endpoints
1. Index
URL: /
Method: GET
Response: 404 Not Found
2. Get Genres
URL: /genres
Method: GET
Response: JSON list of genres
Description: Returns a sorted list of unique genres from the dataset.
3. Random Movies
URL: /random
Method: GET
Response: JSON list of random movie recommendations
Description: Returns a random selection of up to 10 movies from the dataset.
4. Angry Movies
URL: /angry
Method: GET
Response: JSON list of movie recommendations
Description: Returns up to 10 random movies from specific genres related to anger management such as Comedy, Drama, Music, Family, Adventure, Fantasy, Animation, and Science Fiction.
5. Sad Movies
URL: /sad
Method: GET
Response: JSON list of movie recommendations
Description: Returns up to 10 random movies from genres that can uplift the mood such as Comedy, Family, Romance, Animation, Music, Adventure, Fantasy, and Drama.
6. Happy Movies
URL: /happy
Method: GET
Response: JSON list of movie recommendations
Description: Returns up to 10 random movies from happy and uplifting genres such as Adventure, Animation, Music, Comedy, Family, Fantasy, Romance, and Science Fiction.
7. Disgust Movies
URL: /disgust
Method: GET
Response: JSON list of movie recommendations
Description: Returns up to 10 random movies from genres such as Comedy, Adventure, Fantasy, Animation, Music, Science Fiction, Family, and Mystery.
8. Fear Movies
URL: /fear
Method: GET
Response: JSON list of movie recommendations
Description: Returns up to 10 random movies from genres that can help counter fear such as Family, Comedy, Animation, Drama, Fantasy, Adventure, Romance, and Music.
9. Neutral Movies
URL: /neutral
Method: GET
Response: JSON list of movie recommendations
Description: Returns up to 10 random movies from neutral genres such as Documentary, Drama, History, Science Fiction, Mystery, Adventure, TV Movie, and War.
10. Surprise Movies
URL: /surprise
Method: GET
Response: JSON list of movie recommendations
Description: Returns up to 10 random movies from genres that can surprise the viewer such as Mystery, Thriller, Science Fiction, Adventure, Fantasy, Action, Drama, and Horror.
