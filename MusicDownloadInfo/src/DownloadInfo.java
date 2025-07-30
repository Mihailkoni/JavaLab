public class DownloadInfo {
    private final String title;
    private int downloadCount;

    public DownloadInfo(String title) {
        this.title = title;
        this.downloadCount = 1;
    }

    public String getTitle() {
        return title;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void incrementTimesDownloaded() {
        downloadCount++;
    }
}
