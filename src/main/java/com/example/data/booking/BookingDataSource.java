package com.example.data.booking;

import org.springframework.data.repository.CrudRepository;

public interface BookingDataSource extends CrudRepository<BookingDataModel, Integer> {}
