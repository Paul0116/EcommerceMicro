package com.main.modules.banner.domain.exception;

public class BannerAlreadyExistsException extends RuntimeException {
    public BannerAlreadyExistsException(String message) {
        super(message);
    }
}