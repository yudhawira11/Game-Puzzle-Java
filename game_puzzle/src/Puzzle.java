import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

class Puzzle extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,next, mainMenuButton;

    //variabel untuk menyimpan waktu.
    private Timer timer;
    private int seconds;
    private static int bestTime;
    //=================================


    Puzzle(){
        super("Puzzle Game - JavaTpoint");
        b1=new JButton("1");
        b2=new JButton(" ");
        b3=new JButton("3");
        b4=new JButton("4");
        b5=new JButton("5");
        b6=new JButton("6");
        b7=new JButton("7");
        b8=new JButton("8");
        b9=new JButton("2");
        next=new JButton("next");

        // Set posisi dan ukuran tombol
        setButtonBounds();

        add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);add(b8);add(b9); add(next);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        next.addActionListener(this);

        next.setBackground(Color.black);
        next.setForeground(Color.green);
        setSize(250,300);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inisialisasi tombol "Kembali ke Menu Utama" (awalnya tidak terlihat)
        mainMenuButton = new JButton("Kembali ke Menu Utama");
        mainMenuButton.setBounds(5, 225, 175, 50);
        mainMenuButton.setVisible(true); // Tombol ini tidak terlihat saat awal
        mainMenuButton.addActionListener(e -> {
            new MainMenu(); // Tampilkan menu utama
            dispose(); // Tutup game puzzle
        });
        add(mainMenuButton);

        //variabel untuk waktu
        timer = new Timer();
        seconds = 0;
        bestTime = getBestTime(); // Mendapatkan skor waktu tercepat dari penyimpanan preferensi

        // Membuat timer untuk menghitung waktu
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seconds++;
                updateTimerLabel();
            }
        }, 1000, 1000); // Timer akan mulai setiap 1 detik

        // ... Konfigurasi jendela lainnya ...


    }//end of constructor

    //fungsi fungsi untuk mengelola waktu game
    private void updateTimerLabel() {
        String formattedTime = String.format("%02d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, seconds % 60);
        setTitle("Puzzle Game - " + formattedTime);

        if (isPuzzleSolved()) {
            timer.cancel(); // Menghentikan timer saat pemain memenangkan permainan
            if (seconds < bestTime || bestTime == 0) {
                bestTime = seconds;
                setBestTime(bestTime); // Menyimpan skor waktu tercepat
            }
        }
    }
    private boolean isPuzzleSolved() {
        // ... Logika untuk mengecek apakah puzzle telah diselesaikan ...
        return b1.getLabel().equals("1") && b2.getLabel().equals("2") && b3.getLabel().equals("3")
                && b4.getLabel().equals("4") && b5.getLabel().equals("5") && b6.getLabel().equals("6")
                && b7.getLabel().equals("7") && b8.getLabel().equals("8") && b9.getLabel().equals(" ");
    }
    public static int getBestTime() {
        return bestTime;
    }
    public static void setBestTime(int time) {
        bestTime = time;
    }
    //======================================================================================

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==next){
            String s=b4.getLabel();
            b4.setLabel(b9.getLabel());
            b9.setLabel(s);
            s=b1.getLabel();
            b1.setLabel(b5.getLabel());
            b5.setLabel(s);
            s=b2.getLabel();
            b2.setLabel(b7.getLabel());
            b7.setLabel(s);
        }
        if(e.getSource()==b1){
            String s=b1.getLabel();
            if(b2.getLabel().equals(" ")){ b2.setLabel(s); b1.setLabel(" ");}
            else if(b4.getLabel().equals(" ")){ b4.setLabel(s); b1.setLabel(" ");}
        }//end of if

        if(e.getSource()==b3){
            String s=b3.getLabel();
            if(b2.getLabel().equals(" ")){ b2.setLabel(s); b3.setLabel(" ");}
            else if(b6.getLabel().equals(" ")){ b6.setLabel(s); b3.setLabel(" ");}
        }//end of if

        if(e.getSource()==b2){
            String s=b2.getLabel();
            if(b1.getLabel().equals(" ")){ b1.setLabel(s); b2.setLabel(" ");}
            else if(b3.getLabel().equals(" ")){ b3.setLabel(s); b2.setLabel(" ");}
            else if(b5.getLabel().equals(" ")){ b5.setLabel(s); b2.setLabel(" ");}
        }//end of if

        if(e.getSource()==b4){
            String s=b4.getLabel();
            if(b1.getLabel().equals(" ")){ b1.setLabel(s); b4.setLabel(" ");}
            else if(b7.getLabel().equals(" ")){ b7.setLabel(s); b4.setLabel(" ");}
            else if(b5.getLabel().equals(" ")){ b5.setLabel(s); b4.setLabel(" ");}
        }//end of if

        if(e.getSource()==b5){
            String s=b5.getLabel();
            if(b2.getLabel().equals(" ")){ b2.setLabel(s); b5.setLabel(" ");}
            else if(b4.getLabel().equals(" ")){ b4.setLabel(s); b5.setLabel(" ");}
            else if(b6.getLabel().equals(" ")){ b6.setLabel(s); b5.setLabel(" ");}
            else if(b8.getLabel().equals(" ")){ b8.setLabel(s); b5.setLabel(" ");}
        }//end of if

        if(e.getSource()==b6){

            String s=b6.getLabel();
            if(b9.getLabel().equals(" ")){ b9.setLabel(s); b6.setLabel(" ");}
            else if(b3.getLabel().equals(" ")){ b3.setLabel(s); b6.setLabel(" ");}
            else if(b5.getLabel().equals(" ")){ b5.setLabel(s); b6.setLabel(" ");}

        }//end of if

        if(e.getSource()==b7){
            String s=b7.getLabel();
            if(b4.getLabel().equals(" ")){ b4.setLabel(s); b7.setLabel(" ");}
            else if(b8.getLabel().equals(" ")){ b8.setLabel(s); b7.setLabel(" ");}

        }//end of if

        if(e.getSource()==b8){
            String s=b8.getLabel();
            if(b7.getLabel().equals(" ")){ b7.setLabel(s); b8.setLabel(" ");}
            else if(b9.getLabel().equals(" ")){ b9.setLabel(s); b8.setLabel(" ");}
            else if(b5.getLabel().equals(" ")){ b5.setLabel(s); b8.setLabel(" ");}

        }//end of if

        if(e.getSource()==b9){
            String s=b9.getLabel();
            if(b6.getLabel().equals(" ")){ b6.setLabel(s); b9.setLabel(" ");}
            else if(b8.getLabel().equals(" ")){ b8.setLabel(s); b9.setLabel(" ");}

            if(b1.getLabel().equals("1")&&b2.getLabel().equals("2")&&b3.getLabel()
                    .equals("3")&&b4.getLabel().equals("4")&&b5.getLabel().equals("5")
                    &&b6.getLabel().equals("6")&&b7.getLabel().equals("7")&&b8.getLabel()
                    .equals("8")&&b9.getLabel().equals(" ")){
                JOptionPane.showMessageDialog(Puzzle.this,"!!!you won!!!");
                mainMenuButton.setVisible(true); // Tombol "Kembali ke Menu Utama" menjadi terlihat
            }



        }//end of if

    }//end of actionPerformed

    // Fungsi untuk mengatur ulang posisi dan ukuran tombol
    private void setButtonBounds() {
        int buttonWidth = 50;
        int buttonHeight = 40;
        int buttonGap = 10;
        int buttonY = 30;

        b1.setBounds(10, buttonY, buttonWidth, buttonHeight);
        b2.setBounds(70, buttonY, buttonWidth, buttonHeight);
        b3.setBounds(130, buttonY, buttonWidth, buttonHeight);

        b4.setBounds(10, buttonY + buttonHeight + buttonGap, buttonWidth, buttonHeight);
        b5.setBounds(70, buttonY + buttonHeight + buttonGap, buttonWidth, buttonHeight);
        b6.setBounds(130, buttonY + buttonHeight + buttonGap, buttonWidth, buttonHeight);

        b7.setBounds(10, buttonY + 2 * (buttonHeight + buttonGap), buttonWidth, buttonHeight);
        b8.setBounds(70, buttonY + 2 * (buttonHeight + buttonGap), buttonWidth, buttonHeight);
        b9.setBounds(130, buttonY + 2 * (buttonHeight + buttonGap), buttonWidth, buttonHeight);

        next.setBounds(50, buttonY + 3 * (buttonHeight + buttonGap), 100, 40);
    }

}
