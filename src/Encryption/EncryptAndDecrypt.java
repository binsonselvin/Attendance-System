// 
// Decompiled by Procyon v0.5.36
// 

package Encryption;

import java.security.PublicKey;
import java.security.KeyPair;
import java.security.Key;
import javax.crypto.Cipher;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.security.PrivateKey;

public class EncryptAndDecrypt
{
    TeacherCredentials tc;
    String[] encryptedPass;
    String[] decryptedPass;
    static PrivateKey pkey;
    
    public EncryptAndDecrypt() {
        this.tc = new TeacherCredentials();
        this.encryptedPass = new String[this.tc.passwordArray().length];
        this.decryptedPass = new String[this.tc.passwordArray().length];
    }
    
    public void encryptText() throws Exception {
        final String[] pass = this.tc.passwordArray();
        System.out.println(pass[1]);
        for (int i = 0; i < pass.length; ++i) {
            final Signature sign = Signature.getInstance("SHA256withRSA");
            final KeyPairGenerator keypairgen = KeyPairGenerator.getInstance("RSA");
            keypairgen.initialize(2048);
            final KeyPair pair = keypairgen.generateKeyPair();
            final PublicKey publickey = pair.getPublic();
            final PrivateKey privatekey = pair.getPrivate();
            EncryptAndDecrypt.pkey = pair.getPrivate();
            System.out.println("Pkey is = " + EncryptAndDecrypt.pkey);
            final Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publickey);
            final byte[] input = pass[i].getBytes();
            cipher.update(input);
            final byte[] cipherText = cipher.doFinal();
            final String convText = new String(cipherText);
            this.encryptedPass[i] = convText;
        }
    }
    
    public void decrypt(final PrivateKey privkey) throws Exception {
        for (int i = 0; i < this.encryptedPass.length; ++i) {
            final Signature sign = Signature.getInstance("SHA256withRSA");
            final KeyPairGenerator keypairgen = KeyPairGenerator.getInstance("RSA");
            keypairgen.initialize(2048);
            final KeyPair pair = keypairgen.generateKeyPair();
            final PublicKey publickey = pair.getPublic();
            final Cipher ciphers = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            ciphers.init(2, privkey);
            final byte[] b = this.encryptedPass[i].getBytes();
            ciphers.update(b);
            final byte[] dicipheredText = ciphers.doFinal();
            final String convText = new String(dicipheredText);
            this.decryptedPass[i] = convText;
            System.out.println(this.decryptedPass[i]);
        }
    }
    
    public static void main(final String[] args) throws Exception {
        final EncryptAndDecrypt ed = new EncryptAndDecrypt();
        ed.encryptText();
        for (int i = 0; i < ed.encryptedPass.length; ++i) {
            System.out.println(ed.encryptedPass[i]);
        }
        ed.decrypt(EncryptAndDecrypt.pkey);
    }
}
