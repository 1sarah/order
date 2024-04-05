CREATE TABLE orders
(
    id       UUID             NOT NULL,
    name     VARCHAR(255),
    quantity INTEGER          NOT NULL,
    price    DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

CREATE TABLE users
(
    id     UUID    NOT NULL,
    name   VARCHAR(255),
    gender SMALLINT,
    age    INTEGER NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);