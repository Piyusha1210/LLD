//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AmazonLocker amazonLocker = AmazonLocker.getInstance();
        String accessToken = amazonLocker.deliverPackage(123L, Size.MEDIUM);
        String accessToken2 = amazonLocker.deliverPackage(124L, Size.MEDIUM);

        amazonLocker.collectPackage(124L, accessToken);
        amazonLocker.collectPackage(124L, accessToken2);
    }
}