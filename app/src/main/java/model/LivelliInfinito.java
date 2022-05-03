package model;

public class LivelliInfinito {
    //In teoria è la classe che crea un livello generico per poi essere usato per n° livelli

    public static int NORTH = 0; //sti int indicano la posix delle img
    public static int EAST = 1;
    public static int SOUTH = 2;
    public static int WEST = 3;
    private int width;
    private int height;
    private Grid [][] board; //classe copiata, potrebbe funzionare (all'1%)


    public LivelliInfinito(int width, int height){
        this.width = width;
        this.height = height;
        board = new Grid [width][height];

    }
    public LivelliInfinito(LivelliInfinito livelliInfinito){
        this.height = livelliInfinito.height;
        this.width = livelliInfinito.width;
        board = new Grid[height][width];
        Grid[][] clonedBoard = livelliInfinito.board;

    }


}
