import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 27931);
            OutputStream os = socket.getOutputStream();
            String message = "hello";
            os.write(message.getBytes());
            os.flush();
            os.close();
            socket.close();
            System.out.println("消息发送成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}