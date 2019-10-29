package Ch01_ArraysAndStrings.Q1_03_URLify;

public class Question {

	/**
	 * 文字列のスペースをパーセントエンコーディングします
	 * @param inputChars 入力の文字列
	 * @param trueLength 文字列の後ろのバッファ用のスペースを除いた文字列の長さ
	 * @return スペースをパーセントエンコーディングした文字列
	 */
	public static String percentEncodingForSpace(final char[] inputChars, final int trueLength) {
		char[] outputChars = new char[inputChars.length];
		int buffers = inputChars.length - trueLength;
		for (int i = 0; i < trueLength; i++) {
			int inputReverseIndex = trueLength - i - 1;
			int outputReverseIndex = inputReverseIndex + buffers;
			if (inputChars[inputReverseIndex] == ' ') {
				outputChars[outputReverseIndex] = '0';
				outputChars[outputReverseIndex - 1] = '2';
				outputChars[outputReverseIndex - 2] = '%';
				buffers -= 2;
			} else {
				outputChars[outputReverseIndex] = inputChars[inputReverseIndex];
			}
		}
		return new String(outputChars);
	}

	/**
	 * 文字列の後ろのバッファ用のスペースを除いた文字列の長さを返却します
	 * @param charArray 文字列の配列
	 * @return 文字列の長さ
	 */
	private static int calcTrueLength(char[] charArray) {
		for (int i = 0; i < charArray.length; i++) {
			int reverseIndex = charArray.length - i - 1;
			if (charArray[reverseIndex] != ' ') {
				return reverseIndex + 1;
			}
		}
		return -1;
	}

	/**
	 * main関数
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strs = {"Mr John Smith    ", "Python Java C++ HTML      "};
		for (String str : strs) {
			char[] charArray = str.toCharArray();
			final int trueLength = calcTrueLength(charArray);
			System.out.println(percentEncodingForSpace(charArray, trueLength));
		}
	}
}
