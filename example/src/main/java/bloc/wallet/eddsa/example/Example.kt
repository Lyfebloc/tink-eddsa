package bloc.wallet.eddsa.example

import bloc.wallet.eddsa.Ed25519Sign
import bloc.wallet.eddsa.Ed25519Verify
import bloc.wallet.eddsa.KeyPair
import okio.ByteString.Companion.toByteString

fun main() {
  val keyPair = KeyPair.newKeyPair(true)
  val signer = Ed25519Sign(keyPair.privateKey, true)
  val verifier = Ed25519Verify(keyPair.publicKey)

  val msg = "Hello world".toByteArray().toByteString()
  val sig = signer.sign(msg, true)
  val valid = verifier.verify(sig, msg)
  println("valid: $valid")
}