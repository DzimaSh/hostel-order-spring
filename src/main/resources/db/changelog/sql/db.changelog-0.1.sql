-- Create sequence for HostelUser id
CREATE SEQUENCE IF NOT EXISTS hostel_user_seq
    START WITH 1
    INCREMENT BY 1;

-- Create HostelUser table
CREATE TABLE hostel_user
(
    id        BIGINT DEFAULT nextval('hostel_user_seq') PRIMARY KEY,
    name      VARCHAR(255),
    email     VARCHAR(255) UNIQUE NOT NULL,
    password  VARCHAR(255),
    authority VARCHAR(50)
);

-- Create sequence for Room id
CREATE SEQUENCE IF NOT EXISTS room_seq
    START WITH 1
    INCREMENT BY 1;

-- Create Room table
CREATE TABLE room
(
    id                 BIGINT DEFAULT nextval('room_seq') PRIMARY KEY,
    room_number        INT,
    type               VARCHAR(50),
    status             VARCHAR(50),
    possible_livers    BIGINT,
    rent_price_per_day DOUBLE PRECISION
);

-- Create sequence for Bill id
CREATE SEQUENCE IF NOT EXISTS bill_seq
    START WITH 1
    INCREMENT BY 1;

-- Create Bill table
CREATE TABLE bill
(
    id         BIGINT DEFAULT nextval('bill_seq') PRIMARY KEY,
    bill_price DOUBLE PRECISION,
    status     VARCHAR(50)
);

-- Create sequence for HostelOrder id
CREATE SEQUENCE IF NOT EXISTS hostel_order_seq
    START WITH 1
    INCREMENT BY 1;

-- Create HostelOrder table
CREATE TABLE hostel_order
(
    id                BIGINT DEFAULT nextval('hostel_order_seq') PRIMARY KEY,
    start_date        TIMESTAMP,
    end_date          TIMESTAMP,
    desired_room_type VARCHAR(50),
    desired_beds      INT,
    status            VARCHAR(50),
    client_id         BIGINT,
    bill_id           BIGINT
);

-- Create order_room table for many-to-many relationship between HostelOrder and Room
CREATE TABLE order_room
(
    order_id BIGINT,
    room_id  BIGINT,
    FOREIGN KEY (order_id) REFERENCES hostel_order (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (room_id) REFERENCES room (id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (order_id, room_id)
);

-- Add foreign key constraints
ALTER TABLE hostel_order
    ADD FOREIGN KEY (client_id) REFERENCES hostel_user (id) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD FOREIGN KEY (bill_id) REFERENCES Bill (id) ON DELETE CASCADE ON UPDATE CASCADE;
