package com.myproject;

import java.util.HashMap;
import java.util.Map;
/* * ATENÇÃO: Os imports abaixo dependem da biblioteca Jackson.
 * Para que funcionem, o projeto deve ser um projeto Maven ou Gradle
 * e a dependência 'jackson-databind' deve estar no seu pom.xml ou build.gradle.
 */
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {
    public static void main(String[] args) {

        var json = """
                {"name":"João","age":30}\
                """;

        /*
         * --- ALTERNATIVA PROFISSIONAL (Requer Maven) ---
         * * Esta é a forma recomendada em projetos reais (Spring Boot, APIs, etc).
         * Em vez de manipular strings manualmente com split() e replace(),
         * utilizamos uma biblioteca de "Data Binding" como o Jackson.
         * * Vantagens:
         * 1. Ignora espaços e quebras de linha automaticamente.
         * 2. Converte tipos de dados (ex: 'age' vira um Integer automaticamente).
         * 3. Suporta estruturas complexas (JSON dentro de JSON).
         * * Para usar, adicione esta dependência no seu pom.xml:
         * <dependency>
         * <groupId>com.fasterxml.jackson.core</groupId>
         * <artifactId>jackson-databind</artifactId>
         * <version>2.17.0</version>
         * </dependency>
         */

        /*
         * // Exemplo de implementação (comentei para não quebrar seu código atual):
         * 
         * try {
         * ObjectMapper mapper = new ObjectMapper();
         * // Converte a String JSON diretamente para um Map
         * Map<String, Object> map = mapper.readValue(json, Map.class);
         * System.out.println("Resultado com Jackson: " + map);
         * } catch (JsonProcessingException e) {
         * System.err.println("Erro ao converter JSON: " + e.getMessage());
         * }
         */

        // --- ALTERNATIVA AO BLOCO COMENTADO ACIMA (LÓGICA MANUAL) ---
        var value = json;

        Map<String, String> map = new HashMap<>();
        value = value.replace("{", "").replace("}", "").replace("\"", "").trim();
        var valueArr = value.split(",");
        for (var v : valueArr) {
            var keyValue = v.split(":");
            map.put(keyValue[0].trim(), keyValue[1].trim());
        }
        System.out.println(map);

    }

}
