import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GeneratedWindow  {

    //Animation for waiting to song to donwload-------------------------------------------------------------------------
    static ArrayList<String> WaitingAnimation = new ArrayList<>();
    static int frameAnimation = 0;
    static boolean SongIsDownload = false;
    static String SongLink;
    static String SongTitle;
    static String SongArtist;
    static String SongAlbum;
    static String SongAlbumPosition;
    static String SongGender;
    static MusicDownloaderEngine musicDownloader;
    static String AlbumPath;

    public static void Window(){
        // Initializing the musicDownloader object
        try {
            musicDownloader = new MusicDownloaderEngine();
        } catch (Exception e) {e.printStackTrace();}
        //the first process please ignore-------------------------------------------------------------------------------
        WaitingAnimation.add("(´•ω•｀) Downloading...");
        WaitingAnimation.add("(´•ω•｀) Downloading.. .");
        WaitingAnimation.add("(´•ω•｀) Downloading..  .");
        WaitingAnimation.add("(´•ω•｀) Downloading..   .");
        WaitingAnimation.add("(´•ω•｀) Downloading..    .");
        WaitingAnimation.add("(´•ω•｀) Downloading..     .");
        WaitingAnimation.add("(´•ω•｀) Downloading..      .");
        WaitingAnimation.add("(´•ω•｀) Downloading..       .");
        WaitingAnimation.add("(´•ω•｀) Downloading..        .");
        WaitingAnimation.add("(´•ω•｀) Downloading..         .");
        WaitingAnimation.add("(´•ω•｀) Downloading..          .");
        WaitingAnimation.add("(´•ω•｀) Downloading..           .");
        WaitingAnimation.add("(´•ω•｀) Downloading..          .");
        WaitingAnimation.add("(´•ω•｀) Downloading..         .");
        WaitingAnimation.add("(´•ω•｀) Downloading..        .");
        WaitingAnimation.add("(´•ω•｀) Downloading..       .");
        WaitingAnimation.add("(´•ω•｀) Downloading..      .");
        WaitingAnimation.add("(´•ω•｀) Downloading..     .");
        WaitingAnimation.add("(´•ω•｀) Downloading..    .");
        WaitingAnimation.add("(´•ω•｀) Downloading..   .");
        WaitingAnimation.add("(´•ω•｀) Downloading..  .");
        WaitingAnimation.add("(´•ω•｀) Downloading.. .");
        WaitingAnimation.add("(´•ω•｀) Downloading...");
        WaitingAnimation.add("(´•ω•｀) Downloading...");
        WaitingAnimation.add("(-_-#) Downloading.. .");
        WaitingAnimation.add("(-_-#) Downloading..  .");
        WaitingAnimation.add("(-_-#) Downloading..   .");
        WaitingAnimation.add("(-_-#) Downloading..    .");
        WaitingAnimation.add("(-_-#) Downloading..     .");
        WaitingAnimation.add("(-_-#) Downloading..      .");
        WaitingAnimation.add("(-_-#) Downloading..       .");
        WaitingAnimation.add("(-_-#) Downloading..        .");
        WaitingAnimation.add("(-_-#) Downloading..         .");
        WaitingAnimation.add("(-_-#) Downloading..          .");
        WaitingAnimation.add("(-_-#) Downloading..           .");
        WaitingAnimation.add("(-_-#) Downloading..          .");
        WaitingAnimation.add("(-_-#) Downloading..         .");
        WaitingAnimation.add("(-_-#) Downloading..        .");
        WaitingAnimation.add("(-_-#) Downloading..       .");
        WaitingAnimation.add("(-_-#) Downloading..      .");
        WaitingAnimation.add("(-_-#) Downloading..     .");
        WaitingAnimation.add("(-_-#) Downloading..    .");
        WaitingAnimation.add("(-_-#) Downloading..   .");
        WaitingAnimation.add("(-_-#) Downloading..  .");
        WaitingAnimation.add("(-_-#) Downloading.. .");
        WaitingAnimation.add("(-_-#) Downloading...");
        WaitingAnimation.add("(-_-#) Downloading...");
        WaitingAnimation.add("(－－)zzz Downloading.. .");
        WaitingAnimation.add("(－－)zzz Downloading..  .");
        WaitingAnimation.add("(－－)zzz Downloading..   .");
        WaitingAnimation.add("(－－)zzz Downloading..    .");
        WaitingAnimation.add("(－－)zzz Downloading..     .");
        WaitingAnimation.add("(－－)zzz Downloading..      .");
        WaitingAnimation.add("(－－)zzz Downloading..       .");
        WaitingAnimation.add("(－－)zzz Downloading..        .");
        WaitingAnimation.add("(－－)zzz Downloading..         .");
        WaitingAnimation.add("(－－)zzz Downloading..          .");
        WaitingAnimation.add("(－－)zzz Downloading..           .");
        WaitingAnimation.add("(－－)zzz Downloading..          .");
        WaitingAnimation.add("(－－)zzz Downloading..         .");
        WaitingAnimation.add("(－－)zzz Downloading..        .");
        WaitingAnimation.add("(－－)zzz Downloading..       .");
        WaitingAnimation.add("(－－)zzz Downloading..      .");
        WaitingAnimation.add("(－－)zzz Downloading..     .");
        WaitingAnimation.add("(－－)zzz Downloading..    .");
        WaitingAnimation.add("(－－)zzz Downloading..   .");
        WaitingAnimation.add("(－－)zzz Downloading..  .");
        WaitingAnimation.add("(－－)zzz Downloading.. .");
        WaitingAnimation.add("(－－)zzz Downloading...");
        WaitingAnimation.add("(－－)zzz Downloading...");


        //Frame settings////////////////////////////////////////////////////////////////////////////////////////////////
        JFrame frame = new JFrame();
        frame.setTitle("Toniná - DownloadSpace");
        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ScreenWidth = (int) ScreenSize.getWidth();
        int ScreenHeight = (int) ScreenSize.getHeight();
        frame.setSize(ScreenWidth,ScreenHeight);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon Logo = new ImageIcon("Images/TonináLogo.png");
        frame.setIconImage(Logo.getImage());
        frame.getContentPane().setBackground(new Color(43, 43, 43));
        frame.setLayout(new BorderLayout());

        //Creating componentts, Left PANEL//////////////////////////////////////////////////////////////////////////////
        JLabel LinkLabel = new JLabel();
        LinkLabel.setText("Link:");
        LinkLabel.setFont(new Font("Arial",Font.PLAIN, 30));
        LinkLabel.setForeground(Color.WHITE);
        LinkLabel.setPreferredSize(new Dimension(250,70));
        LinkLabel.setBackground(new Color(50, 50, 50));
        LinkLabel.setOpaque(true);
        JTextField LinkTextField = new JTextField();
        LinkTextField.setCaretColor(Color.WHITE);
        LinkTextField.setPreferredSize(new Dimension(1000,70));
        LinkTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        LinkTextField.setBackground(new Color(50, 50, 50));
        LinkTextField.setFont(new Font("Arial",Font.PLAIN, 25));
        LinkTextField.setForeground(Color.WHITE);
        JPanel LinkPanel = new JPanel();
        LinkPanel.setLayout(new BorderLayout());
        LinkPanel.setBackground(new Color(50, 50, 50));
        LinkPanel.add(LinkLabel, BorderLayout.WEST);
        LinkPanel.add(LinkTextField);

        JLabel TitleLabel = new JLabel();
        TitleLabel.setText("Title:");
        TitleLabel.setFont(new Font("Arial",Font.PLAIN, 30));
        TitleLabel.setForeground(Color.WHITE);
        TitleLabel.setPreferredSize(new Dimension(250,70));
        TitleLabel.setBackground(new Color(50, 50, 50));
        TitleLabel.setOpaque(true);
        JTextField TitleTextField = new JTextField();
        TitleTextField.setCaretColor(Color.WHITE);
        TitleTextField.setPreferredSize(new Dimension(1000,70));
        TitleTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        TitleTextField.setBackground(new Color(50, 50, 50));
        TitleTextField.setFont(new Font("Arial",Font.PLAIN, 25));
        TitleTextField.setForeground(Color.WHITE);
        JPanel TitlePanel = new JPanel();
        TitlePanel.setLayout(new BorderLayout());
        TitlePanel.setBackground(new Color(50, 50, 50));
        TitlePanel.add(TitleLabel,BorderLayout.WEST);
        TitlePanel.add(TitleTextField);

        JLabel ArtistLabel = new JLabel();
        ArtistLabel.setText("Artist:");
        ArtistLabel.setFont(new Font("Arial",Font.PLAIN, 30));
        ArtistLabel.setForeground(Color.WHITE);
        ArtistLabel.setPreferredSize(new Dimension(250,70));
        ArtistLabel.setBackground(new Color(50, 50, 50));
        ArtistLabel.setOpaque(true);
        JTextField ArtistTextField = new JTextField();
        ArtistTextField.setCaretColor(Color.WHITE);
        ArtistTextField.setPreferredSize(new Dimension(1000,70));
        ArtistTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        ArtistTextField.setBackground(new Color(50, 50, 50));
        ArtistTextField.setFont(new Font("Arial",Font.PLAIN, 25));
        ArtistTextField.setForeground(Color.WHITE);
        JPanel ArtistPanel = new JPanel();
        ArtistPanel.setLayout(new BorderLayout());
        ArtistPanel.setBackground(new Color(50, 50, 50));
        ArtistPanel.add(ArtistLabel, BorderLayout.WEST);
        ArtistPanel.add(ArtistTextField);

        JLabel AlbumLabel = new JLabel();
        AlbumLabel.setText("Album:");
        AlbumLabel.setFont(new Font("Arial",Font.PLAIN, 30));
        AlbumLabel.setForeground(Color.WHITE);
        AlbumLabel.setPreferredSize(new Dimension(250,70));
        AlbumLabel.setBackground(new Color(50, 50, 50));
        AlbumLabel.setOpaque(true);
        JTextField AlbumTextField = new JTextField();
        AlbumTextField.setCaretColor(Color.WHITE);
        AlbumTextField.setPreferredSize(new Dimension(1000,70));
        AlbumTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        AlbumTextField.setBackground(new Color(50, 50, 50));
        AlbumTextField.setFont(new Font("Arial",Font.PLAIN, 25));
        AlbumTextField.setForeground(Color.WHITE);
        JPanel AlbumPanel = new JPanel();
        AlbumPanel.setLayout(new BorderLayout());
        AlbumPanel.setBackground(new Color(50, 50, 50));
        AlbumPanel.add(AlbumLabel,BorderLayout.WEST);
        AlbumPanel.add(AlbumTextField);

        JLabel AlbumPositionLabel = new JLabel();
        AlbumPositionLabel.setText("Album position:");
        AlbumPositionLabel.setFont(new Font("Arial",Font.PLAIN, 30));
        AlbumPositionLabel.setForeground(Color.WHITE);
        AlbumPositionLabel.setPreferredSize(new Dimension(250,70));
        AlbumPositionLabel.setBackground(new Color(50, 50, 50));
        AlbumPositionLabel.setOpaque(true);
        JTextField AlbumPositionTextField = new JTextField();
        AlbumPositionTextField.setCaretColor(Color.WHITE);
        AlbumPositionTextField.setPreferredSize(new Dimension(1000,70));
        AlbumPositionTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        AlbumPositionTextField.setBackground(new Color(50, 50, 50));
        AlbumPositionTextField.setFont(new Font("Arial",Font.PLAIN, 25));
        AlbumPositionTextField.setForeground(Color.WHITE);
        JPanel AlbumPositionPanel = new JPanel();
        AlbumPositionPanel.setLayout(new BorderLayout());
        AlbumPositionPanel.setBackground(new Color(50, 50, 50));
        AlbumPositionPanel.add(AlbumPositionLabel,BorderLayout.WEST);
        AlbumPositionPanel.add(AlbumPositionTextField);

        JLabel GenderLabel = new JLabel();
        GenderLabel.setText("Gender:");
        GenderLabel.setFont(new Font("Arial",Font.PLAIN, 30));
        GenderLabel.setForeground(Color.WHITE);
        GenderLabel.setPreferredSize(new Dimension(250,70));
        GenderLabel.setBackground(new Color(50, 50, 50));
        GenderLabel.setOpaque(true);
        JTextField GenderTextField = new JTextField();
        GenderTextField.setCaretColor(Color.WHITE);
        GenderTextField.setPreferredSize(new Dimension(1000,70));
        GenderTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        GenderTextField.setBackground(new Color(50, 50, 50));
        GenderTextField.setFont(new Font("Arial",Font.PLAIN, 25));
        GenderTextField.setForeground(Color.WHITE);
        JPanel GenderPanel = new JPanel();
        GenderPanel.setLayout(new BorderLayout());
        GenderPanel.setBackground(new Color(50, 50, 50));
        GenderPanel.add(GenderLabel, BorderLayout.WEST);
        GenderPanel.add(GenderTextField);

        //Creating components south-------------------------------------------------------------------------------------
        JLabel ProgressBar = new JLabel();
        ProgressBar.setForeground(Color.WHITE);
        ProgressBar.setBackground(new Color(40,40,40));
        ProgressBar.setOpaque(true);
        ProgressBar.setPreferredSize(new Dimension(1900,800));
        ProgressBar.setFont(new Font("Arial", Font.PLAIN, 70));
        ProgressBar.setText("(^-^*)/  HIIIIII WELCOME BACK ٩(^ᴗ^)۶");

        //Creating components Right PANEL-------------------------------------------------------------------------------
        JButton AlbumImageButton = new JButton();
        AlbumImageButton.setPreferredSize(new Dimension(300, 300));
        AlbumImageButton.setFont(new Font("Arial", Font.PLAIN, 20));
        AlbumImageButton.setBackground(new Color(50,50,50));
        AlbumImageButton.setForeground(Color.WHITE);
        AlbumImageButton.setText("Choose the album image...");
        AlbumImageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProgressBar.setText("(⌒_⌒;) Please choose a image for the album (๑˃ᴗ˂)ﻭ");
                if (e.getSource()==AlbumImageButton){
                    JFileChooser AlbumImageFileChooser = new JFileChooser();
                    int UserResponse = AlbumImageFileChooser.showOpenDialog(null);
                    if (UserResponse == JFileChooser.APPROVE_OPTION){
                        ProgressBar.setText("(灬º‿º灬)♡ GREAT CHOICE!!!! (ᗒᗨᗕ)");
                        File AlbumAbsolutePathFile = new File(AlbumImageFileChooser.getSelectedFile().getAbsolutePath());
                        AlbumPath = String.valueOf(AlbumAbsolutePathFile);
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read(new File(AlbumAbsolutePathFile.toURI()));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        Image dimg = img.getScaledInstance(AlbumImageButton.getWidth(), AlbumImageButton.getHeight(),
                                Image.SCALE_SMOOTH);
                        ImageIcon AlbumIcon = new ImageIcon(dimg);
                        AlbumImageButton.setIcon(AlbumIcon);
                    }
                }
            }
        });

        JButton ResetButton = new JButton();
        ResetButton.setPreferredSize(new Dimension(300, 100));
        ResetButton.setFont(new Font("Arial", Font.PLAIN, 20));
        ResetButton.setBackground(new Color(50,50,50));
        ResetButton.setForeground(Color.WHITE);
        ResetButton.setText("Reset");
        ResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==ResetButton){
                    ProgressBar.setText("＼(≧▽≦)／  Everything has been reset uwu ＼(≧▽≦)／");
                    LinkTextField.setText("");
                    TitleTextField.setText("");
                    ArtistTextField.setText("");
                    AlbumTextField.setText("");
                    AlbumPositionTextField.setText("");
                    GenderTextField.setText("");
                    AlbumImageButton.setIcon(null);
                }
            }
        });

        JButton DownloadButton = new JButton();
        DownloadButton.setPreferredSize(new Dimension(300, 100));
        DownloadButton.setFont(new Font("Arial", Font.PLAIN, 20));
        DownloadButton.setBackground(new Color(50,50,50));
        DownloadButton.setForeground(Color.WHITE);
        DownloadButton.setText("Download");
        DownloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==DownloadButton){
                    frameAnimation = 0;
                    /*-------------------------------------------------------------------------------*/
                    /*This is the line that calls the music downloader engine and starts the download*/
                    downloadSong(TitleTextField.getText(),ArtistTextField.getText(),
                            AlbumTextField.getText(),AlbumPositionTextField.getText(),
                            GenderTextField.getText(),LinkTextField.getText());
                    /*-------------------------------------------------------------------------------*/
                    Timer timer = new Timer();
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            ProgressBar.setText(WaitingAnimation.get(frameAnimation));
                            frameAnimation++;
                            if (frameAnimation >= WaitingAnimation.size()){
                                // Restarting the downloading animation...
                                frameAnimation = 0;
                            }

                            if(musicDownloader.getHasSongBeenDownloaded()){
                                // Stop the animation
                                timer.cancel();
                                ProgressBar.setText("(･_･)b Your download has been completed ( ღ˘⌣˘ღ )");
                                return;
                            }
                        }
                    };
                    timer.scheduleAtFixedRate(task, 0,500);
                }
            }
        });

        ////////////////////////Creating Panels/////////////////////////////////////////////////////////////////////////
        JPanel SongInfoPanel = new JPanel();
        SongInfoPanel.setBackground(new Color(40, 40, 40));
        SongInfoPanel.setLayout(new GridLayout(6,1, 10,10));
        JPanel DownloadPanel = new JPanel();
        DownloadPanel.setBackground(new Color(76, 76, 76));
        DownloadPanel.setLayout(new FlowLayout());
        DownloadPanel.setPreferredSize(new Dimension(600, 100));
        JPanel AnimationPanel = new JPanel();
        AnimationPanel.setPreferredSize(new Dimension(100,450));
        AnimationPanel.setLayout(new BorderLayout());
        AnimationPanel.setBackground(new Color(30,30,30));

        //////////////////Adding components to panels///////////////////////////////////////////////////////////////////
        SongInfoPanel.add(LinkPanel);
        SongInfoPanel.add(TitlePanel);
        SongInfoPanel.add(ArtistPanel);
        SongInfoPanel.add(AlbumPanel);
        SongInfoPanel.add(AlbumPositionPanel);
        SongInfoPanel.add(GenderPanel);

        DownloadPanel.add(AlbumImageButton);
        DownloadPanel.add(ResetButton);
        DownloadPanel.add(DownloadButton);

        AnimationPanel.add(ProgressBar,BorderLayout.CENTER);

        ////////////////////////////////////////////Adding panels and refreshing the frame//////////////////////////////
        frame.add(SongInfoPanel,BorderLayout.CENTER);
        frame.add(DownloadPanel,BorderLayout.EAST);
        frame.add(AnimationPanel,BorderLayout.SOUTH);
        SwingUtilities.updateComponentTreeUI(frame);
    }

    private static void downloadSong(String songTitle, String artistName, String albumName, String positionInAlbum,
                                     String songGenre, String youtubeUrl){
        /*The download starts in a new thread so that animation in the user interface can happen.*/
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                musicDownloader.setHasSongBeenDownloaded(false);
                musicDownloader.downloadSong(songTitle,artistName,albumName,positionInAlbum,
                        songGenre,youtubeUrl,AlbumPath);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
