-- Insert test data into hostel_user table
INSERT INTO hostel_user (name, email, password, authority)
VALUES ('John Doe', 'john@example.com', '$2a$12$xntGGaOigb49zLPEwnHqiuWwRKaPofy3rf02OimZ9Z1cd.zmqk8YS', 'ADMIN'),
       ('Alice Smith', 'alice@example.com', '$2a$12$dI.8NHu.X//88M5dErUvi.7UrkpGTS/o99xqY9yNpgqy5uESdPHnO', 'USER'),
       ('Bob Johnson', 'bob@example.com', '$2a$12$.pNPt7gEootWNsffP.QdpuWOWqtcbgt5OJpgsMCPbgtVH0/YNm9ra', 'USER');

-- Insert test data into room table
INSERT INTO room (room_number, type, status, possible_livers, rent_price_per_day)
VALUES (101, 'BASIC', 'FREE', 1, 50.0),
       (102, 'PREMIUM', 'FREE', 2, 80.0),
       (103, 'BASIC', 'FREE', 4, 120.0),
       (104, 'BASIC', 'FREE', 1, 55.0),
       (105, 'PREMIUM', 'FREE', 2, 85.0),
       (106, 'BASIC', 'FREE', 1, 60.0),
       (107, 'PREMIUM', 'FREE', 2, 90.0),
       (108, 'BASIC', 'FREE', 4, 130.0),
       (109, 'BASIC', 'FREE', 1, 65.0),
       (110, 'PREMIUM', 'FREE', 2, 95.0);
