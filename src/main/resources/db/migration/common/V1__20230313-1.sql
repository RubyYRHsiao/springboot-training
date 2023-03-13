DROP TABLE IF EXISTS test;

CREATE TABLE IF NOT EXISTS test
(
    id   bigserial   NOT NULL,
    name varchar(20) NOT NULL,
    CONSTRAINT test_pkey PRIMARY KEY (id)
);

INSERT INTO test (name) VALUES ('test1');