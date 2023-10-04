import com.google.zxing.WriterException;
import java.io.IOException;
import org.authenticator.Utils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.authenticator.Utils.generateSecretKey;
import static org.authenticator.Utils.getGoogleAuthenticatorBarCode;
import static org.authenticator.Utils.getTOTPCode;

public class UtilsTest {

  @Test
  public void generateSecretKey_test() {
    assertThat(generateSecretKey()).isNotNull();
  }

  @Test
  public void getTOTPCode_test() {
    assertThat(getTOTPCode("string")).isNotNull();
  }

  @Test
  public void getGoogleAuthenticatorBarCode_test() {
    assertThat(getGoogleAuthenticatorBarCode("secret", "account", "issuer")).isNotNull();
  }

  @Test
  public void createQRCode() throws IOException, WriterException {
    Utils.createQRCode("barCodeData", "filePath", 5, 3);
  }
}
