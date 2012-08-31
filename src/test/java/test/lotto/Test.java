package test.lotto;

public class Test {
	public static void main(String[] args) {
		HttpDownloader.download("http://www.645lotto.net/downWinnerData.asp?sGameNo=&eGameNo=", "lotto.xsl");
	}
}
