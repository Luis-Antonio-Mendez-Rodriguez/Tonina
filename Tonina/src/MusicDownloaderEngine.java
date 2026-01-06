import java.io.*;
import java.nio.file.*;

public class MusicDownloaderEngine {
    private static final String BINARIES_PATH = "/third_party_binaries/";
    private File ffmpegFile,yt_dlpFile;
    private boolean hasSongBeenDownloaded;

    /*Constructor*/
    public MusicDownloaderEngine() throws IOException {
        // Identifying in which operating system the program is running on.
        String osName = System.getProperty("os.name").toLowerCase();
        String ffmpegBinary = "";
        String yt_dlpBinary = "";

        // The binary to use will depend on the OS.
        if(osName.contains("mac")){
            ffmpegBinary = "ffmpeg_macos";
            yt_dlpBinary = "yt-dlp_macos";
        }else if(osName.contains("nux")){
            ffmpegBinary = "ffmpeg_linux_zorin";
            yt_dlpBinary = "yt-dlp_linux";
        }

        //Preparing the binaries so that they can actually be executed.
        InputStream inputStreamFFMPEG = MusicDownloaderEngine.class.getResourceAsStream(BINARIES_PATH+ffmpegBinary);
        InputStream inputStreamYT_DLP = MusicDownloaderEngine.class.getResourceAsStream(BINARIES_PATH+yt_dlpBinary);
        File tempDir = new File(System.getProperty("java.io.tmpdir"));

        // Preparing the Files
        ffmpegFile = new File(tempDir, ffmpegBinary);
        ffmpegFile.deleteOnExit();
        yt_dlpFile = new File(tempDir, yt_dlpBinary);
        yt_dlpFile.deleteOnExit();

        // Copying the files and making them executables
        Files.copy(inputStreamFFMPEG, ffmpegFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(inputStreamYT_DLP, yt_dlpFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        ffmpegFile.setExecutable(true);
        yt_dlpFile.setExecutable(true);
    }


    public void downloadSong(String songTitle, String artistName, String albumName, String positionInAlbum,
                             String songGenre, String youtubeUrl, String albumCover){
        // Building the download command
        String pathWhereSongWillBeDownloaded = extractPathFromImageLocation(albumCover);
        String songTitleCleaned = cleanString(songTitle);
        String artistNameCleaned = cleanString(artistName);
        String downloadedSongFileName = songTitleCleaned + "_" + artistNameCleaned + ".mp3";
        String[] downloadCommand = {yt_dlpFile.getAbsolutePath(),
                "-f",
                "bestaudio/best",
                "--extract-audio",
                "--audio-format",
                "mp3",
                "--audio-quality",
                "320K",
                "-o",
                pathWhereSongWillBeDownloaded + downloadedSongFileName,
                youtubeUrl
        };
        // Executing the download command
        ProcessBuilder downloadProcess = new ProcessBuilder(downloadCommand);
        downloadProcess.inheritIO();
        Process process;
        try {
            process = downloadProcess.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Waiting for the song to be downloaded
        try {
            if (process.waitFor() != 0) {
                System.err.println("yt_dlp failed with exit code ");
                return; // stop here if the download failed
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        // Building the set metadata command
        String songPath = pathWhereSongWillBeDownloaded + downloadedSongFileName;
        String songDownloadedFinished = pathWhereSongWillBeDownloaded + songTitleCleaned + "_" +
                artistNameCleaned + "_finished" + ".mp3";
        String[] ffmpegCommand = {
                ffmpegFile.getAbsolutePath(),
                "-y", // overwrite without asking
                "-i", songPath, // input MP3
                "-i", albumCover, // input cover image
                "-map", "0:a",
                "-map", "1:v",
                "-c", "copy",
                "-metadata", "title=" + songTitle,
                "-metadata", "artist=" + artistName,
                "-metadata", "album=" + albumName,
                "-metadata", "track=" + positionInAlbum,
                "-metadata", "genre=" + songGenre,
                songDownloadedFinished // overwrite same file
        };

        // Executing the set metadata command
        ProcessBuilder setUpMetadataProcess = new ProcessBuilder(ffmpegCommand);
        setUpMetadataProcess.inheritIO();
        Process newProcess;
        try {
            newProcess = setUpMetadataProcess.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Deleting temp file
        try {
            if (newProcess.waitFor() != 0) {
                System.err.println("yt_dlp failed with exit code ");
                return; // stop here if the download failed
            }
            File fileToDelete = new File(pathWhereSongWillBeDownloaded + downloadedSongFileName);
            fileToDelete.delete();
            hasSongBeenDownloaded = true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private String extractPathFromImageLocation(String albumCoverPath){
        int albumCoverPathLength = albumCoverPath.length();
        int firstSlashPosition = 0;
        // This "for loop" traverses the albumCoverPath in reverse to find the first slash.
        // Finding the slash gives us the chat position in order to extract just the path
        for(int x = albumCoverPathLength-1; x >= 0; x-- ){
            if(albumCoverPath.charAt(x) == '/'){
                firstSlashPosition = x;
                break;
            }
        }

        //Traversing the string to form the path of the image.
        StringBuilder path = new StringBuilder();
        for(int x = 0; x < firstSlashPosition+1; x++){
            path.append(albumCoverPath.charAt(x));
        }

        return path.toString();
    }


    private String cleanString(String stringToClean){
        StringBuilder cleanedString = new StringBuilder();
        for(int x = 0; x < stringToClean.length(); x++){
            if( isCharAForbiddenOne( stringToClean.charAt(x) ) ){
                cleanedString.append("_");
            }else{
                cleanedString.append(stringToClean.charAt(x));
            }
        }

        return cleanedString.toString();
    }


    private boolean isCharAForbiddenOne(char ch){
        char[] forbiddenChars = {'/','<','>',':','"','\\','|','?','*',' '};
        for (char forbiddenChar : forbiddenChars) {
            if (ch == forbiddenChar) {
                return true;
            }
        }
        return false;
    }


    public void setHasSongBeenDownloaded(boolean hasSongBeenDownloaded){
        this.hasSongBeenDownloaded = hasSongBeenDownloaded;
    }


    public boolean getHasSongBeenDownloaded(){
        return hasSongBeenDownloaded;
    }
}
