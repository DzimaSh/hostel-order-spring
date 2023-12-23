-- Insert test data into hostel_user table
INSERT INTO hostel_user (name, email, password, authority)
VALUES ('John Doe', 'john@example.com', '$2a$12$xntGGaOigb49zLPEwnHqiuWwRKaPofy3rf02OimZ9Z1cd.zmqk8YS', 'ADMIN'),
       ('Alice Smith', 'alice@example.com', '$2a$12$dI.8NHu.X//88M5dErUvi.7UrkpGTS/o99xqY9yNpgqy5uESdPHnO', 'USER'),
       ('Bob Johnson', 'bob@example.com', '$2a$12$.pNPt7gEootWNsffP.QdpuWOWqtcbgt5OJpgsMCPbgtVH0/YNm9ra', 'USER');
