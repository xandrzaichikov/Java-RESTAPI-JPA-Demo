CREATE TABLE event (
  id            SERIAL PRIMARY KEY,
  title         VARCHAR(64)   NOT NULL,
  description   VARCHAR(4096) NOT NULL,
  creation_time TIMESTAMP     NOT NULL DEFAULT now(),
  event_time    TIMESTAMP
);