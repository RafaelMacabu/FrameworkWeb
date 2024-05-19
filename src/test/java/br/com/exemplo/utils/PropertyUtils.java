package br.com.exemplo.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    public static Properties propertyLoader(String filePath) {
        Properties properties = new Properties();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("falha ao carregar propriedades em " + filePath);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("arquivo de propriedades não foi encontrado em " + filePath);
        }
        return properties;
    }
}
