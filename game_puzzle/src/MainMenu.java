import javax.swing.*;
import java.awt.*;


public class MainMenu extends JFrame {
    private JButton playButton, scoreButton, exitButton;

    public MainMenu() {
        super("Menu Utama Game Puzzle");

        playButton = new JButton("Main");
        scoreButton = new JButton("Lihat Skor Tercepat");
        exitButton = new JButton("Keluar");

        playButton.addActionListener(e -> {
            new Puzzle(); // Mulai game puzzle
            this.setVisible(false); // Sembunyikan menu utama
        });
        scoreButton.addActionListener(e -> {
            int bestTime = Puzzle.getBestTime();
            if (bestTime > 0) {
                JOptionPane.showMessageDialog(this, "Skor Tercepat: " + bestTime + " detik");
            } else {
                JOptionPane.showMessageDialog(this, "Belum ada skor tercepat.");
            }
        });
        exitButton.addActionListener(e -> System.exit(0)); // Keluar dari aplikasi

        // Setup layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Margin antar tombol

        // Menambahkan tombol ke layout
        add(playButton, gbc);
        add(scoreButton, gbc);
        add(exitButton, gbc);

        pack(); // Sesuaikan ukuran frame berdasarkan komponen
        setResizable(true); // Izinkan pengguna mengubah ukuran jendela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
