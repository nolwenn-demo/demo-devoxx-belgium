package org.authenticator;

import com.google.zxing.WriterException;
import java.io.IOException;
import java.util.Scanner;
import org.apache.log4j.Logger;

import static org.authenticator.Utils.generateSecretKey;

public class Main {
  private static final Logger logger = Logger.getLogger(Main.class);

  public static void main(String[] args) throws IOException, WriterException {
    String secretKey = generateSecretKey();
    String email = "test@gmail.com";
    String companyName = "Awesome Company";
    String barCodeUrl = Utils.getGoogleAuthenticatorBarCode(secretKey, email, companyName);
    Utils.createQRCode(barCodeUrl, "QRCode.png", 400, 400);

    logger.info("Please enter 2fA code here -> ");
    Scanner scanner = new Scanner(System.in);
    String code = scanner.nextLine();
    if (code.equals(Utils.getTOTPCode(secretKey))) {
      logger.info("Logged in successfully");
    } else {
      logger.info("Invalid 2FA Code");
    }
    logger.info("The end");
  }
}