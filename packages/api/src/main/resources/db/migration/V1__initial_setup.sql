CREATE TABLE media (
  id BIGINT NOT NULL,
  title VARCHAR(255) NOT NULL,
  description TEXT NOT NULL,
  thumbnail_key VARCHAR(512) NOT NULL,
  release_date DATE NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
  --
  CONSTRAINT pk_media PRIMARY KEY (id)
);

CREATE TABLE movies (
  id BIGINT NOT NULL,
  duration_seconds INTEGER,
  manifest_key VARCHAR(512),
  streaming_format VARCHAR(16),
  --
  CONSTRAINT pk_movies PRIMARY KEY (id),
  --
  CONSTRAINT fk_movies_media FOREIGN KEY (id) REFERENCES media (id) ON DELETE CASCADE
);

CREATE TABLE series (
  id BIGINT NOT NULL,
  --
  CONSTRAINT pk_series PRIMARY KEY (id),
  --
  CONSTRAINT fk_series_media FOREIGN KEY (id) REFERENCES media (id) ON DELETE CASCADE
);

CREATE TABLE seasons (
  id BIGINT NOT NULL,
  season_number INTEGER NOT NULL,
  release_date DATE NOT NULL,
  thumbnail_key VARCHAR(512),
  series_id BIGINT NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
  --
  CONSTRAINT pk_seasons PRIMARY KEY (id),
  --
  CONSTRAINT fk_seasons_series FOREIGN KEY (series_id) REFERENCES series (id) ON DELETE CASCADE,
  --
  CONSTRAINT uq_seasons_series_id_season_number UNIQUE (series_id, season_number)
);

CREATE TABLE episodes (
  id BIGINT NOT NULL,
  title VARCHAR(255),
  description TEXT,
  episode_number INTEGER NOT NULL,
  release_date DATE NOT NULL,
  thumbnail_key VARCHAR(512),
  duration_seconds INTEGER,
  manifest_key VARCHAR(512),
  streaming_format VARCHAR(16),
  season_id BIGINT NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
  --
  CONSTRAINT pk_episodes PRIMARY KEY (id),
  --
  CONSTRAINT fk_episodes_season FOREIGN KEY (season_id) REFERENCES seasons (id) ON DELETE CASCADE,
  --
  CONSTRAINT uq_episodes_season_id_episode_number UNIQUE (season_id, episode_number)
);

CREATE TABLE genres (
  id BIGINT NOT NULL,
  name VARCHAR(64) NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
  --
  CONSTRAINT pk_genres PRIMARY KEY (id),
  --
  CONSTRAINT uq_genres_name UNIQUE (name)
);

CREATE TABLE media_genres (
  media_id BIGINT NOT NULL,
  genre_id BIGINT NOT NULL,
  --
  CONSTRAINT pk_media_genres PRIMARY KEY (media_id, genre_id),
  --
  CONSTRAINT fk_media_genres_media FOREIGN KEY (media_id) REFERENCES media (id) ON DELETE CASCADE,
  CONSTRAINT fk_media_genres_genre FOREIGN KEY (genre_id) REFERENCES genres (id) ON DELETE CASCADE
);

-- Reverse-lookup index for "which media belong to this genre".
-- The forward lookup (media -> genres) is already served by the leftmost
-- column of pk_media_genres.
CREATE INDEX idx_media_genres_genre_id ON media_genres (genre_id);
