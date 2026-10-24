package com.ilicitan_airlines.backend.logging.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

@Service
@Slf4j
public class ActivityLogsService {
    private static final int MAX_LINES = 1000;
    private final Path logPath;

    public ActivityLogsService(@Value("${logging.file.name}") String logFile) {
        this.logPath = Path.of(logFile).toAbsolutePath().normalize();
    }

    public List<String> getLastLines(int limit) {
        if (limit < 1 || limit > MAX_LINES) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid line limit");
        if (!Files.isRegularFile(logPath) || !Files.isReadable(logPath)) throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Log file unavailable");

        Deque<String> buffer = new ArrayDeque<>(limit);

        try (BufferedReader reader = Files.newBufferedReader(logPath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (buffer.size() == limit) buffer.removeFirst();
                buffer.addLast(line);
            }
        } catch (IOException e) {
            log.error("Unable to read logs", e);
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Unable to read logs");
        }

        return List.copyOf(buffer);
    }
}
