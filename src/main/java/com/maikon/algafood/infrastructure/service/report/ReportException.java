package com.maikon.algafood.infrastructure.service.report;

import java.io.Serial;

public class ReportException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ReportException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReportException(String message) {
        super(message);
    }

}
