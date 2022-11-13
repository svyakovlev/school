CREATE TABLE user
(
    name varchar PRIMARY KEY,
    age integer,
    pasport boolean,
    carId integer REFERENCES car(carId);
);

CREATE TABLE car
(
    carId integer REFERENCES user(carId);
    typeAndModel text PRIMARY KEY;
    price integer;
);


