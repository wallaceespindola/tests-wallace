import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpStatus;
import org.junit.jupiter.api.Test;

@Slf4j
public class HttpClientTest
{
   @Test
   public final void givenGetRequestExecuted_whenAnalyzingTheResponse_thenCorrectStatusCode() throws IOException
   {
      final HttpGet request = new HttpGet("https://www.google.com");
      try (CloseableHttpClient client = HttpClientBuilder.create().build();
            CloseableHttpResponse response = client.execute(request))
      {
         log.info("Test1 - Response: {}", response);
         log.info("Test1 - Response entity: {}", response.getEntity());
         log.info("Test1 - Response headers: {}", response.getHeaders());
         assertThat(response.getCode(), equalTo(HttpStatus.SC_OK));
      }
   }

   @Test
   public final void givenGetRequestExecuted_whenAnalyzingTheResponse_thenBadStatusCode() throws IOException
   {
      final HttpGet request = new HttpGet("https://www.google.com/a-wrong-url");
      try (CloseableHttpClient client = HttpClientBuilder.create().build();
            CloseableHttpResponse response = client.execute(request))
      {
         log.info("Test2 - Response: {}", response);
         log.info("Test2 - Response entity: {}", response.getEntity());
         log.info("Test2 - Response headers: {}", response.getHeaders());
         assertThat(response.getCode(), equalTo(HttpStatus.SC_NOT_FOUND));
      }
   }

   @Test
   public final void givenGetRequestExecuted_whenAnalyzingTheResponse_thenResponseIsClosed() throws IOException
   {
      final HttpGet request = new HttpGet("https://www.google.com");
      try (CloseableHttpClient client = HttpClientBuilder.create().build();
            CloseableHttpResponse response = client.execute(request))
      {
         response.close(); // Close the response
         log.info("Test3 - Response: {}", response);
         log.info("Test3 - Response entity: {}", response.getEntity());
         log.info("Test3 - Response headers: {}", response.getHeaders());
         assertThat(response.getCode(), equalTo(HttpStatus.SC_OK));
      }
   }
}
