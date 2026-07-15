import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadConfig {
    private static final Logger logger = Logger.getLogger(ReadConfig.class);

    public static void main(String[] args) {
        String filePath = "C:\\Users\\18209\\AppData\\Local\\Temp\\f9976785-4b66-454c-94af-829d83d799dc_救援java代码(含服务器和智能体_ 官方无改).zip.9dc\\java\\adf-sample-agent-java-master\\config\\module.cfg";

        logger.info("开始读取配置文件: " + filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                if (line.contains(":")) {
                    String[] parts = line.split(":", 2);
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    System.out.println(key + " -> " + value);
                } else {
                    logger.warn("第 " + lineNumber + " 行格式不匹配（未包含 ':'）: " + line);
                }
            }
            logger.info("配置文件读取并解析成功，共处理了 " + lineNumber + " 行。");

        } catch (FileNotFoundException e) {
            logger.error("未找到配置文件，请检查路径是否正确: " + filePath, e);
        } catch (IOException e) {
            logger.error("读取配置文件时发生 I/O 错误: " + filePath, e);
        }
    }
}
