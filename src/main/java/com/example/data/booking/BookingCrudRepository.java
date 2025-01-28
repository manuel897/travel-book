package com.example.data.booking;

import org.springframework.data.repository.CrudRepository;

public interface BookingCrudRepository extends CrudRepository<BookingDataModel, String> {
}
