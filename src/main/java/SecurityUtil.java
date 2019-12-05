import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.SecureRandom;

/**
 * 常用加解密工具类
 * @author DavidWang
 */
public class SecurityUtil {  
	private static String DES = "DES"; // optional value AES/DES/DESede  
    private static String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding"; // optional value AES/DES/DESede  
    private static String key = "DFer@1902大侠"; 

    /**
     * 字符串加密
     * @param context 需要加密的原文
     * @return 加密后密文
     * @throws Exception
     */
    public static String getSecret(String context) {
    	String cipherText = null; 
    	try {
    		cipherText = encrypt(context,key);
		} catch (Exception e) {

		} 
		return cipherText;
    }
    
    /**
     * 字符串加密
     * @param context 需要加密的原文
     * @return 加密后密文
     * @throws Exception
     */
    public static String getSecret(String context, String charset) {
    	String cipherText = null; 
    	try {
    		cipherText = encrypt(context, key, charset);
		} catch (Exception e) {
			//解密异常则用其他的解密编码方式进行解密
			try {
				cipherText = encrypt(context, key, "UTF-8");
			} catch (Exception e1) {
				try {
					cipherText = encrypt(context, key, "GBK");
				} catch (Exception e2) {

				}
			}
		} 
		return cipherText;
    }
    
    /**
     * 密文解密
     * @param cipherText 需要解密的密文
     * @return 解密后的原文
     * @throws Exception
     */
    public static String analyseSecret(String cipherText){
    	String originalText = null;
    	try {
			originalText = detrypt(cipherText,key);
		} catch (Exception e) {

		} 
		return originalText;
    }
    
    
    /**
     * 密文解密
     * @param cipherText 需要解密的密文
     * @return 解密后的原文
     * @throws Exception
     */
    public static String analyseSecret(String cipherText, String charset){
    	String originalText = null;
    	try {
			originalText = detrypt(cipherText, key, charset);
		} catch (Exception e) {

		} 
		return originalText;
    }
    
  
    public static Key getSecretKey(String key) throws Exception{  
        SecretKey securekey = null;  
        if(key == null){  
            key = "";  
        }  
        KeyGenerator keyGenerator = KeyGenerator.getInstance(DES);  
        //防止linux下 随机生成key   
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );  
        secureRandom.setSeed(key.getBytes());  
        keyGenerator.init(56,secureRandom);  
        securekey = keyGenerator.generateKey();  
        return securekey;  
    }  
    
    public static Key getSecretKey(String key, String charset) throws Exception{  
        SecretKey securekey = null;  
        if(key == null){  
            key = "";  
        }  
        KeyGenerator keyGenerator = KeyGenerator.getInstance(DES);  
        //防止linux下 随机生成key   
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );  
        secureRandom.setSeed(key.getBytes(charset));  
        keyGenerator.init(56,secureRandom);  
        securekey = keyGenerator.generateKey();  
        return securekey;  
    }  
      
    public static String encrypt(String data,String key) throws Exception {  
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        Key securekey = getSecretKey(key);  
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);  
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);  
        byte[] bt = cipher.doFinal(data.getBytes());  
        String strs = Base64.encode(bt);  
        return strs;  
    }  
      
    
    public static String encrypt(String data, String key, String charset) throws Exception {  
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        Key securekey = getSecretKey(key, charset);  
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);  
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);  
        byte[] bt = cipher.doFinal(data.getBytes(charset));  
        String strs = Base64.encode(bt);  
        return strs;  
    }  
    
      
    public static String detrypt(String message,String key) throws Exception{  
        SecureRandom sr = new SecureRandom();  
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);  
        Key securekey = getSecretKey(key);
        cipher.init(Cipher.DECRYPT_MODE, securekey,sr);  
        byte[] res = Base64.decode(message);
        res = cipher.doFinal(res);  
        return new String(res);  
    }  
    
    public static String detrypt(String message,String key, String charset) throws Exception{  
        SecureRandom sr = new SecureRandom();  
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);  
        Key securekey = getSecretKey(key, charset);  
        cipher.init(Cipher.DECRYPT_MODE, securekey,sr);  
        byte[] res = Base64.decode(message);  
        res = cipher.doFinal(res);  
        return new String(res, charset);
    }  
      
    public static void main(String[] args)throws Exception{  
//        String message = "杭一";  
//        String key = "aerwqeijrweo";  
//        String entryptedMsg = encrypt(message,key);  
//        System.out.println("encrypted message is below :");  
//        System.out.println(entryptedMsg);  
//          
//        String decryptedMsg = detrypt(entryptedMsg,key);  
//        System.out.println("decrypted message is below :");  
//        System.out.println(decryptedMsg);
        /*
    	 String filePath = "D:\\wangwd\\demo.xls";
    	 FileInputStream stream = new FileInputStream(filePath);
         HSSFWorkbook workbook = new HSSFWorkbook(stream);//读取现有的Excel
         HSSFSheet sheet= workbook.getSheet("Sheet1");
         for (Row row : sheet) {
			String value = row.getCell(1).getStringCellValue();
			String secret = analyseSecret(value);
			System.out.println(secret);
		}
		*/
        //默认编码GB18030（你没看错就是未指定字符集）
        String dataStr = "我是未加密的字符串123abcDEF";
        //加密
        String secretStr = SecurityUtil.getSecret(dataStr);
        System.out.println(secretStr);
        //解密
        String s = SecurityUtil.analyseSecret(secretStr);
        System.out.println(s);
    }  
}  
