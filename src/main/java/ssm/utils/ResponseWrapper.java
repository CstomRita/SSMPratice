package ssm.utils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午9:48 2018/11/15
 * @ Description：ResponseWrapper
 * @ Modified By：
 * @Version: $
 */
public class ResponseWrapper extends HttpServletResponseWrapper {
    /**
     * Constructs a response adaptor wrapping the given response.
     *
     * @param response
     * @throws IllegalArgumentException if the response is null
     */
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintWriter printWriter = new PrintWriter(outputStream);

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }
    @Override
    public PrintWriter getWriter() throws IOException {
        return printWriter;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return new ServletOutputStream() {
            @Override
            public void write(int b) throws IOException {
                outputStream.write(b);
            }
        };
    }

    public void flush(){
        try {
            printWriter.flush();
            printWriter.close();
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ByteArrayOutputStream getByteArrayOutputStream(){
        return outputStream;
    }


    public String getTextContent() {
        flush();
        return outputStream.toString();
    }
}
