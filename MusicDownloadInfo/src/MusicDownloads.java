import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MusicDownloads {
    private final List<DownloadInfo> downloadList;

    public MusicDownloads() {
        downloadList = new ArrayList<>();
    }

    public DownloadInfo getDownloadInfo(String title) {
        for (DownloadInfo downloadInfo : downloadList) {
            if (downloadInfo.getTitle().equalsIgnoreCase(title)) {
                return downloadInfo;
            }
        }
        return null;
    }

    public void updateDownloads(List<String> titles) {
        for (String title : titles) {
            DownloadInfo info = getDownloadInfo(title);
            if (info != null) {
                info.incrementTimesDownloaded();
            } else {
                downloadList.add(new DownloadInfo(title));
            }
        }
    }

    public void printDownloads() {
        if (!downloadList.isEmpty()) {
            for (int i = 0; i < downloadList.size(); i++) {
                String title = downloadList.get(i).getTitle();
                int downloadCount = downloadList.get(i).getDownloadCount();
                StringBuilder stringBuilder = new StringBuilder()
                        .append(i)
                        .append(".")
                        .append(title)
                        .append(" --> ")
                        .append(downloadCount)
                        .append(" скачиваний");
                System.out.println(stringBuilder);
            }
        } else {
            System.out.println("Список пуст");
        }
    }
}
