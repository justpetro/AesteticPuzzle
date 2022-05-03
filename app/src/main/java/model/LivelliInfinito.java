package model;

import android.graphics.drawable.shapes.Shape;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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
        for(int i=0; i<height;i++) {
            for(int j =0; j<width;j++) {
                Grid s = clonedBoard[i][j];
                switch(s.getType()){
                    case 0 : board[i][j] = new EmptyShape(s.getOrientation(), i, j);break;
                    case 1 : board[i][j] = new QShape(s.getOrientation(), i, j);break;
                    case 2 : board[i][j] = new IShape(s.getOrientation(), i, j);break;
                    case 3 : board[i][j] = new TShape(s.getOrientation(), i, j);break;
                    case 4 : board[i][j] = new XShape(s.getOrientation(), i, j);break;
                    case 5 : board[i][j] = new LShape(s.getOrientation(), i, j);break;
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Grid[][] getBoard() {
        return board;
    }

    public void setBoard(Grid[][] board) {
        this.board = board;
    }
    /*Metodo per randomizzare i livelli
    public void generate() {
        Generator generator = new Generator(this);
        generator.generate();
    } */

    /* Metodo per creare un livello valido
    public void generateSolution() {
        Generator generator = new Generator(this);
        generator.generateSolution();
    }*/

    /**
     * Write the board in a file
     */
    public void write(String outputFile) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(outputFile);
        PrintStream ps = new PrintStream(fos);
        ps.println(height);
        ps.println(width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ps.println(board[i][j]);
            }
        }
        ps.close();
    }

    public boolean iShapeConnectedToBoardBorder(Grid grid) {
        int i = grid.getI();
        int j = grid.getJ();

        if(i>0 && j>0 && i<height-1 && j<width-1 ) {
            return false;
        }
        if(i == 0) {
            if(grid.getConnections()[NORTH]) {
                return true;
            }
        }
        else if(i == height-1) {
            if(grid.getConnections()[SOUTH]) {
                return true;
            }
        }
        if(j == 0) {
            if(grid.getConnections()[WEST]) {
                return true;
            }
        }
        else if(j == width-1) {
            if(grid.getConnections()[EAST]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if a shape is connected with North and West.

     */
    public boolean isShapeWellConnectedWithNorthAndWest(Grid grid) {
        return isShapeWellConnectedWithNorth(grid)&&isShapeWellConnectedWithWest(grid);
    }

    /**
     * Check if a shape is connected with North and East.
     */
    public boolean isShapeWellConnectedWithNorthAndEast(Grid grid) {
        return isShapeWellConnectedWithNorth(grid)&&isShapeWellConnectedWithEast(grid);
    }

    /**
     * Check if a shape is connected with South and East.
     * @param grid :shape to test
     * @return true if shape well connected
     */
    public boolean isShapeWellConnectedWithSouthAndEast(Grid grid) {
        return isShapeWellConnectedWithSouth(grid)&&isShapeWellConnectedWithEast(grid);
    }

    /**
     * Check if a shape is connected with South and West.
     * @param grid :grid to test
     * @return true if shape well connected
     */
    public boolean isShapeWellConnectedWithSouthAndWest(Grid grid) {
        return isShapeWellConnectedWithSouth(grid)&&isShapeWellConnectedWithWest(grid);
    }

    /**
     * Check if a shape is connected with North and South.
     * @param grid :shape to test
     * @return true if shape well connected
     */
    public boolean isShapeWellConnectedWithNorthAndSouth(Grid grid) {
        return isShapeWellConnectedWithSouth(grid)&&isShapeWellConnectedWithNorth(grid);
    }

    /**
     * Check if a shape is connected with East and West.
     * @param grid :shape to test
     * @return true if shape well connected
     */
    public boolean isShapeWellConnectedWithEastAndWest(Grid grid) {
        return isShapeWellConnectedWithEast(grid)&&isShapeWellConnectedWithWest(grid);
    }

    /**
     * Check if a shape is connected with East, North and West.
     * @param grid :shape to test
     * @return true if shape well connected
     */
    public boolean isShapeWellConnectedWithEastAndSouthAndWest(Grid grid) {
        return isShapeWellConnectedWithEast(grid)&&isShapeWellConnectedWithWest(grid)&&isShapeWellConnectedWithSouth(grid);
    }

    /**
     * Check if a shape is connected with North, South and West.
     * @param grid :shape to test
     * @return true if shape well connected
     */
    public boolean isShapeWellConnectedWithNorthAndSouthAndWest(Grid grid) {
        return isShapeWellConnectedWithNorth(grid)&&isShapeWellConnectedWithWest(grid)&&isShapeWellConnectedWithSouth(grid);
    }

    /**
     * Check if a shape is connected with North, East and West.
     * @param grid :shape to test
     * @return true if shape well connected
     */
    public boolean isShapeWellConnectedWithNorthAndEastAndWest(Grid grid) {
        return isShapeWellConnectedWithEast(grid)&&isShapeWellConnectedWithWest(grid)&&isShapeWellConnectedWithNorth(grid);
    }

    /**
     * Check if a shape is connected with North, East and South.
     * @param grid :shape to test
     * @return true if shape well connected
     */
    public boolean isShapeWellConnectedWithNorthAndEastAndSouth(Grid grid) {
        return isShapeWellConnectedWithEast(grid)&&isShapeWellConnectedWithSouth(grid)&&isShapeWellConnectedWithNorth(grid);
    }

    /**
     * Check if a shape is connected with South.
     * @param grid :shape to test
     * @return true if shape well connected
     */
    public boolean isShapeWellConnectedWithSouth(Grid grid) {
        boolean[] connections = grid.getConnections();
        int i = grid.getI();
        int j = grid.getJ();
        Grid neighbor = null;
        if(i+1<height) {
            neighbor = board[i+1][j];
        }
        if (neighbor != null ) {
            if(neighbor.getConnections()[NORTH]) {
                if (!connections[SOUTH]) {
                    return false;
                }
            }
            else if (connections[SOUTH]){
                return false;
            }
        }
        else if (connections[SOUTH]) {
            return false;
        }
        return true;
    }

    /**
     * Check if a shape is connected with North.
     */
    public boolean isShapeWellConnectedWithNorth(Grid grid) {
        boolean[] connections = grid.getConnections();
        int i = grid.getI();
        int j = grid.getJ();
        Grid neighbor = null;
        if(i-1>=0) {
            neighbor = board[i-1][j];
        }
        if (neighbor != null ) {
            if(neighbor.getConnections()[SOUTH]) {
                if (!connections[NORTH]) {
                    return false;
                }
            }
            else if (connections[NORTH]){
                return false;
            }
        }
        else if (connections[NORTH]) {
            return false;
        }
        return true;
    }


    /**
     * Check if a shape is connected with East.
     */
    public boolean isShapeWellConnectedWithEast(Grid grid) {
        boolean[] connections = grid.getConnections();
        int i = grid.getI();
        int j = grid.getJ();
        Grid neighbor = null;
        if(j+1<width) {
            neighbor = board[i][j+1];
        }
        if (neighbor != null ) {
            if(neighbor.getConnections()[WEST]) {
                if (!connections[EAST]) {
                    return false;
                }
            }
            else if (connections[EAST]){
                return false;
            }
        }
        else if (connections[EAST]) {
            return false;
        }
        return true;
    }

    /**
     * Check if a shape is connected with West.
     */
    public boolean isShapeWellConnectedWithWest(Grid grid) {
        boolean[] connections = grid.getConnections();
        int i = grid.getI();
        int j = grid.getJ();
        Grid neighbor = null;
        if(j-1>=0) {
            neighbor = board[i][j-1];
        }
        if (neighbor != null ) {
            if(neighbor.getConnections()[EAST]) {
                if (!connections[WEST]) {
                    return false;
                }
            }
            else if (connections[WEST]){
                return false;
            }
        }
        else if (connections[WEST]) {
            return false;
        }
        return true;
    }

    /**
     * Check if a shape is connected with North and West frozen neighbors.
     */
    public boolean isShapeWellConnectedWithNorthAndWestFrozenNeighbors(Grid grid) {
        //North
        int i = grid.getI();
        int j = grid.getJ();
        //NORTH
        Grid neighbor = null;
        if(i-1>=0) {
            neighbor = board[i-1][j];
        }
        if(neighbor != null && neighbor.isFrozen()) {
            if(!isShapeWellConnectedWithNorth(grid)) {
                return false;
            }
        }
        //WEST
        neighbor = null;
        if(j-1>=0) {
            neighbor = board[i][j-1];
        }
        if(neighbor != null && neighbor.isFrozen()) {
            if(!isShapeWellConnectedWithWest(grid)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if a shape is connected with all its frozen neighbors.
     * @param grid :shape to test
     * @return true if shape well connected
     */
    public boolean isShapeWellConnectedWithFrozenNeighbors(Grid grid) {
        //North
        int i = grid.getI();
        int j = grid.getJ();
        //NORTH
        Grid neighbor = null;
        if(i-1>=0) {
            neighbor = board[i-1][j];
        }
        if(neighbor != null && neighbor.isFrozen()) {
            if(!isShapeWellConnectedWithNorth(grid)) {
                return false;
            }
        }
        //WEST
        neighbor = null;
        if(j-1>=0) {
            neighbor = board[i][j-1];
        }
        if(neighbor != null && neighbor.isFrozen()) {
            if(!isShapeWellConnectedWithWest(grid)) {
                return false;
            }
        }
        //EAST
        neighbor = null;
        if(j+1<width) {
            neighbor = board[i][j+1];
        }
        if(neighbor != null && neighbor.isFrozen()) {
            if(!isShapeWellConnectedWithEast(grid)) {
                return false;
            }
        }
        //SOUTH
        neighbor = null;
        if(i+1<height) {
            neighbor = board[i+1][j];
        }
        if(neighbor != null && neighbor.isFrozen()) {
            if(!isShapeWellConnectedWithSouth(grid)) {
                return false;
            }
        }
        return true;


    }


    /**
     *  Check if the shapes are connected
     * @param shape1 first shape
     * @param shape2 second shape
     * @return true if the shapes are connected
     */
    public boolean areShapesConnected(Grid shape1,Grid shape2)
    {
        boolean areShapesConnected=false;
        if (shape1.getConnections()[EAST] && shape2.getConnections()[WEST] && shape1.getJ()+1==shape2.getJ()) areShapesConnected = true;
        else if (shape1.getConnections()[WEST] && shape2.getConnections()[EAST] && shape1.getJ()-1==shape2.getJ()) areShapesConnected = true;
        else if (shape1.getConnections()[NORTH] && shape2.getConnections()[SOUTH] && shape1.getI()-1==shape2.getI()) areShapesConnected = true;
        else if (shape1.getConnections()[SOUTH] && shape2.getConnections()[NORTH] && shape1.getI()+1==shape2.getI()) areShapesConnected = true;
        return areShapesConnected;
    }


    /**
     *  Check if one shape is looking at another one but they are not connected
     * @param shape1 the shape that is looking
     * @param shape2 the shape to test if it is looking back
     * @return true if the first shape has an orientation that points toward the second but they are not connected
     */
    public boolean lookingButNotConnected(Grid shape1,Grid shape2)
    {
        boolean cc=false;
        boolean[] connections = shape1.getConnections();
        Grid[] neighbors = getNeighbors(shape1);
        if (neighbors[NORTH] != null && neighbors[NORTH]==shape2 && connections[NORTH] && !shape2.hasConnection(SOUTH)) cc=true;
        if (neighbors[SOUTH] != null && neighbors[SOUTH]==shape2 && connections[SOUTH] && !shape2.hasConnection(NORTH)) cc=true;
        if (neighbors[EAST] != null && neighbors[EAST]==shape2 && connections[EAST] && !shape2.hasConnection(WEST))
        {
            cc=true;
        }
        if (neighbors[WEST] != null && neighbors[WEST]==shape2 && connections[WEST] && !shape2.hasConnection(EAST)) cc=true;
        return cc;

    }

    /**
     * Check is a shape is obstructed in a specific orientation

     */
    public boolean isObstructed(Grid grid, ArrayList<Grid> reservations)
    {
        boolean io=false;
        for (Grid sh:this.getConnectionNeighbors(grid))
        {
            if(sh.getType()!=0 && !reservations.contains(sh)) io=true;
        }
        return io;
    }


    /**
     *  Get the neighbors of a shape

     */
    public Grid[] getNeighbors(Grid grid){
        int i = grid.getI();
        int j = grid.getJ();

        Grid[] neighbors = new Grid[4];

        //north neighbor
        if(i-1>=0) {
            neighbors[NORTH] = board[i-1][j];
        }
        //south neighbor
        if(i+1<height) {
            neighbors[SOUTH] = board[i+1][j];
        }
        //east neighbor
        if(j+1<width) {
            neighbors[EAST] = board[i][j+1];
        }
        //west neighbor
        if(j-1>=0) {
            neighbors[WEST] = board[i][j-1];
        }
        return neighbors;
    }

    /**
     * Get the free neighbor of a shape
     */
    public Grid[] getToConnectNeighbors(Grid grid){
        int i = grid.getI();
        int j = grid.getJ();

        ArrayList<Grid> aux = new ArrayList<Grid>();
        boolean[] connections = grid.getConnections();

        //north neighbor
        if(i-1>=0 && connections[NORTH] && board[i-1][j]!=null && board[i-1][j].getType()==0 ) {
            aux.add(board[i-1][j]);
        }
        //south neighbor
        if(i+1<height && connections[SOUTH] && board[i+1][j]!=null && board[i+1][j].getType()==0 ) {
            aux.add(board[i+1][j]);
        }
        //east neighbor
        if(j+1<width  && connections[EAST] && board[i][j+1]!=null && board[i][j+1].getType()==0 ) {
            aux.add(board[i][j+1]);
        }
        //west neighbor
        if(j-1>=0  && connections[WEST] && board[i][j-1]!=null && board[i][j-1].getType()==0 ) {
            aux.add(board[i][j-1]);
        }
        Grid[] neighbors = new Grid[aux.size()];
        for (int k=0;k<aux.size();k++)
        {
            neighbors[k]=aux.get(k);
        }
        return neighbors;
    }

    /**
     * Get the connection neighbors (neighbors without the null ones)
     */
    public Grid[] getConnectionNeighbors(Grid grid){
        int i = grid.getI();
        int j = grid.getJ();

        ArrayList<Grid> aux = new ArrayList<Grid>();
        //Shape[] neighbors = new Shape[4];
        boolean[] connections = grid.getConnections();

        //north neighbor
        if(i-1>=0 && connections[NORTH] && board[i-1][j]!=null) {
            aux.add(board[i-1][j]);
        }
        //south neighbor
        if(i+1<height && connections[SOUTH] && board[i+1][j]!=null) {
            aux.add(board[i+1][j]);
        }
        //east neighbor
        if(j+1<width  && connections[EAST] && board[i][j+1]!=null) {
            aux.add(board[i][j+1]);
        }
        //west neighbor
        if(j-1>=0  && connections[WEST] && board[i][j-1]!=null) {
            aux.add(board[i][j-1]);
        }
        Grid[] neighbors = new Grid[aux.size()];
        for (int k=0;k<aux.size();k++)
        {
            neighbors[k]=aux.get(k);
        }
        return neighbors;
    }

    /**
     * Add a grid to the board

     */
    public void addShape(Grid grid) throws Exception {
        if(grid == null) {
            return;
        }
        int shapeI =grid.getI();
        int shapeJ = grid.getJ();
        if(board[shapeI][shapeJ] == null) {
            board[shapeI][shapeJ] = grid;
            return;
        }
        throw new Exception("There is already a shape at "+shapeI+","+shapeJ);
    }

    /**
     * Return the good orientation of a Qshape for a connection
     */
    public int getQOrientationForOpenConnection(Grid grid) //F
    {
        int qorientation=0;
        Grid[] scwNeighbours = this.getNeighbors(grid.getReservedBy().get(0));//Sinon passer pas les coordonnées
        if(!isShapeWellConnectedWithNorth(grid.getReservedBy().get(0)) && scwNeighbours[NORTH]==grid) qorientation= 2;
        else if (!isShapeWellConnectedWithEast(grid.getReservedBy().get(0)) && scwNeighbours[EAST]==grid) qorientation= 3;
        else if (!isShapeWellConnectedWithSouth(grid.getReservedBy().get(0)) && scwNeighbours[SOUTH]==grid) qorientation= 0;
        else if (!isShapeWellConnectedWithWest(grid.getReservedBy().get(0)) && scwNeighbours[WEST]==grid) qorientation= 1;
        return qorientation;
    }

    /**
     * Return the good orientation of a Thape for a connection
     */
    public int getTOrientationForOpenConnection(Grid grid)
    {
        int torientation=0;
        if(!isShapeWellConnectedWithNorth(grid)) torientation= 2;
        else if (!isShapeWellConnectedWithEast(grid)) torientation= 3;
        else if (!isShapeWellConnectedWithSouth(grid)) torientation= 0;
        else if (!isShapeWellConnectedWithWest(grid)) torientation= 1;
        return torientation;
    }

    /**
     * Check if the shape has an empty neighbor
     */
    public boolean hasEmptyNeighbor(Grid grid)
    {
        boolean hasEmptyNeighbor=false;
        Grid[] nb=this.getNeighbors(grid);
        for (Grid sh:nb)
        {
            if(sh!=null && sh.getType()==0) hasEmptyNeighbor=true;
        }
        return hasEmptyNeighbor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<height;i++) {
            for(int j =0; j<width;j++) {
                Grid grid = board[i][j];

                sb.append(grid.getSymbol());

            }
            sb.append("\n");
        }
        return sb.toString();
    }


}
