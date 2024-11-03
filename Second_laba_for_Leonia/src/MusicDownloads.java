import java.util.ArrayList;
import java.util.List;

public class MusicDownloads {
    private List<DownloadInfo> downloadList;

    public MusicDownloads()
    {
        downloadList = new ArrayList<DownloadInfo>();
    }

    public DownloadInfo getDownloadInfo(String title)
    {
        for (DownloadInfo downloadInfo : downloadList) {
            if (downloadInfo.getTitle().equalsIgnoreCase(title)) {
                return downloadInfo;
            }
        }
        return null;
    }

    public void updateDownloads(List<String> titles)
    {
        for (String title : titles) {
            DownloadInfo info = getDownloadInfo(title);
            if (info != null) {
                info.incrementTimesDownloaded();
            } else {
                downloadList.add(new DownloadInfo(title));
            }
        }
    }

    public void print(){
        if(!downloadList.isEmpty()){
            for(int i = 0; i < downloadList.size(); i++){
                System.out.println(i + "." + downloadList.get(i).getTitle() + " --> " + downloadList.get(i).getDownloadCount() + " скачиваний");
            }
        }
    }

    public boolean isEmpty(){
        return downloadList.isEmpty();
    }
}
