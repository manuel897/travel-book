package com.example.models;

public interface EntityConverter<Entity,DataModel> {
    Entity toEntity(DataModel d);
}

