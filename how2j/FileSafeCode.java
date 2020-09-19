import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.CRC32;

public class FileSafeCode {
	/**
	 * ������ļ� md5��ȡgetMD5(); SHA1��ȡgetSha1() CRC32��ȡ getCRC32()
	 */
	protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };
	public static MessageDigest messagedigest = null;

	

	/**
	 * ��һ���ļ���ȡmd5ֵ
	 * 
	 * @return md5��
	 * @throws NoSuchAlgorithmException
	 */
	public static String getMD5(File file) throws IOException, NoSuchAlgorithmException {

		messagedigest = MessageDigest.getInstance("MD5");
		FileInputStream in = new FileInputStream(file);
		FileChannel ch = in.getChannel();
		MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
		messagedigest.update(byteBuffer);
		return bufferToHex(messagedigest.digest());
	}

	/**
	 * // * @param target �ַ��� ��һ���ַ�����md5ֵ // * @return md5 value //
	 */
	// public static String StringMD5(String target) {
	// return DigestUtils.md5Hex(target);
	// }

	/***
	 * ����SHA1��
	 * 
	 * @return String ��������G����ļ�
	 * @throws NoSuchAlgorithmException
	 */
	public static String getSha1(File file) throws OutOfMemoryError, IOException, NoSuchAlgorithmException {
		messagedigest = MessageDigest.getInstance("SHA-1");
		FileInputStream in = new FileInputStream(file);
		FileChannel ch = in.getChannel();
		MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
		messagedigest.update(byteBuffer);
		return bufferToHex(messagedigest.digest());
	}

	/**
	 * ��ȡ�ļ�SHA256��
	 * 
	 * @return String
	 */
	public static String getSha256(File file) throws OutOfMemoryError, IOException, NoSuchAlgorithmException {
		messagedigest = MessageDigest.getInstance("SHA-256");
		FileInputStream in = new FileInputStream(file);
		FileChannel ch = in.getChannel();
		MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
		messagedigest.update(byteBuffer);
		return bufferToHex(messagedigest.digest());
	}

	/**
	 * ��ȡ�ļ�CRC32��
	 * 
	 * @return String
	 */
	public static String getCRC32(File file) {
		CRC32 crc32 = new CRC32();
		// MessageDigest.get
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			byte[] buffer = new byte[8192];
			int length;
			while ((length = fileInputStream.read(buffer)) != -1) {
				crc32.update(buffer, 0, length);
			}
			return crc32.getValue() + "";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (fileInputStream != null)
					fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getMD5String(String s) {
		return getMD5String(s.getBytes());
	}

	public static String getMD5String(byte[] bytes) {
		messagedigest.update(bytes);
		return bufferToHex(messagedigest.digest());
	}

	/**
	 * @Description �������������
	 * @return String
	 */
	private static String bufferToHex(byte bytes[]) {
		return bufferToHex(bytes, 0, bytes.length);
	}

	private static String bufferToHex(byte bytes[], int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			appendHexPair(bytes[l], stringbuffer);
		}
		return stringbuffer.toString();
	}

	private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
		char c0 = hexDigits[(bt & 0xf0) >> 4];
		char c1 = hexDigits[bt & 0xf];
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}

	public static boolean checkPassword(String password, String md5PwdStr) {
		String s = getMD5String(password);
		return s.equals(md5PwdStr);
    }
    
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        String dirHead = "d:/Studio/JavaWay/AC/DC/";
        String name = "scared";
        String dirTail = ".gif";
        File f = new File(dirHead + name + dirTail);
        long t1 = System.currentTimeMillis();
        String fMD5 = getMD5(f);
        long t2 = System.currentTimeMillis();

        long t3 = System.currentTimeMillis();
        String fSha1 = getSha1(f);
        long t4 = System.currentTimeMillis();

        long t5 = System.currentTimeMillis();
        String fSha256 = getSha256(f);
        long t6 = System.currentTimeMillis();

        long t7 = System.currentTimeMillis();
        String fCRC32 = getSha256(f);
        long t8 = System.currentTimeMillis();

        System.out.println("���ļ���MD5ֵ��:" + fMD5);
        System.out.println("�ܺ�ʱ: " + (t2 - t1) + "ms");
        System.out.println("���ļ���SHA1ֵ��:" + fSha1);
        System.out.println("�ܺ�ʱ: " + (t4 - t3) + "ms");
        System.out.println("���ļ���SHA256ֵ��:" + fSha256);
        System.out.println("�ܺ�ʱ: " + (t6 - t5) + "ms");
        System.out.println("���ļ���CRC32ֵ��:" + fCRC32);
        System.out.println("�ܺ�ʱ: " + (t8 - t7) + "ms");
    }
}