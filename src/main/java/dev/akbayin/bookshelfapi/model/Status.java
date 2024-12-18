package dev.akbayin.bookshelfapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    READ,
    WANT_TO_READ,
    READING,
    NOT_READ

}