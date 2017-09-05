package ua.com.goevent.service;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class MailMessage {
    private final String from;
    private final String to;
    private final String subject;
    private final String text;
}
