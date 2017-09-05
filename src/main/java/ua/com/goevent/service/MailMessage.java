package ua.com.goevent.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MailMessage {
    private final String from;
    private final String to;
    private final String subject;
    private final String text;
}
