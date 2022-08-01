package br.com.avaliacaoTecnica.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestUtil {

    public static ObjectMapper objectMapper = new ObjectMapper().registerModule(new ParameterNamesModule()).registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());

    public static String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    public static String readJsonFile(final String filePath) throws IOException {
        try {
            final File input = new ClassPathResource(filePath).getFile();
            return new String(Files.readAllBytes(Paths.get(input.getPath())));
        } catch (IOException e) {
            throw e;
        }
    }

    public static <T> T getObjectFromFile(String path, Class<T> objectClass) throws IOException {
        File file = new ClassPathResource(path).getFile();
        return objectMapper.readValue(file, objectClass);

    }
}
