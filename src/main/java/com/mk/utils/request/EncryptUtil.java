package com.mk.utils.request;

import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * DES相关加解密工具
 *
 * @author admin
 * @date 创建于2016年10月12日 09:55
 *
 */
@Service
public class EncryptUtil {
	private static final String desKey	= "nmzfcgdatacenter20181207";
	private static final Charset charset = Charset.forName("UTF8");

	public static void main(String args[]) {
		String content = "8NDZf3sCfXjesP6vS/ZHPw==";
		try {
			String id = decryptStringToBase64(content);
			System.out.println("id值 ---->" + id );
			//String encrypt = encryptStringToBase64(content);
			//String encrypt2 = encryptString(content,"12345678");
			//System.out.println("加密结果：" + encrypt2);
			//System.out.println("解密结果：" + decryptStringToBase64(encrypt));
			//System.out.println("解密结果：" + decryptString(encrypt2,"12345678"));
			System.out.println("test");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加密字符串
	 *
	 * @param code
	 *            需要加密的字符串
	 * @return 加密后的BASE64编码的字符串
	 * @throws Exception
	 */
	public static String encryptStringToBase64(String code) throws Exception {
		byte[] keyByte = desKey.getBytes(charset);
		// 创建一个空的八位数组,默认情况下为0
		byte[] byteTemp = new byte[8];
		// 将用户指定的规则转换成八位数组
		for (int i = 0; i < byteTemp.length && i < keyByte.length; i++) {
			byteTemp[i] = keyByte[i];
		}
		DESKeySpec mDesKeySpec = new DESKeySpec(desKey.getBytes(charset));
		// 创建一个密匙工厂，然后用它把DESKeySpec转换成
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey securekey = keyFactory.generateSecret(mDesKeySpec);
		Cipher mCipher = Cipher.getInstance("DES");
		mCipher.init(Cipher.ENCRYPT_MODE, securekey);
		byte encode[] = mCipher.doFinal(code.getBytes(charset));
		return new BASE64Encoder().encode(encode);


	}

	/**
	 * 解密字符串
	 * @param code
	 *            需要解密的BASE64编码的密文
	 * @return 解密后的明文字符串
	 * @throws Exception
	 */
	public static String decryptStringToBase64(String code) throws Exception {
		byte[] keyByte = desKey.getBytes(charset);
		// 创建一个空的八位数组,默认情况下为0
		byte[] byteTemp = new byte[8];
		// 将用户指定的规则转换成八位数组
		for (int i = 0; i < byteTemp.length && i < keyByte.length; i++) {
			byteTemp[i] = keyByte[i];
		}
		// 创建一个DESKeySpec对象
		DESKeySpec mDesKeySpec = new DESKeySpec(desKey.getBytes(charset));
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(mDesKeySpec);
		Cipher mCipher = Cipher.getInstance("DES");
		mCipher.init(Cipher.DECRYPT_MODE, securekey);
		byte decode[] = mCipher.doFinal(new BASE64Decoder().decodeBuffer(code));
		return new String(decode,charset);
	}


	/**
	 * 加密字符串
	 *
	 * @param code
	 *            需要加密的字符串
	 * @return 加密后的BASE64编码的字符串
	 * @throws Exception
	 */
	public static String encryptString(String code, String desKey) throws Exception {
		byte[] keyByte = desKey.getBytes(charset);
		// 创建一个空的八位数组,默认情况下为0
		byte[] byteTemp = new byte[8];
		// 将用户指定的规则转换成八位数组
		for (int i = 0; i < byteTemp.length && i < keyByte.length; i++) {
			byteTemp[i] = keyByte[i];
		}
		DESKeySpec mDesKeySpec = new DESKeySpec(desKey.getBytes(charset));
		// 创建一个密匙工厂，然后用它把DESKeySpec转换成
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey securekey = keyFactory.generateSecret(mDesKeySpec);
		Cipher mCipher = Cipher.getInstance("DES");
		mCipher.init(Cipher.ENCRYPT_MODE, securekey);
		byte encode[] = mCipher.doFinal(code.getBytes(charset));
		return new BASE64Encoder().encode(encode);
	}

	/**
	 * 解密字符串
	 *

	 * @param code
	 *            需要解密的BASE64编码的密文
	 * @return 解密后的明文字符串
	 * @throws Exception
	 */
	public static String decryptString(String code, String desKey) throws Exception {
		byte[] keyByte = desKey.getBytes(charset);
		// 创建一个空的八位数组,默认情况下为0
		byte[] byteTemp = new byte[8];
		// 将用户指定的规则转换成八位数组
		for (int i = 0; i < byteTemp.length && i < keyByte.length; i++) {
			byteTemp[i] = keyByte[i];
		}
		// 创建一个DESKeySpec对象
		DESKeySpec mDesKeySpec = new DESKeySpec(desKey.getBytes(charset));
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(mDesKeySpec);
		Cipher mCipher = Cipher.getInstance("DES");
		mCipher.init(Cipher.DECRYPT_MODE, securekey);
		byte decode[] = mCipher.doFinal(new BASE64Decoder().decodeBuffer(code));
		return new String(decode,charset);
	}

	/**
	 * 加密输入流，目前测试最大25M
	 *
	 * @param inputStream
	 *            需要加密的输入流
	 * @param desKey
	 *            用于DES加密的密钥(目前测试使用的是56位字符串)
	 * @return 加密后的输入流
	 */
	public static InputStream encrypt(InputStream inputStream, String desKey) {
		byte[] keyByte = null;
		try {
			keyByte = desKey.getBytes("utf-8");
		}catch (UnsupportedEncodingException e){}
		// 创建一个空的八位数组,默认情况下为0
		byte[] byteTemp = new byte[8];
		// 将用户指定的规则转换成八位数组
		for (int i = 0; i < byteTemp.length && i < keyByte.length; i++) {
			byteTemp[i] = keyByte[i];
		}
		Key key = new SecretKeySpec(byteTemp, "DES");
		Cipher mCipher;
		try {
			mCipher = Cipher.getInstance("DES");
			mCipher.init(Cipher.ENCRYPT_MODE, key);
			System.out.println("DES开始加密！");
			CipherInputStream cis = new CipherInputStream(inputStream, mCipher);
			return cis;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密输出流，目前测试最大25M
	 *
	 * @param filePath
	 *            需要解密的输出流
	 * @param desKey
	 *            用于DES解密的密钥(目前测试使用的是56位字符串)
	 * @return 解密后的输出流
	 * @throws Exception
	 */
	public static InputStream decrypt(String filePath, String desKey) throws Exception {
		FileInputStream keyFIS = null;
		byte[] keyByte = desKey.getBytes("utf-8");
		// 创建一个空的八位数组,默认情况下为0
		byte[] byteTemp = new byte[8];
		// 将用户指定的规则转换成八位数组
		for (int i = 0; i < byteTemp.length && i < keyByte.length; i++) {
			byteTemp[i] = keyByte[i];
		}
		Key key = new SecretKeySpec(byteTemp, "DES");
		Cipher cipherDecrypt;
		InputStream is = null;
		CipherOutputStream cos = null;
		try {
			System.out.println("开始解密");
			cipherDecrypt = Cipher.getInstance("DES");
			cipherDecrypt.init(Cipher.DECRYPT_MODE, key);
			is = new FileInputStream(filePath);
			OutputStream out = new ByteArrayOutputStream();
			cos = new CipherOutputStream(out, cipherDecrypt);
			byte[] buffer = new byte[1024];
			int r;
			while ((r = is.read(buffer)) >= 0) {
				cos.write(buffer, 0, r);
			}
//			cos.close();
			// out.close();
//			is.close();
			System.out.println("解密完成");
			return outputStreamToInputStream(out);
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
		catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (null != is){
				is.close();
			}
			if (null != cos){
				cos.close();
			}
		}
		return null;
	}

	/**
	 * outputStream转inputStream
	 *
	 * @param out
	 * @return
	 * @throws Exception
	 */
	public static ByteArrayInputStream outputStreamToInputStream(OutputStream out) throws Exception {
		ByteArrayOutputStream baos ;
		baos = (ByteArrayOutputStream) out;
		ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
		return swapStream;
	}
}
