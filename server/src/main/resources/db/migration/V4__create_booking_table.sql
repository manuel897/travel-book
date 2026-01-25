CREATE TABLE booking (
                         booking_id SERIAL,
                         name varchar(60) NOT NULL,
                         notes varchar(50),
                         number_plate varchar(50),
                         departure varchar(50),
                         arrival varchar(50),
                         planned_distance DOUBLE PRECISION,            -- plannedDistance -> planned_distance
                         unit_of_measurement VARCHAR(20),               -- unitOfMeasurement -> unit_of_measurement
                         start_time TIMESTAMP,                              -- start stays the same
                         finish_time TIMESTAMP,                                -- end stays the same
                         booking_status_id INT,                        -- bookingStatusId -> booking_status_id
                         first_driver_username VARCHAR(20),                 -- firstDriverId -> first_driver_id
                         second_driver_username VARCHAR(20),                -- secondDriverId -> second_driver_id
                         owner_username VARCHAR(20),                        -- ownerId -> owner_id
                         last_modified_at TIMESTAMP,                   -- lastModifiedAt -> last_modified_at
                         initial_quote DECIMAL(10, 2),
                         PRIMARY KEY (booking_id),
                         FOREIGN KEY (first_driver_username) REFERENCES person(username),
                         FOREIGN KEY (owner_username) REFERENCES person(username),
                         FOREIGN KEY (booking_status_id) REFERENCES booking_status(booking_status_id)
);