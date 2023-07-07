package bloc.wallet.eddsa.example;

import okio.ByteString;
import bloc.wallet.eddsa.Ed25519Sign;
import bloc.wallet.eddsa.Ed25519Verify;
import bloc.wallet.eddsa.KeyPair;

public class Example {
  public static void main(String[] args) {
    KeyPair keyPair = KeyPair.newKeyPair(true);
    Ed25519Sign signer = Ed25519Sign.invoke(keyPair.getPrivateKey(), true);
    Ed25519Verify verifier = new Ed25519Verify(keyPair.getPublicKey());

    ByteString msg = ByteString.of("Hello world".getBytes());
    ByteString sig = signer.sign(msg, true);
    boolean valid = verifier.verify(sig, msg);
    System.out.println("valid: " + valid);
  }
}
