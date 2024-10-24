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
        for(int i = 0; i < downloadList.size(); i++){
            if(downloadList.get(i).getTitle().equalsIgnoreCase(title)) {
                return downloadList.get(i);
            }
        }
        return null;
    }

    public void updateDownloads(List<String> titles)
    {
        for(int i = 0; i < titles.size(); i++){
            DownloadInfo info = getDownloadInfo(titles.get(i));
            if (info != null) {
                info.incrementTimesDownloaded();
            } else {
                downloadList.add(new DownloadInfo(titles.get(i)));
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
