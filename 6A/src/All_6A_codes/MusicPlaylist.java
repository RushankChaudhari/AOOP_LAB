package All_6A_codes;

//Q(v): Music PlayList Using LinkedList

import java.util.LinkedList;
import java.util.Scanner;

public class MusicPlaylist {
    private LinkedList<String> playlist;

    public MusicPlaylist() {
        playlist = new LinkedList<>();
    }

    public void addSong(String song) {
        playlist.add(song);
        System.out.println("Song added to the playlist.");
    }

    public void removeSong(String song) {
        if (playlist.remove(song)) {
            System.out.println("Song removed.");
        } else {
            System.out.println("Song not found.");
        }
    }

    public void moveSong(int fromIndex, int toIndex) {
        if (fromIndex >= 0 && fromIndex < playlist.size() && toIndex >= 0 && toIndex < playlist.size()) {
            String song = playlist.remove(fromIndex);
            playlist.add(toIndex, song);
            System.out.println("Song moved.");
        } else {
            System.out.println("Invalid indices.");
        }
    }

    public void displayPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("No songs in the playlist.");
        } else {
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println((i + 1) + ". " + playlist.get(i));
            }
        }
    }

    public static void main(String[] args) {
        MusicPlaylist playlist = new MusicPlaylist();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Song 2. Remove Song 3. Move Song 4. Display Playlist 5. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.println("Enter song name:");
                    String song = sc.nextLine();
                    playlist.addSong(song);
                    break;
                case 2:
                    System.out.println("Enter song name to remove:");
                    String removeSong = sc.nextLine();
                    playlist.removeSong(removeSong);
                    break;
                case 3:
                    System.out.println("Enter song index to move from:");
                    int fromIndex = sc.nextInt() - 1;
                    System.out.println("Enter song index to move to:");
                    int toIndex = sc.nextInt() - 1;
                    playlist.moveSong(fromIndex, toIndex);
                    break;
                case 4:
                    playlist.displayPlaylist();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option.");
                    sc.close();
            }
        }
    }
}

